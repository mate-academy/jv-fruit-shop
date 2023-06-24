package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface TransactionParser {
    Map<String, Integer> saveToDb(List<String> string);
}
