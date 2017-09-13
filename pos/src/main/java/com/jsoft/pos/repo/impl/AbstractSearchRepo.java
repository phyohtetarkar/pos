package com.jsoft.pos.repo.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.jsoft.pos.repo.SearchableRepository;
import com.jsoft.pos.service.search.SearchCriteria;

public abstract class AbstractSearchRepo<T> implements SearchableRepository<T> {

	@PersistenceContext
	private EntityManager em;
	private Class<T> type;

	public AbstractSearchRepo(Class<T> type) {
		this.type = type;
	}

	@Override
	public List<T> search(SearchCriteria criteria) {
		StringBuffer sb = new StringBuffer(String.format("select t from %s t ", type.getSimpleName()));

		if (null != criteria.getWhere() && !criteria.getWhere().isEmpty()) {
			sb.append(criteria.getWhere());
		}
		
		System.out.println(sb.toString());

		TypedQuery<T> query = em.createQuery(sb.toString(), type);
		if (criteria.getLimit() > 0) {
			query.setFirstResult(criteria.getOffset());
			query.setMaxResults(criteria.getLimit());
		}	

		if (null != criteria.getParams() && !criteria.getParams().isEmpty()) {
			for (String key : criteria.getParams().keySet()) {
				query.setParameter(key, criteria.getParams().get(key));
			}
		}

		return query.getResultList();
	}

}