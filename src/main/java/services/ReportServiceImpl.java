package services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.Product;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "name,quantity";

    @Override
    public String createReport(List<Product> products) {
        List<String> lines = new ArrayList<>();
        lines.add(HEADER);
        products.stream()
                .map(Product::toString)
                .forEach(lines::add);
        return lines.stream()
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
