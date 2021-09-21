package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface FruitShopDataParser {
    List<TransactionDto> parse(List<String> readFile);

    TransactionDto getFromCsvRow(String line);
}
