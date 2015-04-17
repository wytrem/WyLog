package net.wytrem.logging;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;


public class FileHandler extends ConsoleHandler
{
	/**
	 * Le fichier où sont écrits les logs.
	 */
	protected File logFile;

	/**
	 * Crée un nouveau handler pour écrire les logs dans un fichier.
	 * 
	 * @param loggingFile Le ficher où les logs doivent être écrits.
	 * @throws IOException Pour l'ouverture du flux d'écriture.
	 */
	public FileHandler(File loggingFile) throws IOException
	{
		setLogFile(loggingFile);
	}

	/**
	 * @return Le fichier où sont écrits les logs.
	 */
	public File getLogFile()
	{
		return logFile;
	}

	/**
	 * Définit le fichier où sont écrits les logs.
	 * 
	 * @throws IOException Pour l'ouverture du flux d'écriture.
	 */
	public void setLogFile(File loggingFile) throws IOException
	{
		logFile = loggingFile;
		outStream = errorStream = new PrintStream(new FileOutputStream(logFile, true), true);
	}
}
