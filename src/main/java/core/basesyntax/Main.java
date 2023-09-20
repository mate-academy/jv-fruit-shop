package core.basesyntax;

import core.basesyntax.operation.BalanceTransactionHandler;
import core.basesyntax.operation.PurchaseTransactionHandler;
import core.basesyntax.operation.ReturnTransactionHandler;
import core.basesyntax.operation.SupplyTransactionHandler;
import core.basesyntax.operation.TransactionHandler;
import core.basesyntax.operation.TransactionHandlerStrategyImp;
import core.basesyntax.servise.FruitStockUpdater;
import core.basesyntax.servise.FruitStockUpdaterImp;
import core.basesyntax.servise.FruitTransactionService;
import core.basesyntax.servise.FruitTransactionServiceImp;
import core.basesyntax.servise.ReportCreator;
import core.basesyntax.servise.ReportCreatorImp;
import core.basesyntax.servise.fileservice.FileReaderUtility;
import core.basesyntax.servise.fileservice.FileReaderUtilityImp;
import core.basesyntax.servise.fileservice.FileReportWriterImp;
import core.basesyntax.servise.fileservice.FileWriterUtility;
import core.basesyntax.storage.Storage;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String pathName = "src/main/java/core/basesyntax/files/file.csv";
        createReportFile(pathName);
    }

    public static String createReportFile(String pathName) {
        FileReaderUtility fileReaderUtility = new FileReaderUtilityImp();
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImp();
        FruitStockUpdater fruitStockUpdater =
                new FruitStockUpdaterImp(new TransactionHandlerStrategyImp(getFruitStrategyMap()));
        fruitStockUpdater.processTransactions(fruitTransactionService
                .createTransactionList(fileReaderUtility.retrieveFileData(pathName)));
        ReportCreator reportCreator = new ReportCreatorImp();
        String pathNameReport = "src/main/java/core/basesyntax/files/report "
                + LocalDate.now() + ".csv";
        FileWriterUtility fileReportWriter = new FileReportWriterImp();
        return fileReportWriter.writeReportToFile(reportCreator.createReport(), pathNameReport);
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
