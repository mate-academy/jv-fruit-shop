package service;

import java.util.List;
import model.FruitTransaction;

public interface ReportService {
    List<String> createReport(List<FruitTransaction> list);

}
