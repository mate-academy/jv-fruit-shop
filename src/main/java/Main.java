import app.FruitShopApp;
import files.CsvReader;
import files.CsvWriter;
import reporter.FruitReporterImpl;

public class Main {
    private static final FruitShopApp fruitShopApp = new FruitShopApp(
            new CsvWriter(), new CsvReader(), new FruitReporterImpl());

    public static void main(String[] args) {
        fruitShopApp.createDailyReport();
    }
}
