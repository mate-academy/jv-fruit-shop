package core.basesyntax.dto;

import core.basesyntax.model.Product;

public record BalanceDto(Product product, int quantity) {

}
