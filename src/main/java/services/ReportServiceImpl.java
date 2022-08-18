package services;

import model.Product;
import java.util.List;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "name,quantity";

    @Override
    public String report(List<Product> Products) {
        List<String> lines = Products.stream()
                .map(Product::toString)
                .collect(Collectors.toList());
        lines.add(0, HEADER);
        return lines
                .stream()
                .collect(Collectors.joining(System.lineSeparator()));
    }

}
