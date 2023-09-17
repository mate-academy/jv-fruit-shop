package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;

import java.util.Map;

public class ReportServiceImpl implements ReportService {
  private static final Map<String, Integer> STORE = Storage.STORAGE;
  private static final String FIRST_ROW = "fruit,quantity\n";
  private static final String DELIMITER = ",";

  @Override
  public String createReport() {
    StringBuilder builder = new StringBuilder(FIRST_ROW);
    for (Map.Entry<String, Integer> entry : STORE.entrySet()) {
      builder.append(entry.getKey())
              .append(DELIMITER)
              .append(entry.getValue())
              .append(System.lineSeparator());
    }
    return builder.toString();
  }
}
