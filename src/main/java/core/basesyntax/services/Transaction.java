package core.basesyntax.services;

import core.basesyntax.dto.FruitDto;
import java.util.List;

public interface Transaction {
    List<FruitDto> parseFruits(List<String> rowsFromFile);
}
