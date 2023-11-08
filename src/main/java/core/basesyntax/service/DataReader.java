package core.basesyntax.service;

import java.io.IOException;
import java.util.List;

public interface DataReader<T> {

    List<T> readData(String filePart) throws IOException;
}
