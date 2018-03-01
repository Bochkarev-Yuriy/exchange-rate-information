package exchange.rate.information.service.job;

import exchange.rate.information.model.Currency;
import exchange.rate.information.model.Job;
import exchange.rate.information.model.MonitoringExchange;
import exchange.rate.information.model.MonitoringExchangeRate;
import exchange.rate.information.service.*;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.util.*;

/**
 * @author Yuriy Bochkarev
 * @since 19.02.18.
 */

@Service
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class ExchangeRateInformationJobService extends QuartzJobBean {

    private final Logger logger = LoggerFactory.getLogger(ExchangeRateInformationJobService.class);
    private static boolean isRunning = false;

    @Autowired
    private MonitoringExchangeService monitoringExchangeService;

    @Autowired
    private MonitoringExchangeRateService monitoringExchangeRateService;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private ProxyService proxyService;

    @Autowired
    private JobService jobService;

    @Autowired
    private AdapterService adapterService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        if (isRunning) {
            return;
        }
        try {
            isRunning = true;
            execute();
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            isRunning = false;
        }
    }

    private void execute() {
        List<MonitoringExchange> monitoringExchangeList = monitoringExchangeService.getAllMonitoringExchange();

        for (MonitoringExchange monitoringExchange : monitoringExchangeList) {
            if (jobService.getJobByMonitoringExchangeId(monitoringExchange) == null) {
                Job job = new Job();
                job.setMonitoringExchange(monitoringExchange);
                job.setLastStartJob(new Date(0L));
                jobService.addJob(job);
            }
        }

        List<Job> jobs = jobService.getAllJob();
        for (Job job : jobs) {
            MonitoringExchange monitoringExchange = job.getMonitoringExchange();
            Date nextStartJob = new Date(job.getLastStartJob().getTime() + monitoringExchange.getInterval());
            if (new Date().after(nextStartJob)) {
                Currency sourceCurrency = monitoringExchange.getSourceCurrency();
                Set<Currency> currencies = monitoringExchange.getCurrencies();
                List<String> currenciesBriefName = new ArrayList<>();
                for (Currency currency : currencies) {
                    currenciesBriefName.add(currency.getBrief());
                }

                Map<String, Double> currentRateInformation =
                        adapterService.proxyCurrentRateInformationMapCastValidCurrentRateInformationMap(
                                proxyService.getCurrentRateInformation(sourceCurrency.getBrief(), currenciesBriefName), sourceCurrency.getBrief());
                Date lastMonitoringDate = new Date();

                for (String currencyBrief : currentRateInformation.keySet()) {
                    MonitoringExchangeRate monitoringExchangeRate = new MonitoringExchangeRate();
                    monitoringExchangeRate.setMonitoringExchange(monitoringExchange);
                    monitoringExchangeRate.setDate(lastMonitoringDate);
                    Currency currency = currencyService.getCurrencyByBrief(currencyBrief);
                    monitoringExchangeRate.setCurrency(currency);
                    monitoringExchangeRate.setRate(currentRateInformation.get(currencyBrief));
                    monitoringExchangeRateService.addMonitoringExchangeRate(monitoringExchangeRate);
                }
                job.setLastStartJob(lastMonitoringDate);
                jobService.updateJob(job);
            }
        }
    }
}
