package core.basesyntax;

import handler.BalanceHandler;
import handler.PurchaseHandler;
import handler.ReturnHandler;
import handler.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitShopService;
import service.ParserService;
import service.ReaderService;
import service.WriterService;
import service.impl.CreateReportService;
import service.impl.FruitShopServiceImpl;
import service.impl.OperationStrategyImpl;
import service.impl.ParserServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.OperationStrategy;
import strategy.TransactionHandler;

public class Main {
    private static final String INPUT_DATA = "src/main/java/resources/input.csv";
    private static final String OUTPUT_DATA = "src/main/java/resources/output.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, TransactionHandler> transactionHandlerMap = new HashMap<>();
        transactionHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        transactionHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        transactionHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        transactionHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(transactionHandlerMap);

        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromFile = readerService.read(INPUT_DATA);

        ParserService parserService = new ParserServiceImpl();
        List<FruitTransaction> parseData = parserService.parse(dataFromFile);

        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        fruitShopService.calculate(parseData);

        CreateReportService createReportService = new CreateReportService();
        String report = createReportService.report();

        WriterService writerService = new WriterServiceImpl();
        writerService.write(report, OUTPUT_DATA);
    }
}
