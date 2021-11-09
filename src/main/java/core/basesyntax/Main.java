package core.basesyntax;

import core.basesyntax.dao.ResourcesDao;
import core.basesyntax.dao.ResourcesDaoImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.StorageServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ResourcesDao resourcesDao = new ResourcesDaoImpl();
        List<String> dataFromFile = resourcesDao
                .readFromFile("src/main/java/core/basesyntax/resources/input");
        StorageService storageService = new StorageServiceImpl();
        storageService
                .updateProductsAmountInStorage("src/main/java/core/basesyntax/resources/input");
        ReportService reportService = new ReportServiceImpl();
        reportService.makeReport("src/main/java/core/basesyntax/resources/report.csv");
    }
}
