package core.basesyntax;

import database.StorageDealer;
import database.StorageDealerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.DataConverter;
import service.InputFileHandler;
import service.ReportGenerator;
import service.ReportWriter;
import service.ShopService;
import service.impl.DataConverterImpl;
import service.impl.InputHandler;
import service.impl.ReportGeneratorImpl;
import service.impl.ReportWriterImpl;
import service.impl.ShopServiceImpl;
import strategy.BalanceOperation;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;
import strategy.PurchaseOperation;
import strategy.ReturnOperation;
import strategy.SupplyOperation;

public class Application {
    public static void main(String[] args) {
        InputFileHandler inputHandler = new InputHandler();
        List<String> input = inputHandler.readFile("src/main/resources/input.csv");

        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> fruitTransactionList =
                dataConverter.convertToTransaction(input);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy =
                new OperationStrategyImpl(operationHandlers);

        StorageDealer storageDealer = new StorageDealerImpl();
        ShopService shopService = new ShopServiceImpl(
                operationStrategy, storageDealer);
        shopService.process(fruitTransactionList);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.getReport();

        ReportWriter reportWriter = new ReportWriterImpl();
        reportWriter.writeReport(report, "src/main/resources/finalReport.csv");
    }
}
