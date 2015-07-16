package net.wytrem.logging;


import static net.wytrem.logging.LoggerFactory.sharedHandlers;

import java.text.SimpleDateFormat;

/**
 * Implémentation basique de {@link AbstractLogger}.
 */
public class BasicLogger extends AbstractLogger
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
	 * <code>true</code> s'il faut afficher les messages de debug,
	 * <code>false</code> sinon.
	 */
	protected boolean shouldPrintDebug;

	/**
	 * Créé une nouvelle instance d'un BasicLogger. Est appelé uniquement par
	 * {@link LoggerFactory}.
	 * 
	 * @param name Le nom désiré.
	 * @param debug <code>true</code> s'il faut afficher le debug.
	 */
	protected BasicLogger(String name, boolean debug)
	{
		loggerName = name;
		shouldPrintDebug = debug;
	}

	@Override
	/**
	 * Affiche notifie les handlers qu'un message doit être affiché après l'avoir formatté.
	 */
	public void log(LogLevel level, String msg, Object... args)
	{
		if (level.equals(LogLevel.DEBUG) && !shouldPrintDebug)
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
		if (level.equals(LogLevel.DEBUG) && !shouldPrintDebug)
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

	/**
	 * Définit si on doit afficher les messages de debug.
	 * 
	 * @param debug <code>true</code> s'il faut afficher les messages de debug,
	 *        <code>false</code> sinon.
	 */
	public void setShouldPrintDebug(boolean debug)
	{
		shouldPrintDebug = debug;
	}

	/**
	 * Si les messages de debug sont affichés, les cache, et vice versa.
	 */
	public void toggleDebug()
	{
		shouldPrintDebug = !shouldPrintDebug;
	}
}
