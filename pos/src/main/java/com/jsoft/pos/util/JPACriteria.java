package com.jsoft.pos.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jsoft.pos.annotation.SearchParam;
import com.jsoft.pos.service.search.SearchCriteria;

public class JPACriteria<T> {

	private StringBuffer sb;
	private Map<String, Object> params;
	private List<String> likeMatches;
	private T sch;

	private JPACriteria() {
		sb = new StringBuffer();
		params = new HashMap<>();
	}

	public static <T> JPACriteria<T> builder() {
		return new JPACriteria<T>();
	}

	public SearchCriteria build() {
		return build(0, 0);
	}

	public SearchCriteria build(int offset, int limit) {
		try {
			Field[] fields = sch.getClass().getDeclaredFields();
			for (Field f : fields) {
				f.setAccessible(true);
				SearchParam sp = f.getDeclaredAnnotation(SearchParam.class);

				if (null != sp) {
					checkAndSet(f, sp, sch);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SearchCriteria(sb.toString(), new HashMap<>(params), offset, limit);
	}

	public JPACriteria<T> of(T sch) {
		this.sch = sch;
		return this;
	}
	
	public JPACriteria<T> likeMatches(String...likeMatches) {
		this.likeMatches = Arrays.asList(likeMatches);
		return this;
	}

	private void checkAndSet(Field f, SearchParam sp, T t) throws IllegalArgumentException, IllegalAccessException {
		if (f.getType().isPrimitive()) {
			if (f.getType() == int.class) {
				setParam(sp.paramName(), f.getName(), f.getInt(t));
			} else if (f.getType() == long.class) {
				setParam(sp.paramName(), f.getName(), f.getLong(t));
			}
		} else {
			if (f.getType() == Integer.class) {
				setParam(sp.paramName(), f.getName(), f.getInt(t));
			} else if (f.getType() == Long.class) {
				setParam(sp.paramName(), f.getName(), f.getLong(t));
			} else if (f.getType() == String.class) {
				setParam(sp.paramName(), f.getName(), (String) f.get(t));
			}
		}
	}

	private void setParam(String key, String name, int value) {
		if (value > 0) {
			populate(key, name, value);
		}
	}

	private void setParam(String key, String name, long value) {
		if (value > 0) {
			populate(key, name, value);
		}
	}

	private void setParam(String key, String name, String value) {
		if (null != value && !value.isEmpty()) {
			if (null != likeMatches && likeMatches.contains(key)) {
				value = value.concat("%");
			}
			populate(key, name, value);
		}
	}

	public void setParam(String key, String name, Object value) {
		if (null != value) {
			populate(key, name, value);
		}
	}

	private void populate(String key, String name, Object value) {

		if (sb.toString().isEmpty()) {
			sb.append("where ");
			if (null != likeMatches && likeMatches.contains(key)) {
				sb.append(String.format("upper(t.%s) like upper(:%s) ", key, name));
			} else {
				sb.append(String.format("t.%s = :%s ", key, name));
			}
			
		} else {
			sb.append("and ");
			if (null != likeMatches && likeMatches.contains(key)) {
				sb.append(String.format("upper(t.%s) like upper(:%s) ", key, name));
			} else {
				sb.append(String.format("t.%s = :%s ", key, name));
			}
		}

		params.put(name, value);
	}
}
