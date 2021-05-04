package core.basesyntax.operationswithfile;

import java.util.List;

public interface FileReader {
    List<Operation> getOperations(String csvFileName);
}
