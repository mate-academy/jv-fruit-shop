package core.basesyntax.readwritefile.interfaces;

import java.util.Map;

public interface IWriteCsv {

    boolean writeCsv(Map<String, Integer> currentBalance, String pathName);
}
