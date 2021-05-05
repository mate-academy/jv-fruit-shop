package core.basesyntax;

import core.basesyntax.dao.StoreDao;
import core.basesyntax.dao.StoreDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileService;
import core.basesyntax.service.RecordStrategy;
import core.basesyntax.service.StoreService;
import core.basesyntax.service.handler.BalanceOperationHandler;
import core.basesyntax.service.handler.OperationHandler;
import core.basesyntax.service.handler.PurchaseOperationHandler;
import core.basesyntax.service.handler.ReturnOperationHandler;
import core.basesyntax.service.handler.SupplyOperationHandler;
import core.basesyntax.service.impls.FileServiceImpl;
import core.basesyntax.service.impls.RecordStrategyImpl;
import core.basesyntax.service.impls.StoreServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    private static final String INPUT_DATA_FILE = "src/main/resources/shoplog.csv";
    private static final String OUTPUT_DATA_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE.getType(), new BalanceOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY.getType(), new SupplyOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE.getType(), new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.RETURN.getType(), new ReturnOperationHandler());

        RecordStrategy recordStrategy = new RecordStrategyImpl(operationHandlerMap);
        StoreDao storeDao = new StoreDaoImpl();
        StoreService storeService = new StoreServiceImpl(storeDao, recordStrategy);

        FileService readerService = new FileServiceImpl();
        List<String> data = readerService.readFile(INPUT_DATA_FILE);
        storeService.toStorage(data);

        FileService writerService = new FileServiceImpl();
        String report = storeService.createReport();
        writerService.writeToFile(report, OUTPUT_DATA_FILE);

    }

}
