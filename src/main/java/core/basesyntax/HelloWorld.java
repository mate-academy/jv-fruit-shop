package core.basesyntax;

import core.basesyntax.dataservice.DataConverter;
import core.basesyntax.dataservice.DataConverterImpl;
import core.basesyntax.dataservice.ShopService;
import core.basesyntax.dataservice.ShopServiceImpl;
import core.basesyntax.fileservice.FileReader;
import core.basesyntax.fileservice.FileReaderImpl;
import core.basesyntax.fileservice.FileWriter;
import core.basesyntax.fileservice.FileWriterImpl;
import core.basesyntax.reportservice.ReportGenerator;
import core.basesyntax.reportservice.ReportGeneratorImpl;
import core.basesyntax.transactions.BalanceOperation;
import core.basesyntax.transactions.FruitTransaction;
import core.basesyntax.transactions.OperationHandler;
import core.basesyntax.transactions.OperationStrategy;
import core.basesyntax.transactions.OperationStrategyImpl;
import core.basesyntax.transactions.PurchaseOperation;
import core.basesyntax.transactions.ReturnOperation;
import core.basesyntax.transactions.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    // HINT: In the `public static void main(String[] args)`
    // it is better to create instances of your classes,
    // and call their methods, but do not write any business logic in the `main` method!
    public static void main(String[] args) {

        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.readFile("reportToRead.csv");

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeFile(resultingReport, "finalReport.csv");
    }
}
