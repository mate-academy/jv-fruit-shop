package service;

import java.util.List;
import model.FruitTransaction;

public interface ReportService {

    public List<String> createReport(List<FruitTransaction> transactions);
}
