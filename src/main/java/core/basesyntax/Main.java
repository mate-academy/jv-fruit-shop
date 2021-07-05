package core.basesyntax;

import core.basesyntax.model.OperationType;
import core.basesyntax.dto.Transaction;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceServiceImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.ShopFileReader;
import core.basesyntax.service.ShopFileReaderImpl;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FileWriterImpl;
import core.basesyntax.strategy.AddOperationHandler;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<OperationType, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(OperationType.BALANCE, new BalanceOperationHandler());
        handlerMap.put(OperationType.PURCHASE, new PurchaseOperationHandler());
        handlerMap.put(OperationType.RETURN, new AddOperationHandler());
        handlerMap.put(OperationType.SUPPLY, new AddOperationHandler());
        ShopFileReader reader = new ShopFileReaderImpl();
        List<Transaction> transactionList = reader
                .readFromFile("src/main/resources/input_report.csv");
        FruitService fruitService = new FruitServiceImpl();
        fruitService.addTransaction(handlerMap,transactionList);
        ReportService reportService = new ReportServiceServiceImpl();
        String report = reportService.getReport();
        FileWriter writer = new FileWriterImpl();
        writer.writeToFile(report,"src/main/resources/fruit_report.csv");
    }
}
