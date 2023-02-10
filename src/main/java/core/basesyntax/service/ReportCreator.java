package core.basesyntax.service;

import java.util.Map;

public interface ReportCreator {
    String getReport(Map<String, Integer> leftovers);
}
