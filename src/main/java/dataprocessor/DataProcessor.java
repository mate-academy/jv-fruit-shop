package dataprocessor;

import java.util.List;

public interface DataProcessor {
    List<String[]> processData(List<String[]> records);

}
