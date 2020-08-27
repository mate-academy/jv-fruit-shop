package core.basesyntax.readWriteFile.interfaces;

import java.util.Map;

public interface IWriteCSV {

    boolean writeCSV(Map<String, Integer> currentBalance, String pathName);
}
