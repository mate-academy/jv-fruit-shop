package core.basesyntax;

import core.basesyntax.convertdatatoobject.DataConverter;
import core.basesyntax.convertdatatoobject.DataConverterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationHandling.OperationStrategy;
import core.basesyntax.operationHandling.OperationStrategyImpl;
import core.basesyntax.operationHandling.operation.BalanceOperation;
import core.basesyntax.operationHandling.operation.OperationHandler;
import core.basesyntax.operationHandling.operation.PurchaseOperation;
import core.basesyntax.operationHandling.operation.ReturnOperation;
import core.basesyntax.operationHandling.operation.SupplyOperation;
import core.basesyntax.readfromfile.FileReader;
import core.basesyntax.readfromfile.FileReaderImpl;
import core.basesyntax.reportGenerator.ReportGenerator;
import core.basesyntax.reportGenerator.ReportGeneratorImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.writefinalreport.FileWriter;
import core.basesyntax.writefinalreport.FileWriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] arg) {
        // 1. Read the data from the input CSV file
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("reportToRead.csv");

        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        // 3. Create and fill the map with all OperationHandler implementations
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
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");
    }
}
