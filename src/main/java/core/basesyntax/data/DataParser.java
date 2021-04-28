package core.basesyntax.data;

import core.basesyntax.dto.Dto;
import java.util.List;

public interface DataParser {
    List<Dto> convert(List<String> listWithRawData);
}
