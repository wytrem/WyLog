package net.wytrem.logging;

import java.io.PrintStream;

/**
 * Instance de ILogHandler, qui affiche les logs dans la console.
 */
public class ConsoleHandler implements ILogHandler
{
	/**
	 * Utilisé pour afficher les messages qui ne sont pas d'erreur.
	 */
	protected PrintStream outStream;
	
	/**
	 * Utilisé pour afficher les messages d'erreur.
	 */
	protected PrintStream errorStream;

	/**
	 * Crée un nouveau console handler, sur System.out et System.err.
	 */
	public ConsoleHandler()
	{
		this(System.out, System.err);
	}
	
	/**
	 * Crée un nouvel handler sur les flux passés en argument.
	 */
	public ConsoleHandler(PrintStream out, PrintStream error)
	{
		outStream = out;
		errorStream = error;
	}
	
	@Override
	/** {@inheritDoc} */
	public void broadcastLog(LogLevel level, String msg)
	{
		if (level.equals(LogLevel.ERROR))
		{
			errorStream.println(msg);
		}
		else
		{
			outStream.println(msg);
		}
	}

	@Override
	/** {@inheritDoc} */
	public void broadcastThrowable(LogLevel level, Throwable th)
	{
		if (level.equals(LogLevel.ERROR))
		{
			th.printStackTrace(errorStream);
		}
		else
		{
			th.printStackTrace(outStream);
		}
	}
}
