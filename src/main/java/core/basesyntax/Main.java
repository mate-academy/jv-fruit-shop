package core.basesyntax;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.DataConverter;
import core.basesyntax.services.DataConverterImp;
import core.basesyntax.services.ReadService;
import core.basesyntax.services.ReadServiceImp;
import core.basesyntax.services.ReportGenerator;
import core.basesyntax.services.ReportGeneratorImp;
import core.basesyntax.services.StorageService;
import core.basesyntax.services.StorageServiceImp;
import core.basesyntax.services.WriteService;
import core.basesyntax.services.WriteServiceImp;
import core.basesyntax.services.operations.BalanceOperation;
import core.basesyntax.services.operations.PurchaseOperation;
import core.basesyntax.services.operations.ReturnOperation;
import core.basesyntax.services.operations.SupplyOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/java/core/basesyntax"
            + "/resources/reportToRead.csv";
    private static final String OUTPUT_FILE = "src/main/java/core/basesyntax"
            + "/resources/finalReport.csv";

    public static void main(String[] args) {
        ReadService readService = new ReadServiceImp();
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

        OperationStrategyImpl operationStrategy = new OperationStrategyImpl(operationHandlers);
        ReportGenerator reportGenerator = new ReportGeneratorImp(storageService);
        WriteService writeService = new WriteServiceImp();

        List<String> fileData = readService.read(INPUT_FILE);
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(fileData);
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.apply(transaction);
        }
        List<String> report = reportGenerator.generateReport();
        writeService.write(OUTPUT_FILE, report);
    }
}
