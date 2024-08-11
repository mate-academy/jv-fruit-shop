package core.basesyntax;

import core.basesyntax.model.Product;

import java.util.List;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport(List<Product> productList) {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity\n");
        productList.stream()
                .forEach(product -> report.append(product.getNameOfProduct()
                                + ","
                                + product.getNumber()
                                + "\n"));
        return report.toString();
    }
}
