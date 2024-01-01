package core.basesyntax.services.work_with_files.impl;

import core.basesyntax.services.work_with_files.DataProcessor;
import java.util.List;
import java.util.stream.Collectors;

public class DataProcessorImpl implements DataProcessor {

  @Override
  public List<String[]> processDataForReport(List<String> rawData) {
    return rawData.stream()
            .map(string -> string.split(","))
            .collect(Collectors.toList());
  }
}
