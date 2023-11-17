package core.basesyntax.service;

import core.basesyntax.model.ItemTransaction;
import java.util.List;

public interface Converter {
    List<ItemTransaction> convert(List<String> strings);
}
