package core.basesyntax.operations;

import core.basesyntax.dto.ProductDto;

public interface Operation {
    void apply(ProductDto productDto);
}
