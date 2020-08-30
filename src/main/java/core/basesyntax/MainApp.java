package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Feel free to remove this class and create your own.
 */
public class MainApp {
    public static void main(String[] args) {
        StorageUpdater newUpdate = new StorageUpdaterImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, input path to the file filled with new data: ");
        String filePath = scanner.nextLine();
        while (!new File(filePath).isFile()) {
            System.out.println("There is no file by the specified path. "
                    + "Please, try enter a valid path");
            filePath = scanner.nextLine();
        }

        System.out.println("Please, input path for the report file based on new data: ");
        String outPutFilePath = scanner.nextLine();
        while (new File(outPutFilePath).isFile()) {
            System.out.println("There file with specified name already exists "
                    + "in the specified directory. Please, try again");
            outPutFilePath = scanner.nextLine();
        }

        try {
            LocalFileReader reader = new LocalFileReader(filePath);
            newUpdate.parseDataToStorage(reader.readTransactionsFile());
            CsvFileWriter writer = new CsvFileWriter(outPutFilePath);
            writer.writeToFile();
            System.out.println("All data has been successfully processed. File was written");
        } catch (IOException | IllegalArgumentException | DateTimeParseException
                                        | ArrayIndexOutOfBoundsException message) {
            System.out.println("An error in processing provided data has occurred. "
                    + "Please, try to rerun the program ");
            System.out.println(message.getMessage());
        }
    }
}
