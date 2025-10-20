package CSV;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerCSV {
    private static final String FILE_PATH = "home_log.csv";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    static {
        try (FileWriter writer = new FileWriter(FILE_PATH, false)) {
            java.io.File file = new java.io.File(FILE_PATH);
            if (file.length() == 0) {
                writer.write("Date,Action,Factory,Device,State\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void log(String action, String factory, String device, String state) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            String date = LocalDateTime.now().format(FORMATTER);
            writer.write(String.format("%s,%s,%s,%s,%s\n",date, action, factory, device, state));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
