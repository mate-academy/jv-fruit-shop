package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.WriterService;
import core.basesyntax.serviceimpl.CsvToFruitTransactionConverter;
import core.basesyntax.serviceimpl.ReaderServiceImpl;
import core.basesyntax.serviceimpl.ReportGeneratorImpl;
import core.basesyntax.serviceimpl.ShopServiceImpl;
import core.basesyntax.serviceimpl.WriterServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HelloWorld {
    private static final String INPUT_FULL_PATH = "src/main/java/resources/input.csv";
    private static final String OUTPUT_FULL_PATH = "src/main/java/resources/output.csv";

    public static void main(String[] arg) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> inputReport = readerService.readFromFile(INPUT_FULL_PATH);

        DataConverter<List<String>,
                List<FruitTransaction>> dataConverter = new CsvToFruitTransactionConverter();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        Map<FruitTransaction.Operation,
                OperationHandler> operationHandlers = Map
                .of(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
                        FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(),
                        FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(),
                        FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator<List<String>> reportGenerator = new ReportGeneratorImpl();
        Set<String> resultingReport = reportGenerator.getReport();

        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(OUTPUT_FULL_PATH, resultingReport);
    }
}
