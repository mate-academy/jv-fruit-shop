package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.*;
import core.basesyntax.service.impl.ReaderFromCsvFileImpl;
import core.basesyntax.service.impl.TransferImpl;
import core.basesyntax.service.impl.WriterToCsvFileImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Fruit.Operation, Operation> operationMap = new HashMap<>();
        operationMap.put(Fruit.Operation.BALANCE, new BalanceOperation());
        operationMap.put(Fruit.Operation.SUPPLY, new SupplyOperation());
        operationMap.put(Fruit.Operation.PURCHASE, new PurchaseOperation());
        operationMap.put(Fruit.Operation.RETURN, new ReturnOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);
        String fromFile = "src/main/resources/testFile.csv";
        String toFile = "src/main/resources/resultTestFile.csv";
        ReaderFromCsvFile readerFromCsvFile = new ReaderFromCsvFileImpl();
        WriterToCsvFile writerToCsvFile = new WriterToCsvFileImpl();
        Transfer transfer = new TransferImpl();

        String[] infoData = readerFromCsvFile.readFromFile(fromFile);
        transfer.generateInfo(infoData, operationStrategy);
        String reportData = transfer.report(Storage.fruitData);
        writerToCsvFile.writeToFile(toFile,reportData);
    }
}
