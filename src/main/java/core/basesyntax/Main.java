package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReaderFromFile;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.Transfer;
import core.basesyntax.service.WriterToFile;
import core.basesyntax.service.impl.ReaderFromFileImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransferImpl;
import core.basesyntax.service.impl.WriterToFileImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);
        String fromFile = "src/main/resources/testFile.csv";
        String toFile = "src/main/resources/resultTestFile.csv";
        ReaderFromFile readerFromCsvFile = new ReaderFromFileImpl();
        WriterToFile writerToCsvFile = new WriterToFileImpl();
        Transfer transfer = new TransferImpl();
        ReportService reportService = new ReportServiceImpl();

        String[] infoData = readerFromCsvFile.readFromFile(fromFile);
        transfer.generateInfo(infoData, operationStrategy);
        String reportData = reportService.report(Storage.fruitData);
        writerToCsvFile.writeToFile(toFile,reportData);
    }
}
