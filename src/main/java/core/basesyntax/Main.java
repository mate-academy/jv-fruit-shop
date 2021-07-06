package core.basesyntax;

import exceptions.InvalidDataException;
import java.nio.file.Path;
import reporter.FruitShopDataReporter;

public class Main {
    public static void main(String[] args) {
        FruitShopDataReporter reporter = new FruitShopDataReporter();
        try {
            System.out.println(reporter.makeReportFrom(
                    Path.of("./src/main/resources/reportData.txt")));
        } catch (InvalidDataException e) {
            throw new RuntimeException("Not good data");
        }
    }
}
