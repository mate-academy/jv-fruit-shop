package core.basesyntax.dataservices;

import java.util.List;

public interface DataReader {
    List<String> read(String fileName);
}
