import db.Storage;
import model.FruitTransaction;
import service.FruitService;
import service.ParseService;
import service.ReaderService;
import service.impl.FruitServiceImpl;
import service.impl.ParseServiceImpl;
import service.impl.ReaderServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/fruitList.csv";

        ReaderService readerServiceImpl = new ReaderServiceImpl();
        List<String> list = readerServiceImpl.readFromFilesContents(filePath);

        Storage storage = new Storage();
        ParseService parseService = new ParseServiceImpl();
        for (String transaction : list) {
            FruitTransaction fruitTransaction = parseService.parseFromString(transaction);
            storage.addTransaction(fruitTransaction);
        }

        List<FruitTransaction> transactions = storage.getTransactions();
        Map<List<FruitTransaction>, FruitService> activities = new HashMap<>();



        // Print the transactions from the storage for checking, if the transactions are added to the storage
//        storage.getTransactions().forEach(transaction -> System.out.println(transaction));

    }
}
