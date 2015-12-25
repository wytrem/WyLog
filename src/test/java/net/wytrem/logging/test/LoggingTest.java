package net.wytrem.logging.test;

import net.wytrem.logging.Logger;
import net.wytrem.logging.LoggerFactory;

public class LoggingTest
{
	private static final Logger logger = LoggerFactory.getLogger(LoggingTest.class);
	
	public static void main(String[] args)
	{
		logger.info("Hey");
		logger.success("Hey");
		logger.warning("Hey");
		logger.error("Hey");
		logger.debug("Hey");

		logger.error("Erreur :", new Throwable());
	}
}	
