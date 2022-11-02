package core.basesyntax.service;

import java.util.Map;

public interface DataTransactionParserService {
    Map<String, Integer> parseDataTransaction(String data);
}
