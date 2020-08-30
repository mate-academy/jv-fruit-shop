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
    private static final int QUANTITY_OF_PARAMETERS = 4;

    @Override
    public List<Product> getProducts(String[] line) {
        if (line.length != QUANTITY_OF_PARAMETERS
                || Integer.parseInt(line[QUANTITY_DATA]) < 0
                || line[EXPIRATION_DATA].matches("[\\d{4}]-[\\d{2}]-[\\d{2}]")) {
            throw new IllegalArgumentException();
        }

        return IntStream.range(0, Integer.parseInt(line[QUANTITY_DATA]))
                            .mapToObj(i -> new Product(line[TYPE_DATA],
                                    LocalDate.parse(line[EXPIRATION_DATA])))
                            .collect(Collectors.toList());
    }
}
