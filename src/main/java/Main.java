import core.basesyntax.app.FruitShopApp;
import core.basesyntax.service.file.CsvFileReader;
import core.basesyntax.service.file.CsvFileWriter;
import core.basesyntax.service.parser.FruitTransactionDataParser;
import core.basesyntax.service.reporter.FruitReporterImpl;

public class Main {
    private static final FruitShopApp fruitShopApp = new FruitShopApp(
            new CsvFileWriter(), new CsvFileReader(),
            new FruitReporterImpl(), new FruitTransactionDataParser());

    public static void main(String[] args) {
        fruitShopApp.createDailyReport();
    }
}
