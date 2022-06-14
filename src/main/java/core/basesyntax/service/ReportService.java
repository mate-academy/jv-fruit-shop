package core.basesyntax.service;

import core.basesyntax.dao.ProductDao;
import java.util.List;

public interface ReportService {
    List<String> createReport(ProductDao productDao);
}
