package net.wytrem.logging;


/**
 * Interface utilisée pour effectuer l'action de logging.
 * Appelé par {@link BasicLogger}.
 */
public interface ILogHandler
{
	/**
	 * Affiche un log.
	 * 
	 * @param level Niveau du message.
	 * @param msg Message lui même.
	 */
	public void broadcastLog(LogLevel level, String msg);

	/**
	 * Affiche une throwable.
	 * 
	 * @param level Niveau du message.
	 * @param th Throwable à afficher.
	 */
	public void broadcastThrowable(LogLevel level, Throwable th);

}
