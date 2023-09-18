package core.basesyntax;

import core.basesyntax.operation.Operation;
import core.basesyntax.operation.OperationBalance;
import core.basesyntax.operation.OperationPurchase;
import core.basesyntax.operation.OperationReturn;
import core.basesyntax.operation.OperationSupply;
import core.basesyntax.servise.FruitStockUpdater;
import core.basesyntax.servise.FruitStockUpdaterImp;
import core.basesyntax.servise.FruitTransactionService;
import core.basesyntax.servise.FruitTransactionServiceImp;
import core.basesyntax.servise.ReportCreator;
import core.basesyntax.servise.ReportCreatorImp;
import core.basesyntax.servise.fileservice.FileReaderUtility;
import core.basesyntax.servise.fileservice.FileReaderUtilityImp;
import core.basesyntax.servise.fileservice.FileReportWriter;
import core.basesyntax.servise.fileservice.FileReportWriterImp;
import core.basesyntax.storage.Storage;
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
        FruitStockUpdater fruitStockUpdater = new FruitStockUpdaterImp(getFruitStrategy());
        fruitStockUpdater.processTransactions(fruitTransactionService
                .createTransactionList(fileReaderUtility.retrieveFileData(pathName)));
        ReportCreator report = new ReportCreatorImp();
        FileReportWriter fileReportWriter = new FileReportWriterImp();
        return fileReportWriter.writeReportToFile(report.createReport());
    }

    private static Map<FruitTransaction.Operation, Operation> getFruitStrategy() {
        Storage.storage.clear();
        Map<FruitTransaction.Operation, Operation> fruitStrategy = new HashMap<>();
        fruitStrategy.put(FruitTransaction.Operation.BALANCE, new OperationBalance());
        fruitStrategy.put(FruitTransaction.Operation.SUPPLY, new OperationSupply());
        fruitStrategy.put(FruitTransaction.Operation.PURCHASE, new OperationPurchase());
        fruitStrategy.put(FruitTransaction.Operation.RETURN, new OperationReturn());
        return fruitStrategy;
    }

}
