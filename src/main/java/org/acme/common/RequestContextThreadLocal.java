package org.acme.common;

public class RequestContextThreadLocal {
	private static ThreadLocal<String> context = new ThreadLocal<>();

	public static void put(String ctx) {
		context.set(ctx);
	}

	public static String getCorrelationId() {
		return context.get();
	}

	public static void clear() {
		context.remove();
	}

}
