package exchange.rate.information.service.impl;

import exchange.rate.information.constant.Constant;
import exchange.rate.information.service.UrlBuilderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yuriy Bochkarev
 * @since 18.02.18.
 */

@Service
public class UrlBuilderServiceImpl implements UrlBuilderService {

	@Override
	public String live(String source, List<String> currencies) {
		StringBuilder liveUrl = new StringBuilder();
		liveUrl.append(Constant.PROXY_ROOT_ADDRESS + Constant.LIVE + Constant.PARAM_ACCESS_KEY + Constant.USER_ACCESS_KEY);
		if (source != null) {
			liveUrl.append(Constant.PARAM_SOURCE).append(source);
		}
		if (currencies != null) {
			liveUrl.append(Constant.PARAM_CURRENCIES).append(String.join(",", currencies));
		}
		return liveUrl.toString();
	}

	@Override
	public String list() {
		return Constant.PROXY_ROOT_ADDRESS + Constant.LIST + Constant.PARAM_ACCESS_KEY + Constant.USER_ACCESS_KEY;
	}
}
