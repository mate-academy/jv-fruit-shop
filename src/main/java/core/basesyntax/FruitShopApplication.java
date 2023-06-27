package core.basesyntax;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.impl.LocalStorageFruitTransactionDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransactionReport;
import core.basesyntax.service.FruitTransactionParsingService;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.FruitTransactionValidator;
import core.basesyntax.service.ftoperation.FruitTransactionOperationHandler;
import core.basesyntax.service.ftoperation.FruitTransactionOperationStrategy;
import core.basesyntax.service.ftoperation.impl.BalanceFruitTransactionOperationHandler;
import core.basesyntax.service.ftoperation.impl.DefaultFruitTransactionOperationStrategy;
import core.basesyntax.service.ftoperation.impl.PurchaseFruitTransactionOperationHandler;
import core.basesyntax.service.ftoperation.impl.ReturnFruitTransactionOperationHandler;
import core.basesyntax.service.ftoperation.impl.SupplyFruitTransactionOperationHandler;
import core.basesyntax.service.impl.CsvFruitTransactionParsingService;
import core.basesyntax.service.impl.DefaultFruitTransactionService;
import core.basesyntax.service.impl.DefaultFruitTransactionValidator;
import core.basesyntax.util.FileUtils;
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
        String input = FileUtils.readFile(INPUT_FILEPATH);

        // 2. Parse input data
        FruitTransactionParsingService ftParsingService = new CsvFruitTransactionParsingService();
        List<FruitTransaction> fruitTransactions = ftParsingService.parse(input);

        // 3. Process parsed data
        FruitTransactionValidator ftValidator = new DefaultFruitTransactionValidator();
        FruitTransactionDao ftDao = new LocalStorageFruitTransactionDao();
        FruitTransactionOperationStrategy ftOperationStrategy =
                new DefaultFruitTransactionOperationStrategy(HANDLER_MAP);
        FruitTransactionService ftService =
                new DefaultFruitTransactionService(ftValidator, ftDao, ftOperationStrategy);
        ftService.registerAllTransactions(fruitTransactions);

        // 4. Create report
        FruitTransactionReport fruitTransactionReport = ftService.generateReport();

        // 5. Write report to a file
        FileUtils.writeDataToFile(REPORT_FILEPATH, fruitTransactionReport.toString());
    }
}
