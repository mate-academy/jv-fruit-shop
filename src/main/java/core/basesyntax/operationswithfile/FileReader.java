package core.basesyntax.operationswithfile;

import java.util.List;

public interface FileReader {
    List<Transaction> getOperations(String csvFileName);
}
