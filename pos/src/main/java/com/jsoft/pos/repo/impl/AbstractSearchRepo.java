package com.jsoft.pos.repo.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.jsoft.pos.repo.SearchableRepository;

public abstract class AbstractSearchRepo<T> implements SearchableRepository<T> {

	@PersistenceContext
	private EntityManager em;
	private Class<T> type;

	public AbstractSearchRepo(Class<T> type) {
		this.type = type;
	}

	protected abstract String getBaseQuery();

	@Override
	public List<T> search(String where, Map<String, Object> params, int first, int max) {
		StringBuffer sb = new StringBuffer(getBaseQuery());

		if (null != where && !where.isEmpty()) {
			sb.append(where);
		}

		TypedQuery<T> query = em.createQuery(sb.toString(), type);
		query.setFirstResult(first);
		query.setMaxResults(max);

		if (null != params && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}

		return query.getResultList();
	}

}