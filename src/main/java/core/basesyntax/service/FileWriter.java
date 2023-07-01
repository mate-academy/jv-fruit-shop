package core.basesyntax.service;

import java.util.List;

public interface FileWriter {

    void writeToFile(List<String> dailyTransactionsStringList);
}
