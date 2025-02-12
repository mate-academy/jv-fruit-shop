package core.basesyntax;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.DataConverter;
import core.basesyntax.services.DataConverterImp;
import core.basesyntax.services.OperationHandler;
import core.basesyntax.services.ReaderService;
import core.basesyntax.services.ReaderServiceImp;
import core.basesyntax.services.ReportGenerator;
import core.basesyntax.services.ReportGeneratorImp;
import core.basesyntax.services.StorageService;
import core.basesyntax.services.StorageServiceImp;
import core.basesyntax.services.TransactionProcessor;
import core.basesyntax.services.WriterService;
import core.basesyntax.services.WriterServiceImp;
import core.basesyntax.services.operations.BalanceOperation;
import core.basesyntax.services.operations.PurchaseOperation;
import core.basesyntax.services.operations.ReturnOperation;
import core.basesyntax.services.operations.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/reportToRead.csv";
    private static final String OUTPUT_FILE = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        try {
            ReaderService readService = new ReaderServiceImp();
            DataConverter dataConverter = new DataConverterImp();
            StorageService storageService = new StorageServiceImp();

            Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
            operationHandlers.put(FruitTransaction.Operation.BALANCE,
                    new BalanceOperation(storageService));
            operationHandlers.put(FruitTransaction.Operation.SUPPLY,
                    new SupplyOperation(storageService));
            operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                    new PurchaseOperation(storageService));
            operationHandlers.put(FruitTransaction.Operation.RETURN,
                    new ReturnOperation(storageService));

            TransactionProcessor transactionProcessor = new TransactionProcessor(operationHandlers);
            ReportGenerator reportGenerator = new ReportGeneratorImp(storageService);
            WriterService writeService = new WriterServiceImp();

            List<String> fileData = readService.read(INPUT_FILE);
            List<FruitTransaction> transactions = dataConverter.convertToTransaction(fileData);
            transactionProcessor.processTransactions(transactions);

            String report = reportGenerator.generateReport();
            writeService.write(OUTPUT_FILE, report);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
