package core.basesyntax;

import core.basesyntax.database.DataBase;
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
    public static void main(String[] args) {
        FileWriterService writer = new FileWriterServiceImpl();
        FileReader reader = new FileReaderImpl();
        ReportServiceImpl createReport = new ReportServiceImpl();
        TransactionService transactionService = new TransactionServiceImpl();
        DataBase dataBase = new DataBase();
        FruitshopServiceImpl shop = new FruitshopServiceImpl(createMapOfOperaions());
        List<String> strings = reader.readDataFromFile(dataBase.getDataFilePath());
        List<FruitTransaction> fruitTransactions = transactionService.parseData(strings);
        shop.processData(fruitTransactions, createMapOfOperaions());
        String report = createReport.createReport();
        writer.write(dataBase.getReportFilePath(), report);
    }

    public static Map<DataBase.Operation, OperationHandler> createMapOfOperaions() {
        Map<DataBase.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(DataBase.Operation.BALANCE, new BalanceOperationHandler());
        handlerMap.put(DataBase.Operation.PURCHASE, new PurchaseOperationHandler());
        handlerMap.put(DataBase.Operation.RETURN, new ReturnOperationHandler());
        handlerMap.put(DataBase.Operation.SUPPLY, new SupplyOperationHandler());
        return handlerMap;
    }
}
