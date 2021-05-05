package core.basesyntax.services.interfaces;

import core.basesyntax.model.dtos.FruitDtoTransaction;
import java.util.List;

public interface FruitDtoTransactionParser {
    List<FruitDtoTransaction> parse(List<String> lines);
}
