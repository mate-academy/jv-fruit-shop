package core.basesyntax.dao;

import java.util.List;

public interface InputDataReader {
    List<String> getDataFromFile(String filePathFrom);
}
