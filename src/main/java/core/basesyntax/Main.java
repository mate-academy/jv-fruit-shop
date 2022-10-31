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
    public static void main(String[] args) {
        Map<String, OperationHandler> operations = new HashMap<>();
        operations.put("b", new OperationHandlerBalanceImpl());
        operations.put("s", new OperationHandlerImplSupply());
        operations.put("p", new OperationHandlerPurchaseImpl());
        operations.put("r", new OperationHandlerReturnImpl());
        List<String> fruitTransations = new FileReaderImpl().read("src/main/resources/input.csv");
        List<FruitTransaction> parse = new TransactionParserImpl().parse(fruitTransations);
        TransactionService service = new TransactionServiceImpl(operations);
        service.handleTransaction(parse);
        String report = new ReportServiceImpl().generateReport();
        String path = "output.csv";
        new FileWriterImpl().writeDate(path,report);
    }
}
