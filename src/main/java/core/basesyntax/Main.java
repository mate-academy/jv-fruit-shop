package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.StockService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvReaderServiceImpl;
import core.basesyntax.service.impl.CsvWriterServiceImpl;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.StockServiceImpl;
import core.basesyntax.strategy.ActivityHandler;
import core.basesyntax.strategy.ActivityStrategy;
import core.basesyntax.strategy.impl.ActivityStrategyImpl;
import core.basesyntax.strategy.impl.BalanceActivity;
import core.basesyntax.strategy.impl.PurchaseActivity;
import core.basesyntax.strategy.impl.ReturnActivity;
import core.basesyntax.strategy.impl.SupplyActivity;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String SOURCE = "src/main/resources/input.csv";
    private static final String TARGET = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, ActivityHandler> operationMap =
                Map.of(FruitTransaction.Operation.BALANCE, new BalanceActivity(),
                        FruitTransaction.Operation.PURCHASE, new PurchaseActivity(),
                        FruitTransaction.Operation.SUPPLY, new SupplyActivity(),
                        FruitTransaction.Operation.RETURN, new ReturnActivity());

        ReaderService readerService = new CsvReaderServiceImpl();
        List<String> rawData = readerService.readFromFile(SOURCE);

        ParseService parseService = new ParseServiceImpl();
        List<FruitTransaction> fruitTransactions = parseService.parseRawData(rawData);

        ActivityStrategy activityStrategy = new ActivityStrategyImpl(operationMap);
        StockService service = new StockServiceImpl(activityStrategy);
        service.calculateStock(fruitTransactions);

        ReportService storeReport = new ReportServiceImpl();
        String report = storeReport.create();

        WriterService writerService = new CsvWriterServiceImpl();
        writerService.write(TARGET, report);
    }
}
