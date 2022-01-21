package core.basesyntax.service.fileoperations;

import java.util.List;

public interface FileService {

    List<String> readData();

    void writeData(String data);
}
