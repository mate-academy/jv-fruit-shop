package core.basesyntax.parse;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface ParseFruit {
    List<TransactionDto> parse(List<String[]> data);
}
