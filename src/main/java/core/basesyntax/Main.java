package core.basesyntax;

import core.basesyntax.fruitentry.FruitEntryService;
import core.basesyntax.fruitentry.impl.FruitEntryRepositoryInMemoryImpl;
import core.basesyntax.fruitentrytransaction.FruitEntryTransaction;
import core.basesyntax.fruitentrytransaction.OperationStrategy;
import core.basesyntax.fruitentrytransaction.operation.BalanceOperationHandler;
import core.basesyntax.fruitentrytransaction.operation.OperationHandler;
import core.basesyntax.fruitentrytransaction.operation.PurchaseOperationHandler;
import core.basesyntax.fruitentrytransaction.operation.ReturnOperationHandler;
import core.basesyntax.fruitentrytransaction.operation.SupplyOperationHandler;
import core.basesyntax.mapper.csv.FruitEntryTransactionCsvMapper;
import core.basesyntax.report.CsvFruitReportGenerator;
import core.basesyntax.report.FileReportGenerator;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final String csvSeparator = ",";
        final Path transactionsFilePath = Path.of("src", "main", "resources", "transactions1.csv");
        final Path reportFilePath = Path.of("src", "main", "resources", "report1.csv");

        FruitEntryTransactionCsvMapper csvMapper = new FruitEntryTransactionCsvMapper(csvSeparator);
        OperationStrategy operationStrategy = new OperationStrategy(createStrategyMap());
        FruitEntryService fruitEntryService = new FruitEntryService(
                new FruitEntryRepositoryInMemoryImpl(),
                operationStrategy);
        FileReportGenerator reportGenerator = new CsvFruitReportGenerator(
                fruitEntryService,
                csvSeparator);

        List<FruitEntryTransaction> transactions = csvMapper.mapFromCsvFile(transactionsFilePath);
        fruitEntryService.applyAllTransactions(transactions);
        reportGenerator.generateFileReport(reportFilePath);
    }

    private static Map<FruitEntryTransaction.Operation, OperationHandler> createStrategyMap() {
        return Map.of(
                FruitEntryTransaction.Operation.BALANCE, new BalanceOperationHandler(),
                FruitEntryTransaction.Operation.PURCHASE, new PurchaseOperationHandler(),
                FruitEntryTransaction.Operation.SUPPLY, new SupplyOperationHandler(),
                FruitEntryTransaction.Operation.RETURN, new ReturnOperationHandler()
        );
    }
}
