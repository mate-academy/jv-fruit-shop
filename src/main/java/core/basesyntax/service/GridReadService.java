package core.basesyntax.service;

import java.util.stream.Stream;

public interface GridReadService {
    String[] getTitles();

    String getValue(int i, String title);

    int getRowsCount();

    Stream<String[]> stream();
}
