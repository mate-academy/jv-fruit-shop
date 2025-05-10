package core.basesyntax;

import core.basesyntax.database.Operation;
import core.basesyntax.handlers.BalanceOperationHandler;
import core.basesyntax.handlers.PurchaseOperationHandler;
import core.basesyntax.handlers.ReturnOperationHandler;
import core.basesyntax.handlers.SupplyOperationHandler;
import core.basesyntax.impl.FileServiceImpl;
import core.basesyntax.impl.FruitshopServiceImpl;
import core.basesyntax.impl.ReportServiceImplService;
import core.basesyntax.impl.TransactionServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FruitshopService;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Operation, OperationHandler> handlerMap = new HashMap<>();
    private static final String DATA_FILE_PATH = "./src/main/resources/beginningData";
    private static final String REPORT_FILE_PATH = "./src/main/resources/report";

    public static void main(String[] args) {
        handlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        handlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        handlerMap.put(Operation.RETURN, new ReturnOperationHandler());
        handlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        FileService service = new FileServiceImpl();
        ReportService createReport = new ReportServiceImplService();
        TransactionService transactionService = new TransactionServiceImpl();
        FruitshopService shop = new FruitshopServiceImpl(handlerMap);
        List<String> strings = service.readDataFromFile(DATA_FILE_PATH);
        List<FruitTransaction> fruitTransactions = transactionService.parseData(strings);
        shop.processData(fruitTransactions);
        String report = createReport.createReport();
        service.write(REPORT_FILE_PATH, report);
    }
}
