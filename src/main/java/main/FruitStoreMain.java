package main;

import db.FruitStorage;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FileReader;
import service.FileReaderImpl;
import service.FileWriter;
import service.FileWriterImpl;
import service.FruitStoreServiceImpl;
import strategy.BalanceStrategy;
import strategy.PurchaseStrategy;
import strategy.ReturnStrategy;
import strategy.SupplyStrategy;
import strategy.TransactionStrategy;

public class FruitStoreMain {
    private static final String INPUT_FILE_NAME = "src/main/resources/storage.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/shop_report.csv";
    private static final Map<FruitTransaction.Operation, TransactionStrategy> strategyMap = Map.of(
            FruitTransaction.Operation.BALANCE, new BalanceStrategy(),
            FruitTransaction.Operation.SUPPLY, new SupplyStrategy(),
            FruitTransaction.Operation.PURCHASE, new PurchaseStrategy(),
            FruitTransaction.Operation.RETURN, new ReturnStrategy());

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<FruitTransaction> fruitTransactionStorage = fileReader.read(INPUT_FILE_NAME);

        FruitStoreServiceImpl fruitStoreService = new FruitStoreServiceImpl(strategyMap);
        FruitStorage fruitStorage = fruitStoreService.processTransactions(fruitTransactionStorage);

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(fruitStorage, REPORT_FILE_NAME);
    }
}
