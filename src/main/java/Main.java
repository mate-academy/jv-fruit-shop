import static core.basesyntax.Constants.INPUT_DATA_FILE_NAME;
import static core.basesyntax.Constants.REPORT_FILE_NAME;

import core.basesyntax.handler.BalanceHandler;
import core.basesyntax.handler.OrderReturnHandler;
import core.basesyntax.handler.PurchaseHandler;
import core.basesyntax.handler.ReportHandler;
import core.basesyntax.handler.SupplierHandler;
import core.basesyntax.handler.impl.BalanceHandlerImpl;
import core.basesyntax.handler.impl.OrderReturnHandlerImpl;
import core.basesyntax.handler.impl.PurchaseHandlerImpl;
import core.basesyntax.handler.impl.ReportHandlerImpl;
import core.basesyntax.handler.impl.SupplierHandlerImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.ReadDataService;
import core.basesyntax.service.impl.BalanceImpl;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.OperationServiceImpl;
import core.basesyntax.service.impl.PurchaseServiceImpl;
import core.basesyntax.service.impl.ReadDataServiceImpl;
import core.basesyntax.service.impl.ReturnOperationServiceImpl;
import core.basesyntax.service.impl.SupplierServiceImpl;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.impl.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        OperationService operationService = new OperationServiceImpl();
        DataParserService dataParserService = new DataParserServiceImpl(operationService);
        SupplierHandler supplierHandler = new SupplierHandlerImpl();
        OrderReturnHandler orderReturnHandler = new OrderReturnHandlerImpl();
        PurchaseHandler purchaseHandler = new PurchaseHandlerImpl();
        BalanceHandler balanceHandler = new BalanceHandlerImpl();

        // Read data from file
        ReadDataService fileReader = new ReadDataServiceImpl();
        List<String> dataFromFile = fileReader.readData(INPUT_DATA_FILE_NAME);

        Map<Operation, OperationHandler> operationStarategyMap = new HashMap<>();
        operationStarategyMap.put(
                Operation.BALANCE, new BalanceImpl(balanceHandler));
        operationStarategyMap.put(
                Operation.PURCHASE, new PurchaseServiceImpl(purchaseHandler));
        operationStarategyMap.put(
                Operation.SUPPLY, new SupplierServiceImpl(supplierHandler));
        operationStarategyMap.put(
                Operation.RETURN, new ReturnOperationServiceImpl(orderReturnHandler));

        List<FruitTransaction> fruitTransaction = dataParserService
                .createFruitTransaction(dataFromFile);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationStarategyMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        fruitShopService.processData(fruitTransaction);

        // Get report
        ReportHandler reportHandler = new ReportHandlerImpl();
        reportHandler.getReport(REPORT_FILE_NAME);
    }
}
