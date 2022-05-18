package core.basesyntax.service;

import java.util.Map;

public interface GenerateBalanceReport {
    String getReport(Map<String, Integer> balance);
}
