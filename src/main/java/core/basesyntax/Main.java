package core.basesyntax;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.Operation;
import core.basesyntax.service.impl.FileReaderCvs;
import core.basesyntax.service.impl.FileWriterCvs;
import core.basesyntax.service.impl.FruitQuantityCounter;
import core.basesyntax.service.impl.FruitTransactionParsing;
import core.basesyntax.service.impl.FruitTransactionProcessor;
import core.basesyntax.service.impl.OperationStrategy;
import core.basesyntax.service.impl.ReportCreator;
import core.basesyntax.service.operations.strategy.BalanceOperationHandler;
import core.basesyntax.service.operations.strategy.IOperationHandler;
import core.basesyntax.service.operations.strategy.PurchaseOperationHandler;
import core.basesyntax.service.operations.strategy.ReturnOperationHandler;
import core.basesyntax.service.operations.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final String READ_PATH = "src/main/java/core/basesyntax/resources/activities.csv";
    public static final String WRITE_PATH = "src/main/java/core/basesyntax/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, IOperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandler());

        Map<String, Operation> codeOperationMap = new HashMap<>();
        codeOperationMap.put("b", Operation.BALANCE);
        codeOperationMap.put("s", Operation.SUPPLY);
        codeOperationMap.put("p", Operation.PURCHASE);
        codeOperationMap.put("r", Operation.RETURN);

        FruitTransactionDao fruitTransactionDao = new FruitTransactionDao();

        FileReaderCvs fileReaderCvs = new FileReaderCvs();
        FileWriterCvs fileWriterCvs = new FileWriterCvs();

        FruitTransactionParsing fruitTransactionParsing =
                new FruitTransactionParsing(codeOperationMap);
        FruitTransactionProcessor fruitTransactionProcessor =
                new FruitTransactionProcessor(fruitTransactionDao);

        FruitQuantityCounter fruitQuantityCounter =
                new FruitQuantityCounter(fruitTransactionDao,
                        new OperationStrategy(operationHandlerMap));
        ReportCreator reportCreator = new ReportCreator();

        fruitTransactionProcessor.process(
                fruitTransactionParsing.parse(
                        fileReaderCvs.read(READ_PATH)));

        fileWriterCvs.write(WRITE_PATH,
                reportCreator.create(
                        fruitQuantityCounter.get()));
    }
}
