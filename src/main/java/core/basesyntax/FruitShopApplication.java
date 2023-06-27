package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.LocalStorageFruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DefaultFileService;
import core.basesyntax.service.FileService;
import core.basesyntax.service.report.ReportService;
import core.basesyntax.service.report.impl.CsvReportService;
import core.basesyntax.service.transaction.FruitTransactionParsingService;
import core.basesyntax.service.transaction.FruitTransactionService;
import core.basesyntax.service.transaction.FruitTransactionValidator;
import core.basesyntax.service.transaction.impl.CsvFruitTransactionParsingService;
import core.basesyntax.service.transaction.impl.DefaultFruitTransactionService;
import core.basesyntax.service.transaction.impl.DefaultFruitTransactionValidator;
import core.basesyntax.strategy.FruitTransactionOperationHandler;
import core.basesyntax.strategy.FruitTransactionOperationStrategy;
import core.basesyntax.strategy.impl.BalanceFruitTransactionOperationHandler;
import core.basesyntax.strategy.impl.DefaultFruitTransactionOperationStrategy;
import core.basesyntax.strategy.impl.PurchaseFruitTransactionOperationHandler;
import core.basesyntax.strategy.impl.ReturnFruitTransactionOperationHandler;
import core.basesyntax.strategy.impl.SupplyFruitTransactionOperationHandler;
import java.util.List;
import java.util.Map;

public class FruitShopApplication {
    private static final String INPUT_FILEPATH = "src/main/resources/input.csv";
    private static final String REPORT_FILEPATH = "src/main/resources/report.csv";

    private static final Map<FruitTransaction.Operation, FruitTransactionOperationHandler>
            HANDLER_MAP =
            Map.of(
                    FruitTransaction.Operation.BALANCE,
                    new BalanceFruitTransactionOperationHandler(),

                    FruitTransaction.Operation.SUPPLY,
                    new SupplyFruitTransactionOperationHandler(),

                    FruitTransaction.Operation.PURCHASE,
                    new PurchaseFruitTransactionOperationHandler(),

                    FruitTransaction.Operation.RETURN,
                    new ReturnFruitTransactionOperationHandler()
            );

    public static void main(String[] args) {
        // 1. Read input data from file
        FileService fileService = new DefaultFileService();
        String input = fileService.readFile(INPUT_FILEPATH);

        // 2. Parse input data
        FruitTransactionParsingService ftParsingService = new CsvFruitTransactionParsingService();
        List<FruitTransaction> fruitTransactions = ftParsingService.parse(input);

        // 3. Process parsed transactions
        FruitTransactionValidator ftValidator = new DefaultFruitTransactionValidator();
        FruitTransactionOperationStrategy ftOperationStrategy =
                new DefaultFruitTransactionOperationStrategy(HANDLER_MAP);
        FruitDao fruitDao = new LocalStorageFruitDao();
        FruitTransactionService ftService =
                new DefaultFruitTransactionService(ftValidator, ftOperationStrategy, fruitDao);
        ftService.processTransactions(fruitTransactions);

        // 4. Generate report
        ReportService reportService = new CsvReportService(fruitDao);
        String report = reportService.generateReport();

        // 5. Write report to a file
        fileService.writeDataToFile(REPORT_FILEPATH, report);
    }
}
