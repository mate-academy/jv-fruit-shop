package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.OperationValidatorImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.strategy.OperationHandlerBalanceImpl;
import core.basesyntax.strategy.OperationHandlerImplSupply;
import core.basesyntax.strategy.OperationHandlerPurchaseImpl;
import core.basesyntax.strategy.OperationHandlerReturnImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "output.csv";

    public static void main(String[] args) {
        Map<String, FruitTransaction.Operation> operations = new HashMap<>();
        operations.put("b",FruitTransaction.Operation.BALANCE);
        operations.put("s",FruitTransaction.Operation.SUPPLY);
        operations.put("r",FruitTransaction.Operation.RETURN);
        operations.put("p",FruitTransaction.Operation.PURCHASE);
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE,
                new OperationHandlerBalanceImpl());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY,
                new OperationHandlerImplSupply());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new OperationHandlerPurchaseImpl());
        operationHandlers.put(FruitTransaction.Operation.RETURN,
                new OperationHandlerReturnImpl());
        List<String> fruitTransations = new FileReaderImpl().read(INPUT_FILE_PATH);
        OperationValidatorImpl operationValidator = new OperationValidatorImpl(operations);
        List<FruitTransaction> parse = new TransactionParserImpl(operationValidator)
                .parse(fruitTransations);
        TransactionService service = new TransactionServiceImpl(operationHandlers);
        service.handleTransaction(parse);
        String report = new ReportServiceImpl().generateReport();
        String path = OUTPUT_FILE_PATH;
        new FileWriterImpl().writeData(path,report);
    }
}
