package exchange.rate.information.config;

import exchange.rate.information.service.job.ExchangeRateInformationJobService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.text.ParseException;

/**
 * @author Yuriy Bochkarev
 * @since 19.02.18.
 */

@Configuration
public class ExchangeRateInformationSchedulerConfig {

    @Bean
    public JobDetailFactoryBean exchangeRateInformationJobService() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(ExchangeRateInformationJobService.class);
        jobDetailFactoryBean.setGroup("exchangeRateInformationJobServiceGroup");
        jobDetailFactoryBean.setName("exchangeRateInformationJobServiceName");
        jobDetailFactoryBean.setBeanName("exchangeRateInformationJobService");
        jobDetailFactoryBean.setDurability(true);
        WebApplicationContext currentWebApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        if (currentWebApplicationContext != null) {
            jobDetailFactoryBean.setApplicationContext(currentWebApplicationContext);
        }
        jobDetailFactoryBean.afterPropertiesSet();
        return jobDetailFactoryBean;
    }

    @Bean
    public CronTriggerFactoryBean exchangeRateInformationJobServiceTrigger() throws ParseException, IOException {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(exchangeRateInformationJobService().getObject());
        cronTriggerFactoryBean.setGroup("exchangeRateInformationJobServiceGroup");
        cronTriggerFactoryBean.setName("exchangeRateInformationJobServiceTriggerName");
        cronTriggerFactoryBean.setBeanName("exchangeRateInformationJobServiceTrigger");
        cronTriggerFactoryBean.setCronExpression("0 * * ? * *");
        cronTriggerFactoryBean.afterPropertiesSet();
        return cronTriggerFactoryBean;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws Exception {
        final SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
        scheduler.setAutoStartup(true);
        scheduler.setSchedulerName("scheduler");
        scheduler.setBeanName("schedulerFactoryBean");
        scheduler.setTriggers(exchangeRateInformationJobServiceTrigger().getObject());
        final WebApplicationContext currentWebApplicationContext
                = ContextLoader.getCurrentWebApplicationContext();
        if (currentWebApplicationContext != null) {
            scheduler.setApplicationContext(currentWebApplicationContext);
        }
        scheduler.afterPropertiesSet();
        return scheduler;
    }
}
