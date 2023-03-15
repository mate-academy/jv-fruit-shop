package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.Map;

public interface ReportMaker {
  public String generateReport(Map<String, Integer> calculations);
}
