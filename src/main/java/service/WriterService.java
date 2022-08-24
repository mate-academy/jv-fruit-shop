package service;

import java.util.List;
import model.FruitTransaction;

public interface WriterService {
    void createReport(List<FruitTransaction> transactions, String fileName);
}
