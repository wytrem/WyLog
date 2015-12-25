package net.wytrem.logging;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class LoggerFactory
{
	/**
	 * Le niveau minimal nécessaire pour qu'un log soit affiché.
	 */
	public static int minLogLevel = LogLevel.INFO.getIntLevel();

	/**
	 * Liste de tous les handlers qui doivent être appliqués aux loggers créés.
	 */
	public static final ArrayList<ILogHandler> sharedHandlers = new ArrayList<ILogHandler>() {
		private static final long serialVersionUID = 1L;
		{
			ConsoleHandler handler = new ConsoleHandler();
			add(handler);
		}
	};

	/**
	 * Ajoute un délégateur de logging dans un fichier.
	 * 
	 * @param loggingFile Le fichier dans lequel il faut écrire.
	 * @throws IOException Si jamais le fichier n'existe pas ou qu'il y a un
	 *         erreur d'écriture.
	 */
	public static final FileHandler addSharedFileHandler(File loggingFile) throws IOException
	{
		FileHandler handler = new FileHandler(loggingFile);

		sharedHandlers.add(handler);

		return handler;
	}

	/**
	 * Ajoute un délégateur de logging commun.
	 */
	public static final void addSharedHandler(ILogHandler handler)
	{
		sharedHandlers.add(handler);
	}

	/**
	 * Crée un nouveau logger qui aura le nom donné.
	 * 
	 * @param name Le nom du nouveau logger.
	 * @return Le nouveau logger fraîchement créé.
	 */
	public static final BasicLogger getLogger(String name)
	{
		return new BasicLogger(name);
	}

	/**
	 * Crée un nouveau logger qui aura le nom de la classe donnée et qui loggera
	 * le debug ou non.
	 * 
	 * Typiquement, on pourra l'appeler de cette manière au début des classes
	 * qui ont besoin d'un logger : <code>
	 * private static final BasicLogger logger = LoggerFactory.getLogger(LaClassOuOnEst.class);
	 * </code>
	 * 
	 * @param clazz La class pour laquelle il servira.
	 * @return Le nouveau logger fraîchement créé.
	 */
	public static final BasicLogger getLogger(Class<?> clazz)
	{
		return getLogger(clazz.getSimpleName());
	}

	/**
	 * Définit le niveau minimal d'un log affiché.
	 * 
	 * @param lvl Le niveau souhaité, voir {@link LogLevel#getIntLevel()}
	 */
	public static void setMinLogLevel(int lvl)
	{
		minLogLevel = lvl;
	}
}
