package core.basesyntax;

import java.nio.file.Path;
import reporter.FruitShopAutoReporterImpl;

public class Main {
    private static final Path CSV_DATA_SOURCE = Path.of("./src/main/resources/reportData.txt");
    private static final Path CSV_DATA_OUTPUT = Path.of("./src/main/resources/FruitShopReport.txt");

    public static void main(String[] args) {
        FruitShopAutoReporterImpl report = new FruitShopAutoReporterImpl();
        report.makeReportFromTo(CSV_DATA_SOURCE, CSV_DATA_OUTPUT);
    }
}
