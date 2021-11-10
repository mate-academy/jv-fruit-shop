package core.basesyntax;

import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.StorageServiceImpl;

public class Main {
    public static void main(String[] args) {
        StorageService storageService = new StorageServiceImpl();
        storageService
                .updateProductsAmountInStorage("src/main/java/core/basesyntax/resources/input");
        ReportService reportService = new ReportServiceImpl();
        reportService.makeReport("src/main/java/core/basesyntax/resources/report.csv");
    }
}
