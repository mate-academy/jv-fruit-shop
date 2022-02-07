package core.basesyntax.service;

import java.util.List;

public interface DataWriter {
    boolean writeDataToFile(List<String> list, String filename);
}
