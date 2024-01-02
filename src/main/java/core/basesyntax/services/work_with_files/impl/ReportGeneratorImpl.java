package core.basesyntax.services.work_with_files.impl;

import core.basesyntax.services.work_with_files.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {

  @Override
  public StringBuilder generateReport(Map<String, Integer> fruitsTypeAndAmount) {
    StringBuilder builder = new StringBuilder();
    builder.append("fruit,quantity");
    for(Map.Entry<String, Integer> entry : fruitsTypeAndAmount.entrySet()) {
      builder.append(System.lineSeparator()).append(entry.getKey()).append(",").append(entry.getValue());
    }
    return builder;
  }
}
