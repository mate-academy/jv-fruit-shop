package core;

import core.basesyntax.file.DataConverter;
import core.basesyntax.file.DataConverterImpl;
import core.basesyntax.file.ReadFromFile;
import core.basesyntax.file.ReadFromFileImpl;
import core.basesyntax.file.ReportGenerator;
import core.basesyntax.file.ReportGeneratorImpl;
import core.basesyntax.file.ReportWriter;
import core.basesyntax.file.ReportWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.operations.BalanceOperationHandler;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.operations.PurchaseOperationHandler;
import core.basesyntax.operations.ReturnOperationHandler;
import core.basesyntax.operations.SupplyOperationHandler;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String inputFilePath = "src\\main\\resources\\inputValue.csv";
    private static final String outputFilePath = "finalReport.csv";

    public static void main(String[] args) {

        // 1. Read the data from the input CSV file
        ReadFromFile fileReader = new ReadFromFileImpl();
        List<String> inputReport = fileReader.read(inputFilePath);

        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions =
                dataConverter.convertToTransactions(inputReport);

        // 3. Create and feel the map with all OperationHandler implementations
        ShopService shopService = getShopService();
        shopService.process(transactions);

        // 5. Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        // 6. Write the received report into the destination file/
        ReportWriter fileWriter = new ReportWriterImpl();
        fileWriter.write(resultingReport, outputFilePath);
    }

    private static ShopService getShopService() {
        Map<Operation, OperationHandler> operationHandlers = Map.of(
                Operation.BALANCE, new BalanceOperationHandler(),
                Operation.PURCHASE, new PurchaseOperationHandler(),
                Operation.RETURN, new ReturnOperationHandler(),
                Operation.SUPPLY, new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        return new ShopServiceImpl(operationStrategy);
    }
}
