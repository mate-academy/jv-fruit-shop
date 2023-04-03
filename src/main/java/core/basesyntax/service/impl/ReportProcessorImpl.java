package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportProcessor;
import java.util.stream.Collectors;

public class ReportProcessorImpl implements ReportProcessor<Storage, String> {

    @Override
    public String getReport(Storage data, String header) {
        return data.get().entrySet().stream()
                .map(e -> e.getKey().getName() + "," + e.getValue())
                .collect(Collectors.joining(System.lineSeparator(),
                        header + System.lineSeparator(), ""));
    }
}
