package core.basesyntax.service.Impl;

import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportGeneratorService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private final FileWriterService fileWriterService;

    public ReportGeneratorServiceImpl(FileWriterService fileWriterService) {
        this.fileWriterService = fileWriterService;
    }

    @Override
    public void generateReport(Map<String, Integer> storage, String path) {
        StringBuilder report = new StringBuilder("fruit,quantity\n");
        report.append(storage
                .entrySet()
                .stream()
                .map(k -> String.join(",", List.of(k.getKey(),String.valueOf(k.getValue()))))
                .collect(Collectors.joining(System.lineSeparator())));
        fileWriterService.writeReportToFile(report.toString(),path);
    }
}
