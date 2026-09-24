package core.basesyntax;

import core.basesyntax.dataconverter.DataConverter;
import core.basesyntax.dataconverter.DataConverterImpl;
import core.basesyntax.filereader.FileReader;
import core.basesyntax.filereader.FileReaderImpl;
import core.basesyntax.filewriter.FileWriter;
import core.basesyntax.filewriter.FileWriterImpl;
import core.basesyntax.fruittransaction.FruitTransaction;
import core.basesyntax.fruittransaction.Operation;
import core.basesyntax.handlers.BalanceOperation;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.handlers.PurchaseOperation;
import core.basesyntax.handlers.ReturnOperation;
import core.basesyntax.handlers.SupplyOperation;
import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.operationstrategy.OperationStrategyImpl;
import core.basesyntax.reportgenerator.ReportGenerator;
import core.basesyntax.shopservice.ShopService;
import core.basesyntax.shopservice.ShopServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] arg) {
        // 1. Read the data from the input CSV file
        final FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.readFromFile("reportToRead.csv");

        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertFromStrings(inputReport);

        // 3. Create and feel the map with all OperationHandler implementations
        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(Operation.RETURN, new ReturnOperation());
        operationHandlers.put(Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        // 4. Process the incoming transactions with applicable OperationHandler implementations

        final ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = shopService.getRaportGenerator();
        String resultingReport = reportGenerator.getReport();

        // 6. Write the received report into the destination file
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(resultingReport, "finalReport.csv");
    }
}
