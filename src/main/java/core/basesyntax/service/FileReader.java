package core.basesyntax.service;

import java.util.List;

public interface FileReader {
    List<String> getDataFromInputFile(String fileName);
    List<String> getDataFromFileReader();
}
