package fruitshop.service;

import fruitshop.model.FruitTransaction;
import java.util.List;

public interface ParseText {
    List<FruitTransaction> parseReport(ReadReport report);
}
