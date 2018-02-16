package exchange.rate.information.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Yuriy Bochkarev
 * @since 16.02.18.
 */

interface GenericDao<PK extends Serializable, T> {

	void persist(T entity);

	T getEntityByKey(PK id);

	List<T> getAllEntity();

	void update(T entity);

	void deleteByKey(PK id);
}
