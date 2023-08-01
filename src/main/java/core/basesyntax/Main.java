package core.basesyntax;

import java.util.List;
import java.util.Map;
import service.CreateReport;
import service.Parser;
import service.ReaderService;
import service.WriterService;
import service.impl.CreateReportImpl;
import service.impl.FruitTransaction;
import service.impl.ParserImpl;
import service.impl.ReaderServiceCsvImpl;
import service.impl.WriterServiceCsvImpl;
import strategy.handler.BalanceHandler;
import strategy.handler.Handler;
import strategy.handler.PurchaseHandler;
import strategy.handler.ReturnHandler;
import strategy.handler.SupplyHandler;

public class Main {
    private static final Map<FruitTransaction.Operation, Handler> transactionHandlerMap = Map.of(
            FruitTransaction.Operation.BALANCE, new BalanceHandler(),
            FruitTransaction.Operation.SUPPLY, new SupplyHandler(),
            FruitTransaction.Operation.PURCHASE, new PurchaseHandler(),
            FruitTransaction.Operation.RETURN, new ReturnHandler());

    public static void main(String[] args) {
        ReaderService reader = new ReaderServiceCsvImpl();
        List<String> inputData = reader.readFromFile("src/main/resources/input.csv");
        Parser parser = new ParserImpl();
        List<FruitTransaction> transactionList = parser.parse(inputData);
        for (FruitTransaction transaction : transactionList) {
            Handler currentHandler = transactionHandlerMap.get(transaction.getOperation());
            currentHandler.fruitOperation(transaction.getFruit(), transaction.getQuantity());
        }
        CreateReport report = new CreateReportImpl();
        List<String> result = report.createReport();
        WriterService writer = new WriterServiceCsvImpl();
        writer.writeToFile(result);
    }

}
