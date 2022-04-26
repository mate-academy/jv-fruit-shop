package core.basesyntax.service.parse;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParserService {
    List<FruitTransaction> parse(List<String> sourceCsvData);
}
