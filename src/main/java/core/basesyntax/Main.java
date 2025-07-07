package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.datemanipulation.DataConverter;
import core.basesyntax.datemanipulation.DataConverterImpl;
import core.basesyntax.datemanipulation.FruitTransaction;
import core.basesyntax.readfile.FileReader;
import core.basesyntax.readfile.FileReaderImpl;
import core.basesyntax.report.ReportGenerator;
import core.basesyntax.report.ReportGeneratorImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.operation.BalanceOperation;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperation;
import core.basesyntax.service.operation.ReturnOperation;
import core.basesyntax.service.operation.SupplyOperation;
import core.basesyntax.writefile.FileWriter;
import core.basesyntax.writefile.FileWriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String INPUT_FILE_NAME = "src/main/reportToRead.csv";
    private static final String OUTPUT_FILE_NAME = "finalReport.csv";

    public static void main(String[] arg) {

        // 3. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());

        // 1. Read the data from the input CSV file
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(INPUT_FILE_NAME);

        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        FruitDao fruitDao = new FruitDaoImpl();
        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(fruitDao, operationStrategy);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        // 6. Write the received report into the destination file
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, OUTPUT_FILE_NAME);
    }
}

