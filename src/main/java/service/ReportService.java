package service;

import java.util.List;
import model.FruitTransaction;

public interface ReportService {
    String getReport(List<FruitTransaction> fruitsTransactionData);
}
