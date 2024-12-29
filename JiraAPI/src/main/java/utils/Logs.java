package utils;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDateTime;

public class Logs {

    public static PrintStream progressLogs() {

        PrintStream log = null;
        try {
            log = new PrintStream(System.getProperty("user.dir") + "/src/main/java/logs/APILogs-" + LocalDateTime.now().toString().replace("-", "").replace(":", "").replace(".", "") + ".txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return log;

    }
}
