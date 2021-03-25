package org.acme.resource.bean;

import javax.ws.rs.PathParam;

public class PaginationBean {

	@PathParam("limit")
	private int limit;

	@PathParam("offset")
	private int offset;

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

}
