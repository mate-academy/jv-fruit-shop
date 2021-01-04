package core.basesyntax;

import core.basesyntax.service.FruitService;
import core.basesyntax.service.io.impl.CSVDataImporter;
import core.basesyntax.service.io.impl.CSVReportWriter;

public class Main {
    public static void main(String[] args) {
        FruitService service = new FruitService(new CSVDataImporter<>(), new CSVReportWriter<>());
        service.importData();
        service.writeReport();
    }
}
