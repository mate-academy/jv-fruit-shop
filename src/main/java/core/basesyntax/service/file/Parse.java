package core.basesyntax.service.file;

import java.util.List;

public interface Parse<R> {
    List<R> parseDataFromFile(String[] dataFromFile);
}
