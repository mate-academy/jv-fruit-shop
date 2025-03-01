package core.basesyntax.dataparser;

import java.util.List;

public interface DataParser {
    List<String[]> parseData(List<String> srcContents);
}
