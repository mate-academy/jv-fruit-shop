package core.basesyntax;

import java.io.IOException;

/**
 * Feel free to remove this class and create your own.
 */
public class MainApp {
    public static void main(String[] args) throws IOException {
        WriteToFile testRecord = new WriteToFile();
        testRecord.csvFileWriter("current_reminder.csv", "test11.csv");
        testRecord.csvFileWriter("current_reminder.csv", "test11.csv");
        System.out.println(Storage.fruitsInStore.toString());
    }
}
