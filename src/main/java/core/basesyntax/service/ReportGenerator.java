package core.basesyntax.service;

import java.util.Map;

public interface ReportGenerator {
    String makeReport(Map<String, Integer> dataFromStorage);
}
