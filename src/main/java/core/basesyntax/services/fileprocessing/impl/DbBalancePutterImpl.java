package core.basesyntax.services.fileprocessing.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.fileprocessing.DbBalancePutter;
import java.util.List;
import java.util.stream.Collectors;

public class DbBalancePutterImpl implements DbBalancePutter {
    private static final String STRING_SPLITTER = ",";
    private static final String BALANCE_LINE_STARTS_WITH = "b";
    private static final String SKIP_LINE_IF_CONTAINS = "quantity";

    @Override
    public List<String[]> getBalanceData(List<String> rawData) {
        return rawData.stream().map(string -> string.split(STRING_SPLITTER))
                .filter(strings -> strings[0].equals(BALANCE_LINE_STARTS_WITH))
                .collect(Collectors.toList());
    }

    @Override
    public void putBalanceDataToDb(List<String[]> toDb) {
        for (String[] string : toDb) {
            if (string[2].equals(SKIP_LINE_IF_CONTAINS)) {
                continue;
            }
            Storage.getFruitsTypeAndAmount().put(string[1], Integer.valueOf(string[2]));
        }
    }
}
