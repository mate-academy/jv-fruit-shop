package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalanceOperation;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseOperation;
import core.basesyntax.operation.ReturnOperation;
import core.basesyntax.operation.SupplyOperation;
import core.basesyntax.service.impl.FileReader;
import core.basesyntax.service.impl.FileWriter;
import core.basesyntax.service.impl.OperationStrategy;
import core.basesyntax.service.impl.ReportGenerator;
import core.basesyntax.service.impl.ShopService;
import core.basesyntax.service.impl.TransactionConverter;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/reportToRead.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        // 1. Read the data from the input CSV file
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(INPUT_FILE);

        // 2. Convert the incoming data into FruitTransactions list
        TransactionConverter transactionConverter = new TransactionConverterImpl();
        final List<FruitTransaction> transactions = transactionConverter
                .convertToTransaction(inputReport);

        // 3. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperation(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperation(),
                FruitTransaction.Operation.RETURN, new ReturnOperation(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperation()
        );
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport(Storage.getInventory());

        // 6. Write the received report into the destination file
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, OUTPUT_FILE_NAME);
    }
}
