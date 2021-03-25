package org.acme.resource.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Request;
import javax.ws.rs.ext.Provider;

import org.acme.logger.AcmeLoggerFactory;
import org.jboss.logging.Logger;

@Provider
public class RequestFilter implements ContainerRequestFilter, ContainerResponseFilter {

	private Logger logger = AcmeLoggerFactory.getLogger(RequestFilter.class.getName());

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		Request req = requestContext.getRequest();
		String log = String.format("%s %s", req.getMethod(), requestContext.getUriInfo().getAbsolutePath().getPath());
		logger.info(log);
	}

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		int status = responseContext.getStatus();
		String log = String.format("Status code: %d", status);
		logger.info(log);
	}

}
