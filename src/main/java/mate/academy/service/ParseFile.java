package mate.academy.service;

import java.util.List;
import mate.academy.model.FruitTransaction;

public interface ParseFile {
    List<FruitTransaction> parseFile(List<String> records);
}
