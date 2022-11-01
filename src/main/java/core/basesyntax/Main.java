package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.ParseFruitTransaction;
import core.basesyntax.service.ParseFruitTransactionImpl;
import core.basesyntax.service.Reporter;
import core.basesyntax.service.impl.DataReaderCsvImpl;
import core.basesyntax.service.impl.DataWriterCsvImpl;
import core.basesyntax.service.impl.ReporterImpl;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import core.basesyntax.service.operation.impl.OperationHandlerBalance;
import core.basesyntax.service.operation.impl.OperationHandlerPurchase;
import core.basesyntax.service.operation.impl.OperationHandlerReturn;
import core.basesyntax.service.operation.impl.OperationHandlerSupply;
import core.basesyntax.service.operation.impl.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String DATA_PATH = "src/main/java/resources/fruits.csv";
    private static final String REPORT_PATH = "src/main/java/resources/report.csv";

    public static void main(String[] args) {
        DataReader dataReader = new DataReaderCsvImpl();
        final List<String> inputData = dataReader.read(DATA_PATH);
        final ParseFruitTransaction fruitTransaction = new ParseFruitTransactionImpl();
        Map<Operation, OperationHandler> operationsMap = new HashMap<>();
        operationsMap.put(Operation.BALANCE, new OperationHandlerBalance());
        operationsMap.put(Operation.PURCHASE, new OperationHandlerPurchase());
        operationsMap.put(Operation.SUPPLY, new OperationHandlerSupply());
        operationsMap.put(Operation.RETURN, new OperationHandlerReturn());
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        operationStrategy.fillOperationsList(operationsMap);
        fruitTransaction.parseFruitTransaction(inputData, operationStrategy);
        DataWriter dataWriter = new DataWriterCsvImpl();
        Reporter reporter = new ReporterImpl();
        dataWriter.write(reporter.doReport(Storage.fruitStorage), REPORT_PATH);
    }
}
