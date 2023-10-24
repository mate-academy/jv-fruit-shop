package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataProcessing;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.Writer;
import core.basesyntax.service.handler.impl.BalanceOperationHandler;
import core.basesyntax.service.handler.impl.PurchaseOperationHandler;
import core.basesyntax.service.handler.impl.ReturnOperationHandler;
import core.basesyntax.service.handler.impl.SupplyOperationHandler;
import core.basesyntax.service.impl.CsvWriter;
import core.basesyntax.service.impl.DataProcessingImpl;
import core.basesyntax.service.impl.DataReaderFromCsv;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String FILE_FROM = "src/main/resources/data.csv";
    private static final String FILE_TO = "src/main/resources/report.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE,
                new BalanceOperationHandler(storageDao));
        operationHandlerMap.put(Operation.SUPPLY,
                new SupplyOperationHandler(storageDao));
        operationHandlerMap.put(Operation.PURCHASE,
                new PurchaseOperationHandler(storageDao));
        operationHandlerMap.put(Operation.RETURN,
                new ReturnOperationHandler(storageDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        DataReader dataReader = new DataReaderFromCsv();
        DataProcessing dataProcessing = new DataProcessingImpl(operationStrategy);
        ReportCreator reportCreator = new ReportCreatorImpl(storageDao);
        Writer writer = new CsvWriter();
        FruitShopServiceImpl fruitShopService = new FruitShopServiceImpl(dataReader,
                dataProcessing, reportCreator, writer);
        fruitShopService.createDailyReport(FILE_FROM, FILE_TO);
    }
}
