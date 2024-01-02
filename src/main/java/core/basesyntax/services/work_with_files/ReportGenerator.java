package core.basesyntax.services.work_with_files;

import java.util.Map;

public interface ReportGenerator {
  StringBuilder generateReport(Map<String, Integer> fruitsTypeAndAmount);
}
