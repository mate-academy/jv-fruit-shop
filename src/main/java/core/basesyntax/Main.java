package core.basesyntax;

import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.impl.CreateReportServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.TransactionParseServiceImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationMap.put(Operation.RETURN, new ReturnOperationHandler());

        List<String> input = new FileReaderServiceImpl().readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions = new TransactionParseServiceImpl()
                .parseInputData(input);
        new FruitStorageDaoImpl(new OperationStrategyImpl(operationMap))
                .addToStorage(fruitTransactions);

        String report = new CreateReportServiceImpl().createReport(FruitStorage.storage);
        new FileWriterServiceImpl().writeToFile(REPORT_FILE_PATH, report);
    }
}
