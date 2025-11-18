package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.DataConverter;
import service.ReaderService;
import service.ReportGenerator;
import service.ShopService;
import service.WriterService;
import service.impl.DataConverterImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportGeneratorImpl;
import service.impl.ShopServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.impl.BalanceOperation;
import strategy.impl.OperationStrategyImpl;
import strategy.impl.PurchaseOperation;
import strategy.impl.ReturnOperation;
import strategy.impl.SupplyOperation;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String READ_FROM_PATH = "src/main/resources/transactions.csv";
    private static final String WRITE_TO_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReaderService reader = new ReaderServiceImpl();
        List<String> transactionsList = reader.readFromFile(READ_FROM_PATH);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        DataConverter converter = new DataConverterImpl();
        List<FruitTransaction> transactions = converter.convertToTransaction(transactionsList);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.getReport();

        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(WRITE_TO_PATH, report);
    }
}
