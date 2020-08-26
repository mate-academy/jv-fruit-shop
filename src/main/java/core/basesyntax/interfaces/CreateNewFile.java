package core.basesyntax.interfaces;

import java.io.IOException;
import java.util.List;

public interface CreateNewFile<T> {
    void createNewFile(List<T> fruit) throws IOException;
}
