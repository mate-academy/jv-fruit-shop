package core.basesyntax.service;

import java.util.List;

public interface BalanceService {
    void getTransactionsFromFile();
    void calculateBalance();
    List<String> makeBalanceReport();
    void exportPivotToFile(List<String> report);

}
