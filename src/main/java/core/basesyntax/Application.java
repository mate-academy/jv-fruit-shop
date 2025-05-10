package core.basesyntax;

import database.StorageDealer;
import database.StorageDealerImpl;
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
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        InputFileHandler inputHandler = new InputHandler();
        List<String> input = inputHandler.readFile(INPUT_FILE_PATH);

        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> fruitTransactionList =
                dataConverter.convertToTransaction(input);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperation(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperation(),
                FruitTransaction.Operation.RETURN, new ReturnOperation(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperation());

        OperationStrategy operationStrategy =
                new OperationStrategyImpl(operationHandlers);

        StorageDealer storageDealer = new StorageDealerImpl();
        ShopService shopService = new ShopServiceImpl(
                operationStrategy, storageDealer);
        shopService.process(fruitTransactionList);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.getReport();

        ReportWriter reportWriter = new ReportWriterImpl();
        reportWriter.writeReport(report, OUTPUT_FILE_PATH);
    }
}
