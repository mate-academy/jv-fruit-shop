package service;

import java.util.List;
import model.FruitTransaction;

public interface ReportCreator {
    String createReport(List<FruitTransaction> fruitTransactions);
}
