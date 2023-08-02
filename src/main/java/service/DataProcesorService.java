package service;

import model.*;

import java.util.*;

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
