package exchange.rate.information.service;

import java.util.List;

/**
 * @author Yuriy Bochkarev
 * @since 18.02.18.
 */

public interface UrlBuilderService {

	String live(String source, List<String> currencies);

	String list();
}
