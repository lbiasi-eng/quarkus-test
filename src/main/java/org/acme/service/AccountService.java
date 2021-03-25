package org.acme.service;

import javax.enterprise.context.ApplicationScoped;

import org.acme.repo.entity.Account;
import org.acme.service.dto.ListResource;
import org.acme.service.dto.Pagination;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class AccountService {

	public ListResource<Account> getAllAccounts(Pagination pagination) {

		PanacheQuery<Account> query = Account.findAll();
		// query.page(pagination.getPage() - 1, pagination.getLimit());
		query.range(pagination.getOffset(), pagination.getOffset() + pagination.getLimit());
		long totalCount = query.count();
		return new ListResource<Account>(pagination, query.list(), totalCount);
	}
}
