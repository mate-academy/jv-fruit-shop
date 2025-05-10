package core.basesyntax;

import core.basesyntax.dataconverter.DataConverter;
import core.basesyntax.dataconverter.DataConverterImpl;
import core.basesyntax.filereader.CsvFileReader;
import core.basesyntax.filereader.CsvFileReaderImpl;
import core.basesyntax.filewriter.CsvFileWriter;
import core.basesyntax.filewriter.CsvFileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalanceOperation;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.OperationStrategy;
import core.basesyntax.operation.OperationStrategyImpl;
import core.basesyntax.operation.PurchaseOperation;
import core.basesyntax.operation.ReturnOperation;
import core.basesyntax.operation.SupplyOperation;
import core.basesyntax.reportgenerator.ReportGenerator;
import core.basesyntax.reportgenerator.ReportGeneratorImpl;
import core.basesyntax.shopservice.ShopService;
import core.basesyntax.shopservice.ShopServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] arg) {
        // 1. Read the data from the input CSV file
        CsvFileReader fileReader = new CsvFileReaderImpl();
        List<String> inputReport = fileReader.read(FileConstants.INPUT_FILE);

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
        ReportGenerator reportGenerator = new ReportGeneratorImpl(shopService);
        String resultingReport = reportGenerator.getReport();

        // 6. Write the received report into the destination file
        CsvFileWriter fileWriter = new CsvFileWriterImpl();
        fileWriter.write(resultingReport, FileConstants.OUTPUT_FILE);
    }
}
