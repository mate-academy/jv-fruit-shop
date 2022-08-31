package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String HEADERS = "fruit,quantity";

    @Override
    public String getReport() {
        return Storage.getStorage().entrySet().stream()
                .map(totalFruits -> totalFruits.getKey() + "," + totalFruits.getValue()
                        + System.lineSeparator())
                .collect(Collectors.joining());
    }

    @Override
    public void writeHeaders(BufferedWriter bufferedWriter) {
        try {
            bufferedWriter.write(HEADERS + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Can't write headers to file", e);
        }
    }
}
