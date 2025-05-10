package core.basesyntax;

import core.basesyntax.converter.DataConverter;
import core.basesyntax.converter.DataConverterImpl;
import core.basesyntax.file.CustomFileReader;
import core.basesyntax.file.CustomFileReaderImpl;
import core.basesyntax.file.CustomFileWriter;
import core.basesyntax.file.CustomFileWriterImpl;
import core.basesyntax.operation.handler.BalanceOperation;
import core.basesyntax.operation.handler.OperationHandler;
import core.basesyntax.operation.handler.PurchaseOperation;
import core.basesyntax.operation.handler.ReturnOperation;
import core.basesyntax.operation.handler.SupplyOperation;
import core.basesyntax.operation.operationstrategy.OperationStrategy;
import core.basesyntax.operation.operationstrategy.OperationStrategyImpl;
import core.basesyntax.reportgenerator.ReportGenerator;
import core.basesyntax.reportgenerator.ReportGeneratorImpl;
import core.basesyntax.shopservice.ShopService;
import core.basesyntax.shopservice.ShopServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_TO_READ = "src/main/resources/reportToRead.csv";
    private static final String FILE_TO_WRITE = "src/main/resources/finalReport.csv";

    public static void main(String[] arg) {
        // 1. Read the data from the input CSV file
        CustomFileReader fileReader = new CustomFileReaderImpl();
        List<String> inputReport = fileReader.read(FILE_TO_READ);

        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

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
        CustomFileWriter fileWriter = new CustomFileWriterImpl();
        fileWriter.write(resultingReport, FILE_TO_WRITE);
    }
}
