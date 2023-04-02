package core.basesyntax;

import java.util.List;

public interface Parser {
    List<String[]> parse(List<String> stringList);
}
