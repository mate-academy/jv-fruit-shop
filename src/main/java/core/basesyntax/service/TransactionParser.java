package core.basesyntax.service;

import core.basesyntax.model.ProductTransaction;
import java.util.List;
import java.util.stream.Collectors;

public interface TransactionParser {
    ProductTransaction parse(String line);

    default List<ProductTransaction> parseAll(List<String> line) {
        return line.stream()
                .map(this::parse)
                .collect(Collectors.toList());
    }
}
