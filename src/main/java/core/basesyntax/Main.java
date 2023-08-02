package core.basesyntax;

import core.basesyntax.service.DataFileParser;
import core.basesyntax.service.FruitReportService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.DataFileParserImpl;
import core.basesyntax.service.impl.FruitReportServiceImpl;
import core.basesyntax.service.impl.FruitTransaction;
import core.basesyntax.service.impl.ReaderServiceCsvImpl;
import core.basesyntax.service.impl.WriterServiceCsvImpl;
import core.basesyntax.strategy.handler.BalanceOperationHandler;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.PurchaseOperationHandler;
import core.basesyntax.strategy.handler.ReturnOperationHandler;
import core.basesyntax.strategy.handler.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<FruitTransaction.Operation, OperationHandler> handlerMap = Map.of(
            FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
            FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(),
            FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(),
            FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

    public static void main(String[] args) {
        ReaderService reader = new ReaderServiceCsvImpl();
        List<String> inputData = reader.readFromFile("src/main/resources/input.csv");
        DataFileParser dataFileParser = new DataFileParserImpl();
        List<FruitTransaction> transactionList = dataFileParser.parse(inputData);
        for (FruitTransaction transaction : transactionList) {
            OperationHandler currentOperationHandler = handlerMap.get(transaction.getOperation());
            currentOperationHandler.handle(transaction.getFruit(), transaction.getQuantity());
        }
        FruitReportService report = new FruitReportServiceImpl();
        List<String> result = report.createReport();
        WriterService writer = new WriterServiceCsvImpl();
        writer.writeToFile(result, "src/main/resources/report.csv");
    }

}
