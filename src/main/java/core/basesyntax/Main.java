package core.basesyntax;

import core.basesyntax.converter.DataConverter;
import core.basesyntax.converter.DataConverterImpl;
import core.basesyntax.dao.FileReader;
import core.basesyntax.dao.FileReaderImpl;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.OperationStrategy;
import core.basesyntax.handler.OperationStrategyImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.BalanceOperation;
import core.basesyntax.operations.PurchaseOperation;
import core.basesyntax.operations.ReturnOperation;
import core.basesyntax.operations.SupplyOperation;
import core.basesyntax.generator.ReportGenerator;
import core.basesyntax.generator.ReportGeneratorImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.writer.FileWriterService;
import core.basesyntax.writer.FileWriterServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] arg) {
        // 1. Read the data from the input CSV file
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.readFromFile("src/main/resources/reportToRead.csv");

        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        // 3. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        // 6. Write the received report into the destination file
        FileWriterService fileWriter = new FileWriterServiceImpl();
        fileWriter.write(resultingReport, "src/main/resources/finalReport.csv");
    }
}
