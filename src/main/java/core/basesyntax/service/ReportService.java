package core.basesyntax.service;

import java.util.Collection;

public interface ReportService<S> {
    Collection<String> generateReport(S source);
}
