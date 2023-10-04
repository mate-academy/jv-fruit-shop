package core.basesyntax.service.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.Product;
import core.basesyntax.service.ReportCreatorService;
import java.util.ArrayList;
import java.util.List;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String TITLE = "fruit,quantity";
    private final ProductDao<Product, Integer> dao;

    public ReportCreatorServiceImpl(ProductDao<Product, Integer> dao) {
        this.dao = dao;
    }

    @Override
    public List<String> createReport() {
        List<String> report = new ArrayList<>(List.of(TITLE));
        for (Product product : Product.values()) {
            if (dao.get(product) != null) {
                report.add(String.format("%s,%d",
                        product.name().toLowerCase(),
                        dao.get(product)));
            }
        }
        return report;
    }
}
