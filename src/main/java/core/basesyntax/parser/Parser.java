package core.basesyntax.parser;

import core.basesyntax.InputDataModel;
import java.util.List;

public interface Parser<T extends InputDataModel> {
    T parse(List<String> parseData);
}
