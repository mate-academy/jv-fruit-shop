package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.OperationHandler;
import core.basesyntax.services.TransactionService;
import core.basesyntax.services.impl.FileReaderImpl;
import core.basesyntax.services.impl.FileWriterImpl;
import core.basesyntax.services.impl.ReportServiceImpl;
import core.basesyntax.services.impl.TransactionParserImpl;
import core.basesyntax.services.impl.TransactionServiceImpl;
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
        Map<FruitTransaction.Operation, OperationHandler> operations = new HashMap<>();
        operations.put(FruitTransaction.Operation.BALANCE, new OperationHandlerBalanceImpl());
        operations.put(FruitTransaction.Operation.SUPPLY, new OperationHandlerImplSupply());
        operations.put(FruitTransaction.Operation.PURCHASE, new OperationHandlerPurchaseImpl());
        operations.put(FruitTransaction.Operation.RETURN, new OperationHandlerReturnImpl());
        List<String> fruitTransations = new FileReaderImpl().read(INPUT_FILE_PATH);
        List<FruitTransaction> parse = new TransactionParserImpl().parse(fruitTransations);
        TransactionService service = new TransactionServiceImpl(operations);
        service.handleTransaction(parse);
        String report = new ReportServiceImpl().generateReport();
        String path = OUTPUT_FILE_PATH;
        new FileWriterImpl().writeDate(path,report);
    }
}
