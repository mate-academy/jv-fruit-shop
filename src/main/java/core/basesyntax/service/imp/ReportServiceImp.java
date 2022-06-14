package core.basesyntax.service.imp;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.service.ReportService;
import java.util.List;
import java.util.stream.Collectors;

public class ReportServiceImp implements ReportService {
    private static final String SEPARATOR = ",";

    @Override
    public List<String> createReport(ProductDao productDao) {
        return productDao.getAll()
                .entrySet()
                .stream()
                .map(e -> e.getKey() + "," + e.getValue().toString())
                .collect(Collectors.toList());
    }
}
