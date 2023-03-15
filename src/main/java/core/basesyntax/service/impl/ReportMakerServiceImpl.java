package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportMakerService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportMakerServiceImpl implements ReportMakerService {
    private static final String COMMA = ",";
    private final FileWriterService fileWriterService;

    public ReportMakerServiceImpl(FileWriterService fileWriterService) {
        this.fileWriterService = fileWriterService;
    }

    @Override
    public void createReport(Map<String, Integer> storage, String path) {
        StringBuilder report = new StringBuilder("fruit,quantity\n");
        report.append(storage
                .entrySet()
                .stream()
                .map(k -> String.join(COMMA,List.of(k.getKey(),String.valueOf(k.getValue()))))
                .collect(Collectors.joining(System.lineSeparator())));
        fileWriterService.writeReportToFile(report.toString(),path);
    }
}
