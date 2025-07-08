package core.basesyntax.service.reportservice;

import core.basesyntax.db.Storage;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER_OF_REPORT = "fruit,quantity" + System.lineSeparator();
    private static final char EQUALS = '=';
    private static final char COMMA = ',';

    @Override
    public String getReport() {
        return HEADER_OF_REPORT
                + Storage.fruits.entrySet().stream()
                        .map(String::valueOf)
                        .map(s -> s.replace(EQUALS, COMMA))
                        .collect(Collectors.joining(System.lineSeparator()));
    }
}
