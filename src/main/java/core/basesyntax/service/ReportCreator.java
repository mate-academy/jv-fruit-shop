package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface ReportCreator<T> {
    String create(List<T> data);

    String formatReport(Map<String, Integer> report);
}
