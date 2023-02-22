package core.basesyntax.service.impl;

import core.basesyntax.db.OutputWriter;
import core.basesyntax.db.OutputWriterImpl;
import core.basesyntax.service.ReportMakerService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportMakerServiceImpl implements ReportMakerService {
    private static final String COLUMNS_SEPARATOR = ",";
    private final OutputWriter outputWriter;

    public ReportMakerServiceImpl() {
        this.outputWriter = new OutputWriterImpl();
    }

    @Override
    public void generateReport(Map<String, Integer> fruitsMap, String toFile) {
        String content = fruitsMap.entrySet()
                .stream()
                .map(i -> i.getKey() + COLUMNS_SEPARATOR + i.getValue() + System.lineSeparator())
                .collect(Collectors.joining());
        outputWriter.generateReport(content, toFile);
    }
}
