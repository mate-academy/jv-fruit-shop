package core.basesyntax.interfaces;

import java.io.IOException;
import java.util.List;

public interface CreateNewFile<T> {
    void writeNewFile(List<T> fruit) throws IOException;
}
