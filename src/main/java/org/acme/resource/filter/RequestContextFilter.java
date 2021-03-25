package org.acme.resource.filter;

import java.io.IOException;
import java.util.UUID;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.acme.common.RequestContextThreadLocal;

@Provider
@Priority(value = Priorities.HEADER_DECORATOR)
public class RequestContextFilter implements ContainerRequestFilter, ContainerResponseFilter {

	private static final String X_CORRELATION_ID = "x-correlation-id";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String correlationId;
		if (requestContext.getHeaders().containsKey(X_CORRELATION_ID))
			correlationId = requestContext.getHeaderString(X_CORRELATION_ID);
		else
			correlationId = UUID.randomUUID().toString();

		RequestContextThreadLocal.put(correlationId);

	}

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {

		RequestContextThreadLocal.clear();

	}

}
