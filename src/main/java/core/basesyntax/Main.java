package core.basesyntax;

import java.nio.file.Path;
import reporter.FruitShopDataReporter;

public class Main {
    public static void main(String[] args) {
        FruitShopDataReporter reporter = new FruitShopDataReporter();
        reporter.makeReportFrom(
                Path.of("./src/main/resources/reportData.txt"));
    }
}
