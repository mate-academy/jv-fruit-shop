package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportMakerService;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportMakerServiceImpl implements ReportMakerService {
    private final FileWriterService fileWriterService;

    public ReportMakerServiceImpl(FileWriterService fileWriterService) {
        this.fileWriterService = fileWriterService;
    }

    @Override
    public File createReport(Map<String, Integer> storage) {
        StringBuilder report = new StringBuilder("fruit,quantity\n");
        report.append(storage
                .entrySet()
                .stream()
                .map(k -> String.join(",",List.of(k.getKey(),String.valueOf(k.getValue()))))
                .collect(Collectors.joining(System.lineSeparator())));
        return fileWriterService.writeReportToFile(report.toString());
    }
}
