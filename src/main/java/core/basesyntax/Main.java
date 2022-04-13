package core.basesyntax;

import core.basesyntax.dto.Transaction;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ValidatorImpl;
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
        FileReader reader = new FileReaderImpl();
        Parser parser = new ParserImpl(new ValidatorImpl());
        List<Transaction> transactionList = parser.parseLines(reader
                .readFromFile("src/main/resources/input_report.csv"));
        FruitService fruitService = new FruitServiceImpl(handlerMap);
        fruitService.applyOperations(transactionList);
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport();
        FileWriter writer = new FileWriterImpl();
        writer.writeToFile(report,"src/main/resources/fruit_report.csv");
    }
}
