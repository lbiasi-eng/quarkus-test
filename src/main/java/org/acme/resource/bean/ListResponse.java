package org.acme.resource.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.acme.service.dto.ListResource;
import org.apache.commons.beanutils.BeanUtils;

public class ListResponse<T> {

	private int page;
	private int limit;
	private long totalCount;
	private List<T> resources = new ArrayList<T>();

	public ListResponse() {

	}

	public ListResponse(ListResource<T> r) {
		try {
			BeanUtils.copyProperties(this, r);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getResources() {
		return resources;
	}

	public void setResources(List<T> resources) {
		this.resources = resources;
	}

}
