package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.DataReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationStrategy;
import core.basesyntax.strategy.impl.ReturnOperationStrategy;
import core.basesyntax.strategy.impl.SupplyOperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_PATH = "src/main/resources/input";
    private static final String REPORT_PATH = "src/main/resources/report";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationStrategy());
        operationStrategyMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationStrategy());
        operationStrategyMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationStrategy());
        operationStrategyMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationStrategy());
        List<String> dataLines = new DataReaderServiceImpl().readFile(INPUT_PATH);
        List<FruitTransaction> fruitTransactionsList = new DataParserServiceImpl()
                .getFruitsToList(dataLines);
        OperationStrategy operationStrategy =
                new OperationStrategyImpl(operationStrategyMap);
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.processFruitTransactions(fruitTransactionsList);
        String report = new ReportCreatorServiceImpl().createReport();
        FileWriter reportWriterService = new FileWriterImpl();
        reportWriterService.writeFile(REPORT_PATH, report);
    }
}
