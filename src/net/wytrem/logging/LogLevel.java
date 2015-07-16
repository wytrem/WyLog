package net.wytrem.logging;


public enum LogLevel
{
	/**
	 * Une information basique.
	 */
	INFO(0x000000),

	/**
	 * Une réussite !
	 */
	SUCCESS(0x4ED714),

	/**
	 * Un message d'avertissement.
	 */
	WARNING(0xffc800),

	/**
	 * Un message d'erreur.
	 */
	ERROR(0xff0000),

	/**
	 * Un message de debug.
	 */
	DEBUG(0x00A84E);

	private int logColor;

	/**
	 * @param color La couleur par défaut d'un log de ce niveau.
	 */
	private LogLevel(int color)
	{
		logColor = color;
	}

	/**
	 * @return La couleur par défaut d'un log de ce niveau.
	 */
	public int getLogColor()
	{
		return logColor;
	}

	/**
	 * Définit la couleur par défaut d'un log de ce niveau.
	 */
	public void setLogColor(int logColor)
	{
		this.logColor = logColor;
	}

	/**
	 * @return Le nombre qui représente l'importance du niveau de logging. Plus
	 *         il est grand, plus le niveau est important.
	 */
	public int getIntLevel()
	{
		return ordinal();
	}
}
