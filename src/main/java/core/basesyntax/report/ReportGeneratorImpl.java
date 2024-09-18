package core.basesyntax.report;

import core.basesyntax.service.StorageService;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private final StorageService storageService;

    public ReportGeneratorImpl(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public String getReport() {
        return storageService.getInventory().entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.joining("\n", "fruit,quantity\n", ""));
    }
}
