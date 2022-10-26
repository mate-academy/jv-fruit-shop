package core.basesyntax;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.DataParserImpl;
import core.basesyntax.service.impl.DataReaderImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.ReportWriterImpl;
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
    public static final String DATA_PATH = "src/main/resources/data.csv";
    public static final String REPORT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        activityHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        activityHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        activityHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(activityHandlerMap);

        List<String> data = new DataReaderImpl().readData(DATA_PATH);
        List<FruitTransaction> fruitTransactions = new DataParserImpl().parseData(data);
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.processData(fruitTransactions);
        String report = new ReportCreatorImpl().createReport(new StorageDaoImpl());
        new ReportWriterImpl().writeReport(report, REPORT_PATH);
    }
}
