package org.acme.resource.bean;

import java.lang.reflect.InvocationTargetException;

import org.acme.entity.Account;
import org.acme.service.dto.ListResource;
import org.acme.service.dto.Pagination;
import org.apache.commons.beanutils.BeanUtils;

public class EntityMapper {

	public static AccountBean toBean(Account account) throws IllegalAccessException, InvocationTargetException {
		AccountBean bean = new AccountBean();
		BeanUtils.copyProperties(bean, account);
		return bean;
	}

	public static <T, E> ListResponse<E> toBean(ListResource<T> list)
			throws IllegalAccessException, InvocationTargetException {
		ListResponse<E> bean = new ListResponse<E>();
		BeanUtils.copyProperties(bean, list);
		for (T e : list) {
			if (e instanceof Account)
				bean.getResources().add((E) toBean((Account) e));
		}
		return bean;
	}

	public static PaginationBean toPayload(Pagination p) throws IllegalAccessException, InvocationTargetException {
		PaginationBean bean = new PaginationBean();
		BeanUtils.copyProperties(bean, p);
		return bean;
	}

	public static Pagination toDto(PaginationBean pagination) throws IllegalAccessException, InvocationTargetException {
		Pagination p = new Pagination();
		BeanUtils.copyProperties(p, pagination);
		return p;
	}
}
