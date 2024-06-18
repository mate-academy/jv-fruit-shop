package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface ReportCreator {
    List<String> createReport(Map<String, Integer> transactions);
}
