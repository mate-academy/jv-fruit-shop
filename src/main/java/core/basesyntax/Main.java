package core.basesyntax;

import core.basesyntax.model.FruitTransactionImpl;
import core.basesyntax.operationhandlers.BalanceOperationHandler;
import core.basesyntax.operationhandlers.OperationHandler;
import core.basesyntax.operationhandlers.PurchaseOperationHandler;
import core.basesyntax.operationhandlers.ReturnOperationHandler;
import core.basesyntax.operationhandlers.SupplyOperationHandler;
import core.basesyntax.service.CustomFileReader;
import core.basesyntax.service.CustomFileWriter;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] arg) {
        // 1. Read the data from the input CSV file
        String filePathInputFile = "src/main/resources/reportToRead.csv";
        CustomFileReader fileReader = new FileReaderImpl(filePathInputFile);
        List<String> inputReport = fileReader.read();

        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransactionImpl> transactions = dataConverter
                .convertToTransaction(inputReport);

        // 3. Create and feel the map with all OperationHandler implementations
        Map<FruitTransactionImpl.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransactionImpl.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlers.put(FruitTransactionImpl.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlers.put(FruitTransactionImpl.Operation.RETURN,
                new ReturnOperationHandler());
        operationHandlers.put(FruitTransactionImpl.Operation.SUPPLY,
                new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        // 6. Write the received report into the destination file
        String filePathOutputFile = "src/main/resources/finalReport.csv";
        CustomFileWriter fileWriter = new FileWriterImpl(filePathOutputFile);
        fileWriter.write(resultingReport);
    }
}
