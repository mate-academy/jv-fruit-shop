import core.basesyntax.dao.RemnantsDao;
import core.basesyntax.dao.RemnantsDaoMap;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FileServiceImpl;
import core.basesyntax.service.InputOutputService;
import core.basesyntax.service.InputOutputServiceImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.OperationTypes;
import core.basesyntax.service.StoreService;
import core.basesyntax.service.StoreServiceImpl;
import core.basesyntax.service.operationhandler.BalanceHandler;
import core.basesyntax.service.operationhandler.OperationHandler;
import core.basesyntax.service.operationhandler.PurchaseHandler;
import core.basesyntax.service.operationhandler.ReturnHandler;
import core.basesyntax.service.operationhandler.SupplyHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        RemnantsDao remnantsDao = new RemnantsDaoMap();
        InputOutputService inputOutputService = new InputOutputServiceImpl();
        FileService fileService = new FileServiceImpl();
        Map<OperationTypes, OperationHandler> operationHandlersMap = new HashMap<>();
        operationHandlersMap.put(OperationTypes.BALANCE, new BalanceHandler());
        operationHandlersMap.put(OperationTypes.SUPPLY, new SupplyHandler());
        operationHandlersMap.put(OperationTypes.PURCHASE, new PurchaseHandler());
        operationHandlersMap.put(OperationTypes.RETURN, new ReturnHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlersMap);
        StoreService storeService = new StoreServiceImpl(
                remnantsDao, inputOutputService, fileService, operationStrategy);
        String date = "2022.01.02";
        storeService.processInputFile(date);
        storeService.generateReport(date);
    }
}
