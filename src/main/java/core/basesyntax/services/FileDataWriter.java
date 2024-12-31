package core.basesyntax.services;

import java.io.File;
import java.util.List;

public interface FileDataWriter {
    File writeData(List<String> processedList);
}
