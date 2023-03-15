package core.basesyntax.service;

import java.util.Collection;

public interface ReportGenerator<S> {
    Collection<String> generateReport(S source);
}
