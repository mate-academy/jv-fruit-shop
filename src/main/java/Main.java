import service.CsvFileReaderService;
import service.FileReaderService;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        String pathToInputDataFile = "src/main/resources/inputData.csv";
        File inputData = new File(pathToInputDataFile);
        FileReaderService csvFileReader = new CsvFileReaderService();
        System.out.println(csvFileReader.getTransactionListFromFile(inputData));
    }
}
