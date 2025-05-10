package core.basesyntax.service.interfaces;

import core.basesyntax.dto.FruitTransactionDto;
import java.util.List;

public interface FruitRawStringParser {
    List<FruitTransactionDto> parsedFruitData(List<String> rawString);
}
