import app.FruitShopApp;
import files.CsvFileReader;
import files.CsvFileWriter;
import parsers.FruitTransactionDataParser;
import reporter.FruitReporterImpl;

public class Main {
    private static final FruitShopApp fruitShopApp = new FruitShopApp(
            new CsvFileWriter(), new CsvFileReader(),
            new FruitReporterImpl(), new FruitTransactionDataParser());

    public static void main(String[] args) {
        fruitShopApp.createDailyReport();
    }
}
