package main;

import db.FruitStorage;
import java.util.List;
import model.FruitTransaction;
import service.FileReader;
import service.FileReaderImpl;
import service.FileWriter;
import service.FileWriterImpl;
import service.FruitStoreService;

public class FruitStoreMain {
    private static final String INPUT_FILE_NAME = "src/main/resources/storage.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/shop_report.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<FruitTransaction> fruitTransactionStorage = fileReader.read(INPUT_FILE_NAME);

        FruitStoreService fruitStoreService = new FruitStoreService();
        FruitStorage fruitStorage = fruitStoreService.processTransactions(fruitTransactionStorage);

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(fruitStorage, REPORT_FILE_NAME);
    }
}
