package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.Transaction;
import core.basesyntax.service.impl.*;
import core.basesyntax.strategy.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    String dataFile = "src/main/resources/data.csv";
        StrategyControllerImpl strategyController = new StrategyControllerImpl();
        strategyController.setStrategy(FruitTransaction.Operation.BALANCE, new FruitShopStrategyBalance());
        strategyController.setStrategy(FruitTransaction.Operation.PURCHASE, new FruitShopStrategyPurchase());
        strategyController.setStrategy(FruitTransaction.Operation.RETURN, new FruitShopStrategyReturn());
        strategyController.setStrategy(FruitTransaction.Operation.SUPPLY, new FruitShopStrategySupply());
        CsvFileReaderServiceImpl readerService = new CsvFileReaderServiceImpl();
        List<String> strings = readerService.readFile(dataFile);
        ParseService parseService = new ParseServiceImpl();
        Transaction transaction = new TransactionImpl();
        for (int i = 1; i < strings.size(); i++) {
            FruitTransaction fruitTransaction = parseService.fruitTransaction(strings.get(i));
            transaction.transaction(fruitTransaction, strategyController);
        }
        System.out.println(Storage.getFruitsStorage().keySet() + " " + Storage.getFruitsStorage().values());
        EndOfTheDayReport report = new EndOfTheDayReport();
        List<String> report1 = report.getReport();
        System.out.println(report1);

    }

}
