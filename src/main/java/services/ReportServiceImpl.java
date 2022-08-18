package services;

import java.util.List;
import java.util.stream.Collectors;
import model.Product;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "name,quantity";

    @Override
    public String report(List<Product> products) {
        List<String> lines = products.stream()
                .map(Product::toString)
                .collect(Collectors.toList());
        lines.add(0, HEADER);
        return lines
                .stream()
                .collect(Collectors.joining(System.lineSeparator()));
    }

}
