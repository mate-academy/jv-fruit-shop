package core.basesyntax;

import java.util.*;

public interface DataConverter {
    public List<FruitTransaction> convert(List<String> lines);
}
