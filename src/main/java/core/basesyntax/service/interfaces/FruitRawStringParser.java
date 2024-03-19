package core.basesyntax.service.interfaces;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.model.FruitItem;
import core.basesyntax.model.Item_Operation;

import java.util.HashMap;
import java.util.List;

public interface FruitRawStringParser {
    List<FruitTransactionDto> parsedFruitData (List<String> rawString);
}
