package service;

import java.util.List;

public interface DataProcessorService {
    /**
     * Process data from CSV-file.
     *
     * @param inputLines list of lines from  CSV- file.
     */

    void process(List<String> inputLines);
}
