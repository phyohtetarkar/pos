package com.jsoft.pos.repo.impl;

import java.util.List;
import java.util.Map;

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
	public List<T> search(SearchCriteria crt) {
		String where = crt.getWhere();
		Map<String, Object> params = crt.getParams();
		
		StringBuffer sb = new StringBuffer(String.format("select t from %s t ", type.getSimpleName()));
		sb.append("where t.deleted = :deleted ");

		if (null != where && !where.isEmpty()) {
			sb.append(where);
		} 	
		
		sb.append("order by t.id asc ");
		
		System.out.println(sb.toString());

		TypedQuery<T> query = em.createQuery(sb.toString(), type);
		
		query.setParameter("deleted", false);
		
		if (crt.getLimit() > 0) {
			query.setFirstResult(crt.getOffset());
			query.setMaxResults(crt.getLimit());
		}	

		if (null != params && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}

		return query.getResultList();
	}

	@Override
	public long count(SearchCriteria crt) {
		String where = crt.getWhere();
		Map<String, Object> params = crt.getParams();
		
		StringBuffer sb = new StringBuffer(String.format("select count(t) from %s t ", type.getSimpleName()));
		sb.append("where t.deleted = :deleted ");

		if (null != where && !where.isEmpty()) {
			sb.append(where);
		} 	
		
		System.out.println(sb.toString());

		TypedQuery<Long> query = em.createQuery(sb.toString(), Long.class);
		
		query.setParameter("deleted", false);

		if (null != params && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		
		return query.getSingleResult();
	}
}