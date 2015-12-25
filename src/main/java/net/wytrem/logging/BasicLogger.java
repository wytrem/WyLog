package net.wytrem.logging;


import static net.wytrem.logging.LoggerFactory.sharedHandlers;

import java.text.SimpleDateFormat;

/**
 * Implémentation basique de {@link Logger}.
 */
public class BasicLogger extends Logger
{
	/**
	 * Formattera la date pour nous.
	 */
	private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * Le nom du logger courant.
	 */
	protected String loggerName;
	
	/**
	 * Créé une nouvelle instance d'un BasicLogger. Est appelé uniquement par
	 * {@link LoggerFactory}.
	 * 
	 * @param name Le nom désiré.
	 */
	protected BasicLogger(String name)
	{
		loggerName = name;
	}

	@Override
	/**
	 * Affiche notifie les handlers qu'un message doit être affiché après l'avoir formatté.
	 */
	public void log(LogLevel level, String msg, Object... args)
	{
		if (level.getIntLevel() < LoggerFactory.minLogLevel)
		{
			return;
		}

		String format = formatMessage(level, String.format(msg, args));

		broadcastLog(level, format);
	}

	/**
	 * Logge le message auprès de chaque handler.
	 */
	private void broadcastLog(LogLevel level, String format)
	{
		for (ILogHandler handler : sharedHandlers)
		{
			handler.broadcastLog(level, format);
		}
	}

	@Override
	/**
	 * Affiche un message (via log(LogLevel, String, Object...)) et sa throwable.
	 */
	public void log(LogLevel level, String msg, Throwable th)
	{
		if (level.getIntLevel() < LoggerFactory.minLogLevel)
		{
			return;
		}

		log(level, msg);

		for (ILogHandler handler : sharedHandlers)
		{
			handler.broadcastThrowable(level, th);
		}
	}

	/**
	 * Formatte un message : y ajoute (dans l'ordre) la date et l'heure du
	 * message, le niveau et le nom du logger.
	 * 
	 * @return Le message formatté.
	 */
	public String formatMessage(LogLevel level, String msg)
	{
		StringBuilder builder = new StringBuilder();

		builder.append("[").append(dateFormatter.format(Long.valueOf(System.currentTimeMillis()))).append("] ");
		builder.append("[").append(level.name()).append("] ");
		builder.append("[").append(loggerName).append("] ");
		builder.append(msg);

		return builder.toString();
	}
}
