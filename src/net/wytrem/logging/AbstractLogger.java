package net.wytrem.logging;

public abstract class AbstractLogger
{
	/**
	 * Affiche un log avec le niveau donné.
	 * 
	 * @param level Le niveau souhaité.
	 * @param msg Le message, qui sera passé dans {@link String#format(String, Object...)}.
	 * @param args Les arguments passés à {@link String#format(String, Object...)}.
	 */
	public abstract void log(LogLevel level, String msg, Object... args);

	/**
	 * Affiche une {@link Throwable} sur le niveau donné.
	 * 
	 * @param level Le niveau souhaité.
	 * @param msg Le message, qui sera affiché au dessus de la {@link Throwable}.
	 * @param th La {@link Throwable} à afficher.
	 */
	public abstract void log(LogLevel level, String msg, Throwable th);

	/**
	 * Affiche un log sur le niveau {@link LogLevel#INFO}.
	 */
	public void info(String msg, Object... args)
	{
		log(LogLevel.INFO, msg, args);
	}

	/**
	 * Affiche une {@link Throwable} sur le niveau {@link LogLevel#INFO}.
	 */
	public void info(String msg, Throwable th)
	{
		log(LogLevel.INFO, msg, th);
	}

	/**
	 * Affiche un log sur le niveau {@link LogLevel#SUCCESS}.
	 */
	public void success(String msg, Object... args)
	{
		log(LogLevel.SUCCESS, msg, args);
	}

	/**
	 * Affiche une {@link Throwable} sur le niveau {@link LogLevel#SUCCESS}.
	 */
	public void success(String msg, Throwable th)
	{
		log(LogLevel.SUCCESS, msg, th);
	}

	/**
	 * Affiche un log sur le niveau {@link LogLevel#WARNING}.
	 */
	public void warning(String msg, Object... args)
	{
		log(LogLevel.WARNING, msg, args);
	}

	/**
	 * Affiche une {@link Throwable} sur le niveau {@link LogLevel#WARNING}.
	 */
	public void warning(String msg, Throwable th)
	{
		log(LogLevel.WARNING, msg, th);
	}

	/**
	 * Affiche un log sur le niveau {@link LogLevel#ERROR}.
	 */
	public void error(String msg, Object... args)
	{
		log(LogLevel.ERROR, msg, args);
	}

	/**
	 * Affiche une {@link Throwable} sur le niveau {@link LogLevel#ERROR}.
	 */
	public void error(String msg, Throwable th)
	{
		log(LogLevel.ERROR, msg, th);
	}

	/**
	 * Affiche un log sur le niveau {@link LogLevel#DEBUG}.
	 */
	public void debug(String msg, Object... args)
	{
		log(LogLevel.DEBUG, msg, args);
	}

	/**
	 * Affiche une {@link Throwable} sur le niveau {@link LogLevel#DEBUG}.
	 */
	public void debug(String msg, Throwable th)
	{
		log(LogLevel.DEBUG, msg, th);
	}
}
