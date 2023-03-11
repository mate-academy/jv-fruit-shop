package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.GridReadService;
import core.basesyntax.service.GridWriteService;
import core.basesyntax.service.ValueOfFruit;
import core.basesyntax.service.impl.CsvGridReadService;
import core.basesyntax.service.impl.CsvGridWriteService;
import core.basesyntax.service.impl.RowFruitTransactionParser;
import core.basesyntax.service.impl.RowValueOfFruit;
import core.basesyntax.strategy.ReportStrategy;
import core.basesyntax.strategy.impl.ReportStrategyImpl;
import java.io.File;
import java.util.stream.Collectors;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    private static final String SOURCE_FILE_PATH = "src/source.csv";
    private static final String REPORT_FILE_PATH = "src/report.csv";

    public static void main(String[] args) {
        // Services creation
        GridReadService gridReadService = new CsvGridReadService(new File(SOURCE_FILE_PATH));
        FruitTransactionParser parser = new RowFruitTransactionParser();
        ReportStrategy strategy = new ReportStrategyImpl();
        // Processing transactions
        gridReadService
                .stream()
                .map(s -> parser.parse(s))
                .forEach(t -> strategy.getHandler(t.getOperation()).proccessTransaction(t));
        // Report creating
        GridWriteService gridWriteService = new CsvGridWriteService(new File(REPORT_FILE_PATH));
        ValueOfFruit valueOfFruit = new RowValueOfFruit();
        gridWriteService.writeLines(
                Storage.entryStream()
                        .map(e -> (String[])valueOfFruit.valueOf(e.getKey(), e.getValue()))
                        .collect(Collectors.toList()),
                Storage.DEFAULT_TITLES
        );
    }
}
