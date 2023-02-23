package core.basesyntax.service.impl;

import core.basesyntax.db.OutputWriter;
import core.basesyntax.db.OutputWriterImpl;
import core.basesyntax.exception.ReportMakerException;
import core.basesyntax.service.ReportMakerService;

import java.util.Map;
import java.util.stream.Collectors;

public class ReportMakerServiceImpl implements ReportMakerService {
    private static final String COLUMNS_SEPARATOR = ",";
    private static final String TITLE = "fruit,quantity";
    private final OutputWriter outputWriter;

    public ReportMakerServiceImpl() {
        this.outputWriter = new OutputWriterImpl();
    }

    @Override
    public void generateReport(Map<String, Integer> fruitsMap, String toFile) {
        if (fruitsMap == null || toFile == null) {
            throw new ReportMakerException("None of the arguments can be null");
        }
        String content = fruitsMap.entrySet()
                .stream()
                .map(i -> i.getKey() + COLUMNS_SEPARATOR + i.getValue() + System.lineSeparator())
                .collect(Collectors.joining());
        outputWriter.generateReport(TITLE + System.lineSeparator() + content, toFile);
    }
}
