package core.basesyntax.service.fileservice;

import java.util.List;

public interface Reader {
    List<String> readFromInput(String fileName);
}
