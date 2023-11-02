package core.basesyntax;

import core.basesyntax.model.OperationsWithFruits;
import core.basesyntax.operationshandlers.BalanceOperationHandler;
import core.basesyntax.operationshandlers.OperationHandler;
import core.basesyntax.operationshandlers.PurchaseOperationHandler;
import core.basesyntax.operationshandlers.ReturnOperationHandlers;
import core.basesyntax.operationshandlers.SupplyOperationHandler;
import core.basesyntax.serviceinterfaces.CsvMapper;
import core.basesyntax.serviceinterfaces.FileReader;
import core.basesyntax.serviceinterfaces.ReportCreator;
import core.basesyntax.serviceinterfaces.Writer;
import core.basesyntax.services.CsvMapperImpl;
import core.basesyntax.services.CsvReader;
import core.basesyntax.services.CsvReportCreatorImpl;
import core.basesyntax.services.CsvWriter;
import core.basesyntax.services.FruitShopServiceImpl;
import core.basesyntax.storagedao.StorageDao;
import core.basesyntax.storagedao.StorageDaoImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;

public class Main {
    private static final String FILE_FROM = "core.basesyntax.Files/input.Csv";
    private static final String FILE_TO = "core.basesyntax.Files/Output.Csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        HashMap<OperationsWithFruits, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationsWithFruits.BALANCE,
                new BalanceOperationHandler(storageDao));
        operationHandlerMap.put(OperationsWithFruits.SUPPLY,
                new SupplyOperationHandler(storageDao));
        operationHandlerMap.put(OperationsWithFruits.PURCHASE,
                new PurchaseOperationHandler(storageDao));
        operationHandlerMap.put(OperationsWithFruits.RETURN,
                new ReturnOperationHandlers(storageDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FileReader dataReader = new CsvReader();
        CsvMapper dataProcessing = new CsvMapperImpl(operationStrategy);
        ReportCreator reportCreator = new CsvReportCreatorImpl();
        Writer writer = new CsvWriter();
        FruitShopServiceImpl fruitShopService = new FruitShopServiceImpl(dataReader,
                dataProcessing, reportCreator, writer);
        fruitShopService.createDailyReport(FILE_FROM, FILE_TO);
    }
}
