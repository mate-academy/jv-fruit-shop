package core.basesyntax;

import db.FruitsDao;
import db.GenericDao;
import java.nio.file.Path;
import reporter.FruitShopAutoReporterImpl;
import reporter.Reporter;

public class Main {
    private static final Path CSV_DATA_SOURCE = Path.of("src/main/resources/reportData.csv");
    private static final Path CSV_DATA_OUTPUT = Path.of("src/main/resources/FruitShopReport.csv");

    public static void main(String[] args) {
        Reporter report = new FruitShopAutoReporterImpl();
        GenericDao fruitsDao = new FruitsDao();
        report.makeReportFromTo(CSV_DATA_SOURCE, CSV_DATA_OUTPUT, fruitsDao);
    }
}
