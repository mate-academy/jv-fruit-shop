package core.basesyntax.dao;

import java.util.List;

public interface DataDao {
    
    boolean contains(List<String> dataFromFile);

    void add(List<String> dataFromFile);

    List<String> getData();

    void update(List<String> formattedData);
}
