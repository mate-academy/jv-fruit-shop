package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.converter.DataConverter;
import core.basesyntax.service.converter.DataConverterImpl;
import core.basesyntax.service.handler.BalanceOperation;
import core.basesyntax.service.handler.OperationHandler;
import core.basesyntax.service.handler.PurchaseOperation;
import core.basesyntax.service.handler.ReturnOperation;
import core.basesyntax.service.handler.SupplyOperation;
import core.basesyntax.service.report.ReportGenerator;
import core.basesyntax.service.report.ReportGeneratorImpl;
import core.basesyntax.service.shop.ProductService;
import core.basesyntax.service.shop.ProductServiceImpl;
import core.basesyntax.service.shop.ShopService;
import core.basesyntax.service.shop.ShopServiceImpl;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import core.basesyntax.storage.Storage;
import core.basesyntax.util.filereader.FileReader;
import core.basesyntax.util.filereader.FileReaderImpl;
import core.basesyntax.util.filewriter.CustomFileWriter;
import core.basesyntax.util.filewriter.CustomFileWriterImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopApp {
    private static final String INPUT_DATA_FILE = "reportToRead.csv";
    private static final String REPORT_FILE = "finalReport.csv";

    public static void main(String[] arg) {
        // 1. Read the data from the input CSV file
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(INPUT_DATA_FILE);

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
        Storage storage = new Storage();
        ProductService productService = new ProductServiceImpl(storage);
        productService.fillProducts(transactions);
        ShopService shopService = new ShopServiceImpl(operationStrategy, storage);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport(storage.getFruits());

        // 6. Write the received report into the destination file
        CustomFileWriter customFileWriter = new CustomFileWriterImpl();
        customFileWriter.write(resultingReport, REPORT_FILE);
    }
}
