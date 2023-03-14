package core.basesyntax.service;

import java.io.File;
import java.util.Map;

public interface ReportMakerService {
    File createReport(Map<String, Integer> storage);
}
