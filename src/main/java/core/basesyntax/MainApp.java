package core.basesyntax;

import java.io.IOException;
import java.util.Scanner;

/**
 * Feel free to remove this class and create your own.
 */
public class MainApp {
    public static void main(String[] args) throws IOException {
        StorageUpdater newUpdate = new StorageUpdaterImpl();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, input path to the file filled with new data: ");
        String filePath = scanner.nextLine();
        System.out.println("Please, input path for the report file based on new data: ");
        String outPutFilePath = scanner.nextLine();

        LocalFileReader reader = new LocalFileReader(filePath);
        newUpdate.parseData(reader.readFromFile());
        WriteToFile writer = new WriteToFile(outPutFilePath);
        writer.csvFileWriter();

        System.out.println("All data has been successfully processed. File was written");
    }
}
