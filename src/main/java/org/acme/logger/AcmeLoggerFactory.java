package org.acme.logger;

import org.jboss.logging.Logger;

public class AcmeLoggerFactory {

	public static Logger getLogger(String name) {
		Logger log = Logger.getLogger(name);
		return new AcmeLoggerDecorator(log);
	}
}
