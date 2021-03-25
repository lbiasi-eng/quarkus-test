package org.acme.logger;

import org.acme.common.RequestContextThreadLocal;
import org.jboss.logging.Logger;

class AcmeLoggerDecorator extends Logger {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5357753786184534092L;

	private Logger logger;

	public AcmeLoggerDecorator(Logger logger) {
		super(logger.getName());
		this.logger = logger;
	}

	protected AcmeLoggerDecorator(String name) {
		super(name);
	}

	@Override
	public boolean isEnabled(Level level) {
		return logger.isEnabled(level);
	}

	@Override
	protected void doLog(Level level, String loggerClassName, Object message, Object[] parameters, Throwable thrown) {
		String msg = decorateMessage(String.valueOf(message));

		if (parameters == null) {
			logger.log(level, loggerClassName, msg, thrown);
		} else {
			logger.log(loggerClassName, level, msg, parameters, thrown);
		}
	}

	@Override
	protected void doLogf(Level level, String loggerClassName, String format, Object[] parameters, Throwable thrown) {
		if (parameters == null) {
			logger.logf(loggerClassName, level, thrown, format, null, null);
		} else {
			Object arg1 = parameters[0];
			Object arg2 = null;
			if (parameters.length >= 2)
				arg2 = parameters[1];
			logger.logf(loggerClassName, level, thrown, format, arg1, arg2);
		}
	}

	private String decorateMessage(String msg) {
		String corrId = RequestContextThreadLocal.getCorrelationId();
		String newMsg = String.format("%s - %s", corrId, msg);
		return newMsg;
	}

}
