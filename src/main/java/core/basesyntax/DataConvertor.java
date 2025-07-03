package core.basesyntax;

import java.util.List;

public interface DataConvertor {
    List<FruitTransaction> dataConvert(List<String> allLines);
}
