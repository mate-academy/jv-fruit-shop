package core.basesyntax.dao;

import java.io.File;
import java.util.List;

public interface FileDataWriter {
    File writeData(List<String> processedList); // We should return report as a File(.csv)
}
