package core.basesyntax.service;

public interface TransactionService {
    void moveDataFromFileToDb(String fromFile);

    void createReport(String toFile);
}
