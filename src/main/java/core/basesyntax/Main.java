package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CreatReportService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CreatReportServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_DATA_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_DATA_PATH = "src/main/resources/output.csv";
    private static final String BALANCE = "b";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";
    private static final String SUPPLY = "s";

    public static void main(String[] args) {
        Map<String, OperationHandler> map = new HashMap<>();
        map.put(BALANCE, new BalanceOperationHandler());
        map.put(PURCHASE, new PurchaseOperationHandler());
        map.put(RETURN, new ReturnOperationHandler());
        map.put(SUPPLY, new SupplyOperationHandler());

        OperationStrategy strategy = new OperationStrategy(map);

        ReaderService readerService = new ReaderServiceImpl();
        List<String> info = readerService.readFromFile(INPUT_DATA_PATH);

        ParserService parserService = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactions = parserService.parse(info);

        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler = strategy.getByOperation(
                    fruitTransaction.getOperation());
            operationHandler.apply(fruitTransaction);
        }

        WriterService writerService = new WriterServiceImpl();
        CreatReportService creatReportService = new CreatReportServiceImpl();
        writerService.writeToFile(OUTPUT_DATA_PATH, creatReportService.createReport());
    }
}
