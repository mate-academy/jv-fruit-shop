package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.servise.FileReaderUtility;
import core.basesyntax.servise.FileWriterUtility;
import core.basesyntax.servise.FruitStockUpdater;
import core.basesyntax.servise.FruitTransactionService;
import core.basesyntax.servise.ReportCreator;
import core.basesyntax.servise.impl.FileReaderUtilityImp;
import core.basesyntax.servise.impl.FileReportWriterImp;
import core.basesyntax.servise.impl.FruitStockUpdaterImp;
import core.basesyntax.servise.impl.FruitTransactionServiceImp;
import core.basesyntax.servise.impl.ReportCreatorImp;
import core.basesyntax.strategy.BalanceTransactionHandler;
import core.basesyntax.strategy.PurchaseTransactionHandler;
import core.basesyntax.strategy.ReturnTransactionHandler;
import core.basesyntax.strategy.SupplyTransactionHandler;
import core.basesyntax.strategy.TransactionHandler;
import core.basesyntax.strategy.impl.TransactionHandlerStrategyImp;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String PATH_NAME = "src/main/java/core/basesyntax/files/file.csv";
    private static final String PATH_NAME_REPORT = "src/main/java/core/basesyntax/files/report "
            + LocalDate.now() + ".csv";

    public static void main(String[] args) {
        createReportFile(PATH_NAME);
    }

    public static String createReportFile(String pathName) {
        FileReaderUtility fileReaderUtility = new FileReaderUtilityImp();
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImp();
        FruitStockUpdater fruitStockUpdater =
                new FruitStockUpdaterImp(new TransactionHandlerStrategyImp(getFruitStrategyMap()));
        fruitStockUpdater.processTransactions(fruitTransactionService
                .createTransactionList(fileReaderUtility.retrieveFileData(pathName)));
        ReportCreator reportCreator = new ReportCreatorImp();
        FileWriterUtility fileReportWriter = new FileReportWriterImp();
        return fileReportWriter.writeReportToFile(reportCreator.createReport(), PATH_NAME_REPORT);
    }

    private static Map<FruitTransaction.Operation, TransactionHandler> getFruitStrategyMap() {
        Storage.storage.clear();
        Map<FruitTransaction.Operation, TransactionHandler> fruitStrategy = new HashMap<>();
        fruitStrategy.put(FruitTransaction.Operation.BALANCE, new BalanceTransactionHandler());
        fruitStrategy.put(FruitTransaction.Operation.SUPPLY, new SupplyTransactionHandler());
        fruitStrategy.put(FruitTransaction.Operation.PURCHASE, new PurchaseTransactionHandler());
        fruitStrategy.put(FruitTransaction.Operation.RETURN, new ReturnTransactionHandler());
        return fruitStrategy;
    }

}
