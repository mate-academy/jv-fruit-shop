package core.basesyntax.functions;

import java.util.List;

@FunctionalInterface
public interface ReadFile {
    List<String[]> read(String fileName);
}
