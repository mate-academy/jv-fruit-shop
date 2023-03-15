package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface ReportCreatorService {
    List<String> createReport(Map<String, Integer> products);
}
