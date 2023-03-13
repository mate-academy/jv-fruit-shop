package core.basesyntax.service;

import java.util.List;

public interface GridReadService {
    String[] getTitles();

    String getValue(int i, String title);

    int getRowsCount();

    List<String[]> getRows();
}
