package core.basesyntax.service.file;

import java.util.List;

public interface Parser<R> {
    List<R> parse(String[] dataFromFile);
}
