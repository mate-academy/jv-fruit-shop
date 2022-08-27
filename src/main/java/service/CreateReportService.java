package service;

import java.util.List;
import model.FruitTransaction;

public interface CreateReportService {
    String createReport(List<FruitTransaction> transactions);
}
