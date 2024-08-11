package core.basesyntax;

import core.basesyntax.model.Product;

import java.util.List;

public interface ReportGenerator {
    String getReport(List<Product> productList);
}
