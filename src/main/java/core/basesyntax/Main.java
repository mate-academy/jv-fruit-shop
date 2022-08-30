package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalanceOperationHandler;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseOperationHandler;
import core.basesyntax.operation.ReturnOperationHandler;
import core.basesyntax.operation.SupplyOperationHandler;
import core.basesyntax.service.FileDataWriter;
import core.basesyntax.service.implementation.FileDataWriterImpl;
import core.basesyntax.service.implementation.FileReaderImpl;
import core.basesyntax.service.implementation.ParserServiceImpl;
import core.basesyntax.service.implementation.ReportServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_READ_PATH = "directory.csv";
    private static final String FILE_OUTPUT_PATH = "output.csv";
    private static Map<FruitTransaction.Operation, OperationHandler> operations;

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        operations = createHashMap(fruitDao);
        List<String> dataFromFile = new FileReaderImpl().readAllDataOfFile(FILE_READ_PATH);
        List<FruitTransaction> fruitTransactions = new ParserServiceImpl()
                .parse(dataFromFile);
        performOperations(fruitTransactions);
        String report = new ReportServiceImpl().prepareReport(fruitDao.getEntries());
        FileDataWriter writerService = new FileDataWriterImpl();
        writerService.writeData(FILE_OUTPUT_PATH, report);
    }

    private static void performOperations(List<FruitTransaction> fruitTransactions) {
        OperationStrategy operationStrategy = new OperationStrategyImpl(operations);
        fruitTransactions.forEach(fruitTransaction ->
                operationStrategy
                        .get(fruitTransaction.getOperation())
                        .handle(fruitTransaction));
    }

    private static Map<FruitTransaction.Operation, OperationHandler>
                createHashMap(FruitDao fruitDao) {
        Map<FruitTransaction.Operation, OperationHandler> operations = new HashMap<>();
        operations.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(fruitDao));
        operations.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(fruitDao));
        operations.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(fruitDao));
        operations.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(fruitDao));
        return operations;
    }
}
