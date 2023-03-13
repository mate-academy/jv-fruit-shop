package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Grid;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.GridReadService;
import core.basesyntax.service.GridWriteService;
import core.basesyntax.service.TransactionsEvaluateService;
import core.basesyntax.service.ValueOfFruit;
import core.basesyntax.service.impl.CsvGridReadService;
import core.basesyntax.service.impl.CsvGridWriteService;
import core.basesyntax.service.impl.RowFruitTransactionParser;
import core.basesyntax.service.impl.RowValueOfFruit;
import core.basesyntax.service.impl.TransactionsEvaluateServiceImpl;
import core.basesyntax.strategy.impl.ReportStrategyImpl;
import java.io.File;
import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class FruitShopMain {
    private static final String SOURCE_FILE_PATH = "src/source.csv";
    private static final String REPORT_FILE_PATH = "src/report.csv";

    public static void main(String[] args) {
        // Services creation
        GridReadService gridReadService = new CsvGridReadService(new File(SOURCE_FILE_PATH));
        FruitTransactionParser parser = new RowFruitTransactionParser();
        TransactionsEvaluateService evaluateService =
                new TransactionsEvaluateServiceImpl(new ReportStrategyImpl());
        GridWriteService gridWriteService = new CsvGridWriteService(new File(REPORT_FILE_PATH));
        // Processing transactions
        List<FruitTransaction> fruitTransactions =
                parser.parse(gridReadService.getGrid().getRows());
        evaluateService.evaluate(fruitTransactions);
        // Report creating
        ValueOfFruit valueOfFruit = new RowValueOfFruit();
        List<String[]> lines = valueOfFruit.valueOf(Storage.getFruits());
        gridWriteService.writeLines(new Grid(Storage.DEFAULT_TITLES, lines));
    }
}
