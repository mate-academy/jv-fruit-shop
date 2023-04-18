package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReaderFromFile;
import core.basesyntax.service.Transfer;
import core.basesyntax.service.WriterToFile;
import core.basesyntax.service.impl.ReaderFromFileImpl;
import core.basesyntax.service.impl.TransferImpl;
import core.basesyntax.service.impl.WriterToFileImpl;
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
        ReaderFromFile readerFromCsvFile = new ReaderFromFileImpl();
        WriterToFile writerToCsvFile = new WriterToFileImpl();
        Transfer transfer = new TransferImpl();

        String[] infoData = readerFromCsvFile.readFromFile(fromFile);
        transfer.generateInfo(infoData, operationStrategy);
        String reportData = transfer.report(Storage.fruitData);
        writerToCsvFile.writeToFile(toFile,reportData);
    }
}
