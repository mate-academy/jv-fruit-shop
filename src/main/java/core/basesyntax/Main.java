package core.basesyntax;

import core.basesyntax.dao.FileReader;
import core.basesyntax.dao.FileReaderImpl;
import core.basesyntax.dao.FileWriter;
import core.basesyntax.dao.FileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.BalanceOperation;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.PurchaseOperation;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ReturnOperation;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.SupplyOperation;
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
        // 3. Create and feel the map with all OperationHandler implementations
        Map<String, Integer> fruitStorage = new HashMap<>();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = Map
                .of(FruitTransaction.Operation.BALANCE, new BalanceOperation(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperation(),
                FruitTransaction.Operation.RETURN, new ReturnOperation(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);
        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.buildReport();
        // 6. Write the received report into the destination file
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "reportToWrite.csv");
    }
}
