package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import core.basesyntax.service.parser.ParserService;
import core.basesyntax.service.parser.ParserServiceImpl;
import core.basesyntax.service.reader.ReaderService;
import core.basesyntax.service.reader.ReaderServiceImpl;
import core.basesyntax.service.report.GenerateReport;
import core.basesyntax.service.report.GenerateReportImpl;
import core.basesyntax.service.writer.WriterService;
import core.basesyntax.service.writer.WriterServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_INPUT = "src/main/resources/input.csv";
    private static final String FILE_REPORT = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        ParserService parserService = new ParserServiceImpl();

        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler());

        List<FruitTransaction> transactionList =
                parserService.parserData(readerService.readFromFile(FILE_INPUT));

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.getOperation(transactionList);

        GenerateReport report = new GenerateReportImpl();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(report.generateReport(Storage.storageFruit), FILE_REPORT);
    }
}
