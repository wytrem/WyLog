# WyLog
Basic SLF4J implementation.

## Dependency
Gradle :
```gradle


repositories {
    // [...]
    maven {
        url "http://wytrem.github.io/maven/"
    }
}


dependencies {
    // [...]
    compile 'net.wytrem:wylog:2.0'
}
```

This library depends on `slf4j-api`.

## Usage

Example :
```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyClass {
    private static final Logger logger = LoggerFactory.getLogger(WylogTest.class);

    private void foo() {
        logger.info("Hey!");
    }
}

```

## Configuration

Add a `wylog.properties` file to your classpath. You can define in it the properties you want to chage from default.

Avalaible properties:
 * **net.wytrem.wylog.logFile** - The output targets which can be the path to a file, or the 
	 special values "stdout" and "stderr", separed by a coma (e.g. "stdout,/home/wytrem/
	 logs.log"). Default is singleton "stdout". 
 * **net.wytrem.wylog.defaultLogLevel** - Default log level for all instances of SimpleLogger. 
	 Must be one of ("trace", "debug", "info", "warn", "error" or "off"). If not specified, defaults to 
	 "info". 
 * **net.wytrem.wylog.showDateTime** - Set to true if you want the current date and time to 
	 be included in output messages. Default is true 
 * **net.wytrem.wylog.dateTimeFormat** - The date and time format to be used in the 
	 output messages. The pattern describing the date and time format is defined by 
	 SimpleDateFormat. If the format is not specified or is invalid, the number of milliseconds 
	 since start up will be output. 
 * **net.wytrem.wylog.showThreadName** -Set to true if you want to output the current 
	 thread name. Defaults to false. 
 * **net.wytrem.wylog.showLogName** - Set to true if you want the Logger instance name 
	 to be included in output messages. Defaults to true. 
 * **net.wytrem.wylog.showShortLogName** - Set to true if you want the last component of 
	 the name to be included in output messages. Defaults to true. 
 * **net.wytrem.wylog.levelInBrackets** - Should the level string be output in brackets? 
	 Defaults to true. 
 * **net.wytrem.wylog.warnLevelString** - The string value output for the warn level. Defaults 
	 to WARN. 

Default logging style looks like:
```
[2017-01-07 10:50:33] [INFO] [WylogTest] info message
[2017-01-07 10:50:33] [WARN] [WylogTest] warning message
[2017-01-07 10:50:33] [ERROR] [WylogTest] error message
java.lang.Throwable
	at net.wytrem.wylog.test.WylogTest.main(WylogTest.java:17)
[2017-01-07 10:50:33] [DEBUG] [WylogTest] debug message
[2017-01-07 10:50:33] [TRACE] [WylogTest] trace message
```
