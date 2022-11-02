package core.basesyntax.service;

import java.util.Map;

public interface DataTransactionParser {
    Map<String, Integer> parseDataTransaction(String data);
}
