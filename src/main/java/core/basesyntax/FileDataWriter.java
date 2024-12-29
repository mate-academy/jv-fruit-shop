package core.basesyntax;

import java.io.File;
import java.util.List;

public interface FileDataWriter {
    File writeData(List<String> processedList);
}
