import static core.basesyntax.Constants.INPUT_DATA_FILE_NAME;
import static core.basesyntax.Constants.REPORT_FILE_NAME;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.handler.OrderReturnHandler;
import core.basesyntax.handler.PurchaseHandler;
import core.basesyntax.handler.ReportHandler;
import core.basesyntax.handler.SupplierHandler;
import core.basesyntax.handler.impl.OrderReturnHandlerImpl;
import core.basesyntax.handler.impl.PurchaseHandlerImpl;
import core.basesyntax.handler.impl.ReportHandlerImpl;
import core.basesyntax.handler.impl.SupplierHandlerImpl;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.OrderReturnService;
import core.basesyntax.service.PurchaseService;
import core.basesyntax.service.ReadFromFileService;
import core.basesyntax.service.SupplierService;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.OperationServiceImpl;
import core.basesyntax.service.impl.OrderReturnServiceImpl;
import core.basesyntax.service.impl.PurchaseServiceImpl;
import core.basesyntax.service.impl.ReadFromFileServiceImpl;
import core.basesyntax.service.impl.SupplierServiceImpl;
import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FruitsStorage fruitsStorage = new FruitsStorage();
        OperationService operationService = new OperationServiceImpl();
        DataParserService dataParserService = new DataParserServiceImpl(operationService);

        // 1. Read data from file
        ReadFromFileService fileReader = new ReadFromFileServiceImpl();
        List<String> dataFromFile = fileReader.redData("src"
                        + File.separator + "main" + File.separator + "resources"
                        + File.separator + INPUT_DATA_FILE_NAME);

        // 2. Add data to data storage
        SupplierHandler supplierHandler = new SupplierHandlerImpl(fruitsStorage);
        SupplierService supplierService = new SupplierServiceImpl(
                supplierHandler, dataParserService);
        supplierService.add(dataFromFile);

        // 3. Subtract values
        PurchaseHandler purchaseHandler = new PurchaseHandlerImpl(fruitsStorage);
        PurchaseService purchaseService = new PurchaseServiceImpl(
                purchaseHandler, dataParserService);
        purchaseService.purchase(dataFromFile);

        // 4. Return order
        OrderReturnHandler orderReturnHandler = new OrderReturnHandlerImpl(fruitsStorage);
        OrderReturnService orderReturnService = new OrderReturnServiceImpl(
                orderReturnHandler, dataParserService);
        orderReturnService.returnOrder(dataFromFile);

        // 5. Get report
        ReportHandler reportHandler = new ReportHandlerImpl(fruitsStorage);
        reportHandler.getReport("src"
                + File.separator + "main" + File.separator + "resources"
                + File.separator + REPORT_FILE_NAME);
    }
}
