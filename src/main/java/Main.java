import app.FruitShopApp;
import files.CsvFIleReader;
import files.CsvFileWriter;
import reporter.FruitReporterImpl;

public class Main {
    private static final FruitShopApp fruitShopApp = new FruitShopApp(
            new CsvFileWriter(), new CsvFIleReader(), new FruitReporterImpl());

    public static void main(String[] args) {
        fruitShopApp.createDailyReport();
    }
}
