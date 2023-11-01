package core.basesyntax.service;

import java.util.ArrayList;

public interface FileWriteService {
    void writeCvsToFile(ArrayList<String> text, String path);
}
