package core.basesyntax.fileservice;

import core.basesyntax.dto.ProductDto;
import java.util.List;

public interface Parser {
    List<ProductDto> parse(List<String> data);
}
