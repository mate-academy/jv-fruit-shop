package core.basesyntax.countingoperations;

import core.basesyntax.operationswithfile.Operation;
import java.util.ArrayList;
import java.util.HashMap;

public interface CountOperation {
    HashMap<String, Integer> getCount(HashMap<String, Integer> balance,
                                      ArrayList<Operation> operationArrayList);
}
