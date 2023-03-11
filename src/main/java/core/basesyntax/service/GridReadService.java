package core.basesyntax.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public interface GridReadService {
    String[] getTitles();
    String getValue(int i, String title);
    int getRowsCount();
    Stream<String[]> stream();
}
