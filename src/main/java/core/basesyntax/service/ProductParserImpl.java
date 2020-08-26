package core.basesyntax.service;

import core.basesyntax.model.Product;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProductParserImpl implements ProductParser<Product> {
    private static final int TYPE_DATA = 1;
    private static final int QUANTITY_DATA = 2;
    private static final int EXPIRATION_DATA = 3;

    @Override
    public List<Product> getProducts(String[] line) {
        if (line.length != 4) {
            throw new IllegalArgumentException();
        }
        return IntStream.range(0, Integer.parseInt(line[QUANTITY_DATA]))
                            .mapToObj(i -> new Product(line[TYPE_DATA],
                                    LocalDate.parse(line[EXPIRATION_DATA])))
                            .collect(Collectors.toList());
    }
}
