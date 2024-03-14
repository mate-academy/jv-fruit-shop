package core.basesyntax.service.impl;

import core.basesyntax.dao.RecordDao;
import core.basesyntax.dao.RecordDaoImpl;
import core.basesyntax.model.Product;
import core.basesyntax.model.Report;
import core.basesyntax.service.ReportGenerator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommonReportGenerator implements ReportGenerator {
    private static final String QUANTITY = "quantity";
    private static final String COMMA = ",";
    private static final String REPORT_CSV = "Report.csv";
    private final RecordDao recordDao = RecordDaoImpl.getInstance();

    @Override
    public List<Report> generate() {
        List<Product> products = recordDao.getAll();
        if (products.isEmpty()) {
            throw new RuntimeException("DB is empty");
        }
        var groupedProducts = groupProductsByType(products);
        return generateReports(groupedProducts);
    }

    private Map<String, List<Product>> groupProductsByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(p -> p.getClass().getSimpleName() + REPORT_CSV));
    }

    private List<Report> generateReports(Map<String, List<Product>> groupedProducts) {
        return groupedProducts.entrySet().stream()
                .map(e -> new Report(e.getKey(),
                        e.getKey() + COMMA + QUANTITY,
                        getBodyReport(e.getValue())))
                .toList();
    }

    private String getBodyReport(List<Product> products) {
        StringBuilder report = new StringBuilder();
        for (Product product : products) {
            report.append(System.lineSeparator())
                    .append(product.getName())
                    .append(COMMA).append(product.getCount());
        }
        return report.toString();
    }
}
