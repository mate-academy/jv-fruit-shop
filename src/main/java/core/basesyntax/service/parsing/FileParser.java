package core.basesyntax.service.parsing;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FileParser {
    List<FruitTransaction> parse(List<String> records);
}
