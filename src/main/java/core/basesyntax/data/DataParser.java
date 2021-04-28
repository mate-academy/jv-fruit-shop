package core.basesyntax.data;

import core.basesyntax.dto.TransactionDto;
import java.util.List;

public interface DataParser {
    List<TransactionDto> convert(List<String> listWithRawData);
}
