package core.basesyntax.service;

import core.basesyntax.serviceimpl.FruitTransaction;
import java.util.List;

public interface ConvertService {
    List<FruitTransaction> convert(List<String> list);
}
