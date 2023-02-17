package service;

import java.util.List;
import model.FruitTransaction;

public interface ReportService {

    void createReport(List<FruitTransaction> transactions);
}
