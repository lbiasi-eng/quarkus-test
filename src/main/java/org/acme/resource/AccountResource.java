package org.acme.resource;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.repo.entity.Account;
import org.acme.resource.bean.EntityMapper;
import org.acme.resource.bean.ListResponse;
import org.acme.resource.bean.PaginationBean;
import org.acme.resource.exception.RestException;
import org.acme.service.AccountService;
import org.acme.service.dto.ListResource;

@Path("accounts")
public class AccountResource {

	@Inject
	private AccountService accountService;

	@GET
	@Path("limit/{limit}/offset/{offset}")
	@Produces(MediaType.APPLICATION_JSON)
	public ListResponse<Account> getAccounts(@BeanParam PaginationBean pagination) throws RestException {

		try {
			ListResource<Account> accounts = accountService.getAllAccounts(EntityMapper.toDto(pagination));
			return EntityMapper.toBean(accounts);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RestException(e.getMessage());
		}
	}
}
