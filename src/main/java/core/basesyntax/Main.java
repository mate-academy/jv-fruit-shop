package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.impl.FruitServiceImpl;
import core.basesyntax.impl.GenerateReportServiceImpl;
import core.basesyntax.impl.InputDataErrorsServiceImpl;
import core.basesyntax.impl.ReadCsvErrorsServiceImpl;
import core.basesyntax.impl.TransactionStrategyImpl;
import core.basesyntax.impl.WriteReportServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.GenerateReportService;
import core.basesyntax.service.InputDataService;
import core.basesyntax.service.ReadCsvService;
import core.basesyntax.service.WriteReportService;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.transaction.BalanceTransactionHandler;
import core.basesyntax.strategy.transaction.PurchaseTransactionHandler;
import core.basesyntax.strategy.transaction.ReturnTransactionHandler;
import core.basesyntax.strategy.transaction.SupplyTransactionHandler;
import core.basesyntax.strategy.transaction.TransactionHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ReadCsvService readCsvService = new ReadCsvErrorsServiceImpl();
        List<String> dataCsv = readCsvService.readFromFile("src/main/resources/inputData.csv");

        InputDataService inputDataService = new InputDataErrorsServiceImpl();
        List<FruitTransaction> fruitTransactions = inputDataService.convertDataToObj(dataCsv);

        GenerateReportService generateReportService =
                new GenerateReportServiceImpl(transactionStrategyInit(), fruitDaoInit());
        generateReportService.updateFruitQuantities(fruitTransactions);

        WriteReportService writeReportService = new WriteReportServiceImpl();
        writeReportService.writeReport(Storage.fruitDB, "src/main/resources/dayReport.csv");
    }

    public static TransactionStrategy transactionStrategyInit() {
        Map<FruitTransaction.Operation, TransactionHandler> transactionHandlerMap =
                new HashMap<>();

        transactionHandlerMap.put(
                FruitTransaction.Operation.BALANCE, new BalanceTransactionHandler());
        transactionHandlerMap.put(
                FruitTransaction.Operation.SUPPLY, new SupplyTransactionHandler());
        transactionHandlerMap.put(
                FruitTransaction.Operation.PURCHASE, new PurchaseTransactionHandler());
        transactionHandlerMap.put(
                FruitTransaction.Operation.RETURN, new ReturnTransactionHandler());

        return new TransactionStrategyImpl(transactionHandlerMap);
    }

    public static FruitDao fruitDaoInit() {
        FruitDao fruitDao = new FruitDaoImpl();
        FruitService fruitService = new FruitServiceImpl(fruitDao);
        fruitService.createNewFruit("banana");
        fruitService.createNewFruit("apple");

        return fruitDao;
    }
}
