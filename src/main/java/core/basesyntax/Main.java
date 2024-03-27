package core.basesyntax;

import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.service.impl.FileReaderCvsImpl;
import core.basesyntax.service.impl.FileWriterCvsImpl;
import core.basesyntax.service.impl.FruitTransactionParsingImpl;
import core.basesyntax.service.impl.FruitTransactionProcessorImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.operations.strategy.BalanceOperationHandler;
import core.basesyntax.service.operations.strategy.OperationHandler;
import core.basesyntax.service.operations.strategy.PurchaseOperationHandler;
import core.basesyntax.service.operations.strategy.ReturnOperationHandler;
import core.basesyntax.service.operations.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final String READ_PATH = "src/main/java/core/basesyntax/resources/activities.csv";
    public static final String WRITE_PATH = "src/main/java/core/basesyntax/resources/report.csv";

    public static void main(String[] args) {
        FruitTransactionDaoImpl fruitTransactionDaoImpl = new FruitTransactionDaoImpl();

        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE,
                new BalanceOperationHandler(fruitTransactionDaoImpl));
        operationHandlerMap.put(Operation.SUPPLY,
                new SupplyOperationHandler(fruitTransactionDaoImpl));
        operationHandlerMap.put(Operation.PURCHASE,
                new PurchaseOperationHandler(fruitTransactionDaoImpl));
        operationHandlerMap.put(Operation.RETURN,
                new ReturnOperationHandler(fruitTransactionDaoImpl));

        Map<String, Operation> codeOperationMap = new HashMap<>();
        codeOperationMap.put("b", Operation.BALANCE);
        codeOperationMap.put("s", Operation.SUPPLY);
        codeOperationMap.put("p", Operation.PURCHASE);
        codeOperationMap.put("r", Operation.RETURN);

        FileReaderCvsImpl fileReaderCvsImpl = new FileReaderCvsImpl();
        FileWriterCvsImpl fileWriterCvsImpl = new FileWriterCvsImpl();

        FruitTransactionParsingImpl fruitTransactionParsingImpl =
                new FruitTransactionParsingImpl(codeOperationMap);
        FruitTransactionProcessorImpl fruitTransactionProcessorImpl =
                new FruitTransactionProcessorImpl(new OperationStrategyImpl(operationHandlerMap));
        ReportCreatorImpl reportCreatorImpl = new ReportCreatorImpl(fruitTransactionDaoImpl);

        fruitTransactionProcessorImpl.process(
                fruitTransactionParsingImpl.parse(
                        fileReaderCvsImpl.read(READ_PATH)));

        fileWriterCvsImpl.write(WRITE_PATH, reportCreatorImpl.create());
    }
}
