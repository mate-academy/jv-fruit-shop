package service.impl;

import dao.WriterService;
import db.FruitStore;
import java.util.Map;
import java.util.stream.Collectors;
import service.CreateReportService;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String TITLE = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private WriterService writerService;

    public CreateReportServiceImpl(WriterService writerService) {
        this.writerService = writerService;
    }

    @Override
    public void generateReport() {
        Map<String, Integer> supplies = FruitStore.supplies;
        String report = supplies.entrySet()
                .stream()
                .map(entry -> entry.getKey()
                        + SEPARATOR
                        + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator(),
                        TITLE + System.lineSeparator(),
                        ""));
        writerService.add(report);
    }
}
