package core.basesyntax.service;

import core.basesyntax.Storage;
import java.util.List;

public interface FileWriterService {
    void write(List<Storage.FruitBox> data, String fileName);
}
