package core.basesyntax;

import java.nio.file.Path;
import reporter.FruitShopAutoReporterImpl;

public class Main {
    public static void main(String[] args) {
        Path from = Path.of("./src/main/resources/reportData.txt");
        Path to = Path.of("./src/main/resources/FruitShopReport.txt");
        FruitShopAutoReporterImpl report = new FruitShopAutoReporterImpl();
        report.makeReportFromTo(from, to);
    }
}
