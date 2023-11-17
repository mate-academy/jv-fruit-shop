package core.basesyntax.converter;

import core.basesyntax.ItemTransaction;
import java.util.List;

public interface Converter {
    List<ItemTransaction> convert(List<String> strings);
}
