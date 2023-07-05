package core.basesyntax.service;

import java.util.List;

public interface ReadDailyTransactions {
    List<String> getListOfTransactions(String transactionFullPath);
}
