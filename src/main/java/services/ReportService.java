package services;

import java.util.List;
import model.Product;

public interface ReportService {
    String createReport(List<Product> products);
}
