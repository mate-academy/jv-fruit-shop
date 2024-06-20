package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.serviceimpl.DataConverterImpl;
import core.basesyntax.service.serviceimpl.FileReaderImpl;
import core.basesyntax.service.serviceimpl.FileWriterImpl;
import core.basesyntax.service.serviceimpl.ReportGeneratorImpl;
import core.basesyntax.service.serviceimpl.ShopServiceImpl;
import core.basesyntax.stategy.OperationStrategy;
import core.basesyntax.stategy.OperationStrategyImpl;
import core.basesyntax.stategy.handler.BalanceOperation;
import core.basesyntax.stategy.handler.OperationHandler;
import core.basesyntax.stategy.handler.PurchaseOperation;
import core.basesyntax.stategy.handler.ReturnOperation;
import core.basesyntax.stategy.handler.SupplyOperation;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String REPORT_TO_READ
            = "src/main/resources/files/reportToRead.csv";
    public static final String REPORT_TO_WRITE
            = "src/main/resources/files/reportToWrite.csv";

    public static void main(String[] arg) {
        // 1. Read the data from the input CSV file
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(new File(REPORT_TO_READ));

        // 3. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        // 6. Write the received report into the destination file
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, new File(REPORT_TO_WRITE));
        System.out.println(resultingReport);
    }
}
