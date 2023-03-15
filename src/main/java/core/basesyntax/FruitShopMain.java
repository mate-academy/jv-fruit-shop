package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.GridGeneratorService;
import core.basesyntax.service.GridReadService;
import core.basesyntax.service.GridWriteService;
import core.basesyntax.service.TransactionsEvaluateService;
import core.basesyntax.service.impl.CsvGridReadService;
import core.basesyntax.service.impl.CsvGridWriteService;
import core.basesyntax.service.impl.FruitGridGeneratorService;
import core.basesyntax.service.impl.RowFruitTransactionParser;
import core.basesyntax.service.impl.TransactionsEvaluateServiceImpl;
import core.basesyntax.strategy.impl.ReportStrategyImpl;
import java.util.List;

public class FruitShopMain {
    private static final String SOURCE_FILE_PATH = "src/source.csv";
    private static final String REPORT_FILE_PATH = "src/report.csv";
    private static GridReadService gridReadService = new CsvGridReadService();
    private static FruitTransactionParser parser = new RowFruitTransactionParser();
    private static TransactionsEvaluateService evaluateService =
            new TransactionsEvaluateServiceImpl(new ReportStrategyImpl());
    private static GridWriteService gridWriteService = new CsvGridWriteService();
    private static GridGeneratorService gridGeneratorService = new FruitGridGeneratorService();

    public static void main(String[] args) {
        List<FruitTransaction> fruitTransactions =
                parser.parse(gridReadService.getGrid(SOURCE_FILE_PATH).getRows());
        evaluateService.evaluate(fruitTransactions);
        gridWriteService.write(REPORT_FILE_PATH, gridGeneratorService.grid(Storage.fruits));
    }
}
