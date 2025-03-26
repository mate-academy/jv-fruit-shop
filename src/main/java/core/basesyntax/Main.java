package core.basesyntax;

import core.basesyntax.dao.DataConverter;
import core.basesyntax.dao.DataConverterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.report.FileReader;
import core.basesyntax.report.FileReaderImpl;
import core.basesyntax.report.FileWriter;
import core.basesyntax.report.FileWriterImpl;
import core.basesyntax.report.ReportGenerator;
import core.basesyntax.report.ReportGeneratorImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Path FILE_READ = Path.of("src/main/resources/reportToRead.csv");
    private static final Path FILE_WRITE = Path.of("src/main/resources/reportFinal.csv");

    public static void main(String[] args) {
        // 1. Read the data from the input CSV file
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(String.valueOf(FILE_READ));

        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();

        // 3. Create and feel the map with all OperationHandler implementations
        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlers.put(Operation.RETURN, new ReturnOperationHandler());
        operationHandlers.put(Operation.SUPPLY, new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopServiceImpl shopService = new ShopServiceImpl(operationStrategy);
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport(shopService.getFruitStorage()
                .getFruits());

        // 6. Write the received report into the destination file
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, String.valueOf(FILE_WRITE));
    }
}
