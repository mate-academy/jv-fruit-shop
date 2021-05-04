package core.basesyntax.services;

import core.basesyntax.dto.TransactionDto;
import java.util.List;

public interface DataParser {
    List<TransactionDto> parse(List<String> dataList);
}
