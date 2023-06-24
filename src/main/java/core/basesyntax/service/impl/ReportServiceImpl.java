package core.basesyntax.service.impl;

import core.basesyntax.db.ProductStorage;
import core.basesyntax.model.Product;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    private final ProductStorage productStorage;

    public ReportServiceImpl(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append(REPORT_HEADER)
                .append(System.lineSeparator());
        for (Product product : productStorage.getAll()) {
            report.append(product.getName())
                    .append(SEPARATOR)
                    .append(product.getQuantity())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
