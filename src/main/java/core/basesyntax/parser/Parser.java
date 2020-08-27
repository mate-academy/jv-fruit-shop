package core.basesyntax.parser;

import core.basesyntax.model.Model;
import java.util.List;

public interface Parser<T extends Model> {
    T parse(List<String> parseData);
}
