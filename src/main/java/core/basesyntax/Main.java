package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ReportWriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.OperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_PATH = "src/main/resources/input.csv";
    public static final String REPORT_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperation(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation(fruitDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        List<FruitTransaction> fruitTransactions = new FruitTransactionParserImpl()
                .parseFruitTransaction(new ReaderServiceImpl().read(INPUT_PATH));
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.processData(fruitTransactions);
        new ReportWriterServiceImpl()
                .writeReport(new ReportGeneratorImpl()
                        .generateReport(new FruitDaoImpl()), REPORT_PATH);
    }
}
