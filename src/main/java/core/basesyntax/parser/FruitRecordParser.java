package core.basesyntax.parser;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface FruitRecordParser {
    List<TransactionDto> parse(List<String> records);
}
