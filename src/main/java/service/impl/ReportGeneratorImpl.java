package service.impl;

import db.Storage;
import service.ReportGenerator;

import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        Map<String, Integer> storage = Storage.getStorage();
        StringBuilder sb = new StringBuilder();
        sb.append("fruit, quantity\n");
        sb.append(
                storage.entrySet().stream()
                        .map(e -> e.getKey() + "," + e.getValue())
                        .collect(Collectors.joining("\n"))
        );
        return sb.toString();
    }
}
