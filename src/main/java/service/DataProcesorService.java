package service;

import java.util.List;
import model.FruitTransaction;

public interface DataProcesorService {
    /**
     * Process data from CSV-file.
     *
     * @param inputLines list of lines from  CSV- file.
     */

    void process(List<String> inputLines);
    /**
     * Process data from CSV-file.
     *
     * @param line list of lines from  CSV- file.
     */

    FruitTransaction parseTransaction(String line);
}
