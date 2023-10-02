package core.service.impl;

import java.util.List;

public interface SplitDataService<T> {
    List<T> splitData(String data);
}
