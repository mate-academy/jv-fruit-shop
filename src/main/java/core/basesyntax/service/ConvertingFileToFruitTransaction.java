package core.basesyntax.service;

import java.util.List;

public interface ConvertingFileToFruitTransaction {
    List<FruitTransaction> convert(List<String> lines);
}
