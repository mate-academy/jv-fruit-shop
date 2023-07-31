package core.basesyntax.service;

import java.util.List;

public interface DataConvertor<T> {
    List<T> convert(String csvData);
}
