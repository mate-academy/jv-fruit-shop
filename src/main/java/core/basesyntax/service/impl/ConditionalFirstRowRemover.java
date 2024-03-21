package core.basesyntax.service.impl;

import java.util.List;

public class ConditionalFirstRowRemover implements RowRemover {
    private static final int FIRST_ROW = 0;

    @Override
    public void remove(List<String> rows) {
        if (!rows.isEmpty() && rows.get(FIRST_ROW).matches("\\D+,\\D+,\\D+")) {
            rows.remove(FIRST_ROW);
        }
    }
}
