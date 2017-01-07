package net.wytrem.wylog.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.wytrem.wylog.Wylog;

public class WylogTest
{
    public static void main(String[] args)
    {
        Logger logger = LoggerFactory.getLogger(WylogTest.class);
        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warning message");
        logger.error("error message", new Throwable());
        ((Wylog) logger).setCurrentLogLevel(Wylog.LOG_LEVEL_DEBUG);
        logger.debug("debug message");
        ((Wylog) logger).setCurrentLogLevel(Wylog.LOG_LEVEL_TRACE);
        logger.trace("trace message");
    }
}
