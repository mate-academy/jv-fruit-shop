package core.basesyntax.service;

import java.util.List;

public interface Parser <T>{
    List<T> parseCsvFile(List<String> inputData);
}
