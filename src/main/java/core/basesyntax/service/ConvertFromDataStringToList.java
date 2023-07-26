package core.basesyntax.service;

import java.util.List;

public interface ConvertFromDataStringToList<T> {
    List<T> convert(String csvData);
}
