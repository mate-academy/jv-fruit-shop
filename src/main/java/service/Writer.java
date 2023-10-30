package service;

import java.util.List;

public interface Writer {
    void writeToFile(List<String> dailyTransactions, String reportFullPath);
}
