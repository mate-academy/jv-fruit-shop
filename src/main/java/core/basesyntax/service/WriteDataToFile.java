package core.basesyntax.service;

import java.io.File;
import java.util.List;

public interface WriteDataToFile {
    void writeListToCsvFile(List<String> listReport, File file);
}
