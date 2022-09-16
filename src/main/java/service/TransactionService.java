package service;

import java.util.List;

public interface TransactionService {
    void processData(List<String> data);
    String generateReport();
}
