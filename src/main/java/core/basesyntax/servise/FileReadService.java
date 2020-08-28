package core.basesyntax.servise;

import core.basesyntax.ProductsDto;
import java.util.List;

public interface FileReadService {
    List<ProductsDto> readFromFile(String fileName);
}
