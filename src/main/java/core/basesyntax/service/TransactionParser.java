package core.basesyntax.service;

import java.util.List;

public interface TransactionParser {
    List<List<String>> parse(String dataFromCsv);
}
