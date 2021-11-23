package core.basesyntax.service.file;

import java.util.List;

public interface Parse<R> {
    List<R> parse(String[] dataFromFile);
}
