package core.basesyntax.service.imp;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.service.ReportService;
import java.util.List;
import java.util.stream.Collectors;

public class ReportServiceImp implements ReportService {
    private static final String SEPARATOR = ",";
    private final ProductDao productDao;

    public ReportServiceImp(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<String> createReport(String header) {
        List<String> report = productDao.getAll()
                .entrySet()
                .stream()
                .map(e -> e.getKey() + SEPARATOR + e.getValue().toString())
                .collect(Collectors.toList());

        report.add(0, header);
        return report;
    }
}
