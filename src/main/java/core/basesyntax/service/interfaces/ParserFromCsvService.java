package core.basesyntax.service.interfaces;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParserFromCsvService {
    List<FruitTransaction> parse(List<String> file);

    List<String> clearAnnotation(List<String> file);
}
