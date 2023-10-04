package core.basesyntax.db;

import java.util.List;
import java.util.stream.Collectors;

public class StorageImpl implements Storage {
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public List<String> getAll() {
        return Storage.storage.entrySet().stream()
                .map(e -> e.getKey() + COMMA_SEPARATOR + e.getValue())
                .collect(Collectors.toList());
    }
}
