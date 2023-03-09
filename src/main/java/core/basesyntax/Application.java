package core.basesyntax;

import core.basesyntax.impl.StorageAccessImpl;
import core.basesyntax.impl.StorageServiceImpl;
import core.basesyntax.service.StorageAccess;
import core.basesyntax.service.StorageService;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        StorageAccess storageAccess = new StorageAccessImpl();
        StorageService storageService = new StorageServiceImpl();
        List<String> dataFromStorage = storageAccess.readData(
                "src\\main\\java\\core\\basesyntax\\db\\storage.cvs");
        Map<String, Integer> report = storageService.createReport(dataFromStorage);
        storageAccess.writeData(report,
                "src\\main\\java\\core\\basesyntax\\resource\\report.cvs");
    }
}
