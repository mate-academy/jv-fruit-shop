package core.basesyntax.readwritefile.interfaces;

import java.util.Map;

public interface FileWriter {

    boolean writeCsv(Map<String, Integer> currentBalance, String pathName);
}
