package org.acme.resource.exception;

import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.acme.resource.bean.ErrorBean;

@Singleton
public class RestExceptionMapper<E extends RestException> implements ExceptionMapper<E> {

	@Override
	public Response toResponse(E exception) {
		return Response.status(Status.BAD_REQUEST).entity(new ErrorBean(exception.getMessage(), "Bad Request error"))
				.build();
	}

}
