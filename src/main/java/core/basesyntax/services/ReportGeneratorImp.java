package core.basesyntax.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImp implements ReportGenerator {
    private static final String COMMA = ",";
    private final StorageService storageService;

    public ReportGeneratorImp(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public List<String> generateReport() {
        Map<String, Integer> fruits = storageService.getAll();
        List<String> data = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            data.add(entry.getKey() + COMMA + entry.getValue());
        }
        return data;
    }
}
