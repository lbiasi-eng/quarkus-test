package org.acme.service.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListResource<T> implements List<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6934596524067766552L;

	private int page;
	private int limit;
	private long totalCount;
	private List<T> resources = new ArrayList<T>();

	public ListResource(Pagination pagination, List<T> resources, long totalCount) {
		super();
		this.page = pagination.getPage();
		this.limit = pagination.getLimit();
		this.resources = resources;
		this.totalCount = totalCount;
	}

	public ListResource(Pagination pagination, int totalCount) {
		super();
		this.page = pagination.getPage();
		this.limit = pagination.getLimit();
		this.totalCount = totalCount;
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

	@Override
	public int size() {
		return resources.size();
	}

	@Override
	public boolean isEmpty() {
		return resources.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return resources.contains(o);
	}

	@Override
	public Iterator<T> iterator() {
		return resources.iterator();
	}

	@Override
	public Object[] toArray() {
		return resources.toArray();
	}

	@Override
	public <K> K[] toArray(K[] a) {
		return resources.toArray(a);
	}

	@Override
	public boolean add(T e) {
		return resources.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return resources.remove(o);

	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return resources.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return resources.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		return resources.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return resources.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return resources.retainAll(c);
	}

	@Override
	public void clear() {
		resources.clear();
	}

	@Override
	public T get(int index) {
		return resources.get(index);
	}

	@Override
	public T set(int index, T element) {
		return resources.set(index, element);
	}

	@Override
	public void add(int index, T element) {
		resources.add(index, element);
	}

	@Override
	public T remove(int index) {
		return resources.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return resources.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return resources.lastIndexOf(o);
	}

	@Override
	public ListIterator<T> listIterator() {
		return resources.listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		return resources.listIterator(index);
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		return resources.subList(fromIndex, toIndex);
	}

}
