package core.basesyntax.service;

import java.util.List;

public interface FileService {

    List<String> read(String fileName);

    void write(List<String> content, String fileName);
}
