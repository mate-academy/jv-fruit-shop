package core.dao;

import core.db.Storage;
import java.util.stream.Collectors;

public class DataToStringImpl implements DataToString {
    @Override
    public String generateString() {
        return Storage.fruits.entrySet().stream()
                .map(s -> s.getKey() + "," + s.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
