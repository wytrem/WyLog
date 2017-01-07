package net.wytrem.wylog.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyClass {
    private static final Logger logger = LoggerFactory.getLogger(WylogTest.class);

    private void foo() {
        logger.info("Hey!");
    }
}
