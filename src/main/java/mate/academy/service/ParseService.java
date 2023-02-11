package mate.academy.service;

import java.util.List;
import mate.academy.model.FruitTransaction;

public interface ParseService {
    List<FruitTransaction> parse(List<String> lines);
}
