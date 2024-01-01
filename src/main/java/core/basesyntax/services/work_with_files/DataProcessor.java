package core.basesyntax.services.work_with_files;

import java.util.List;

public interface DataProcessor {
  List<String[]> processDataForReport(List<String> rawData);
}
