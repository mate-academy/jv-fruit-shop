package mate.academy.service;

import java.util.List;
import mate.academy.model.FruitTransaction;

public interface ParseFromString {
    List<FruitTransaction> parse(List<String> lines);
}
