import model.FruitTransaction;
import service.CsvFileReaderService;
import service.FileReaderService;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String pathToInputDataFile = "src/main/resources/inputData.csv";
        File inputData = new File(pathToInputDataFile);
        FileReaderService csvFileReader = new CsvFileReaderService();
        List<FruitTransaction> fruitTransactions = csvFileReader.getTransactionsFromFile(inputData);
    }
}
