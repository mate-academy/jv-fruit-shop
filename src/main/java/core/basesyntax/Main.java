package core.basesyntax;

import core.basesyntax.database.DataBase;
import core.basesyntax.database.Operation;
import core.basesyntax.handlers.BalanceOperationHandler;
import core.basesyntax.handlers.PurchaseOperationHandler;
import core.basesyntax.handlers.ReturnOperationHandler;
import core.basesyntax.handlers.SupplyOperationHandler;
import core.basesyntax.impl.FileReaderImpl;
import core.basesyntax.impl.FileWriterServiceImpl;
import core.basesyntax.impl.FruitshopServiceImpl;
import core.basesyntax.impl.ReportServiceImpl;
import core.basesyntax.impl.TransactionServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.TransactionService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Operation, OperationHandler> handlerMap = new HashMap<>();
    private static final String DATA_FILE_PATH = "./src/main/resources/beginningData";
    private static final String REPORT_FILE_PATH = "./src/main/resources/report";

    public static void main(String[] args) {
        FileWriterService writer = new FileWriterServiceImpl();
        FileReader reader = new FileReaderImpl();
        ReportServiceImpl createReport = new ReportServiceImpl();
        TransactionService transactionService = new TransactionServiceImpl();
        DataBase dataBase = new DataBase();
        FruitshopServiceImpl shop = new FruitshopServiceImpl(createMapOfOperaions());
        List<String> strings = reader.readDataFromFile(DATA_FILE_PATH);
        List<FruitTransaction> fruitTransactions = transactionService.parseData(strings);
        shop.processData(fruitTransactions, createMapOfOperaions());
        String report = createReport.createReport();
        writer.write(REPORT_FILE_PATH, report);
    }

    public static Map<Operation, OperationHandler> createMapOfOperaions() {
        handlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        handlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        handlerMap.put(Operation.RETURN, new ReturnOperationHandler());
        handlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        return handlerMap;
    }
}
