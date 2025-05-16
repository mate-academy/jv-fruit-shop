import core.basesyntax.service.CsvReportWriter;
import core.basesyntax.service.ReaderFromCsv;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;

public class Main {
    public static void main(String[] arg) {
        ShopService shopService = new ShopServiceImpl();
        ReaderFromCsv reader = new ReaderFromCsv();
        reader.processTransactions("src/main/resources/reportToRead.csv", shopService);
        CsvReportWriter writer = new CsvReportWriter();
        writer.writeReport("src/main/resources/finalReport.csv");
    }
}
