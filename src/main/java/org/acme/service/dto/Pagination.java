package org.acme.service.dto;

public class Pagination {

	private static final int DEFAULT_MAX = 10;
	private int offset;
	private int limit;

	public Pagination() {

	}

	public Pagination(int offset, int limit) {
		super();
		this.offset = offset;
		this.limit = limit;

		if (limit <= 0)
			limit = DEFAULT_MAX;

		if (offset < 0)
			offset = 0;

	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		if (offset < 0)
			offset = 0;
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		if (limit <= 0)
			limit = DEFAULT_MAX;
		this.limit = limit;
	}

	public int getPage() {
		return (offset + limit) / limit;
	}

}
