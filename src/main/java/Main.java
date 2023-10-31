import core.basesyntax.app.FruitShopApp;
import core.basesyntax.files.CsvFileReader;
import core.basesyntax.files.CsvFileWriter;
import core.basesyntax.parsers.FruitTransactionDataParser;
import core.basesyntax.reporter.FruitReporterImpl;

public class Main {
    private static final FruitShopApp fruitShopApp = new FruitShopApp(
            new CsvFileWriter(), new CsvFileReader(),
            new FruitReporterImpl(), new FruitTransactionDataParser());

    public static void main(String[] args) {
        fruitShopApp.createDailyReport();
    }
}
