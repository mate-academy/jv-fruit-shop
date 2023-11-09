package core.basesyntax.service;

import java.util.List;

public interface DataReader<T> {

    List<T> dataFromFile();
}
