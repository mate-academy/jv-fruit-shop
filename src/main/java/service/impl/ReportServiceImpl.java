package service.impl;

import db.FruitStorage;
import java.util.stream.Collectors;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport() {
        return FruitStorage.storage.entrySet().stream()
                .map(fs -> fs.getKey() + "," + fs.getValue())
                .collect(Collectors.joining("\n", "fruit,quantity\n", ""));
    }
}
