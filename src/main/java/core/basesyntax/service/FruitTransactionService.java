package core.basesyntax.service;

public interface FruitTransactionService {
    void handleTransactions(String fileToReadPath);

    void writeReportToFile(String fileToWritePath);
}
