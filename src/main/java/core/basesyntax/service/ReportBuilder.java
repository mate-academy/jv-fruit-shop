package core.basesyntax.service;

import java.util.Map;

public interface ReportBuilder {
    String build(Map<String, Integer> storage);
}
