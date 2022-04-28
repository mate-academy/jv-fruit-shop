package core.basesyntax.service;

import java.util.List;

public interface DataWriter {
    boolean writeData(List<String> list, String fileName);
}
