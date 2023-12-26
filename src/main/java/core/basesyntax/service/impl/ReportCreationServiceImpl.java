package core.basesyntax.service.impl;

import core.basesyntax.products.Product;
import core.basesyntax.service.DatabaseDaoService;
import core.basesyntax.service.ReportCreationService;
import java.util.List;

public class ReportCreationServiceImpl implements ReportCreationService {
    public static final String CSV_FIRST_LINE = "product,quantity\n";
    private final DatabaseDaoService databaseDao = new DatabaseDaoServiceImpl();

    @Override
    public String createReport() {
        StringBuilder reportStringBuilder = new StringBuilder(CSV_FIRST_LINE);
        List<Product> dataInfo = databaseDao.getAll();
        for (Product product : dataInfo) {
            reportStringBuilder.append(product.getName()).append(",")
                    .append(product.getAmount()).append("\n");
        }
        return reportStringBuilder.toString();
    }
}
