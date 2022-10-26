package core.basesyntax;

import java.util.List;

public interface FruitTransaction {

    List<String> getDayData();

    void processData(List<String> data);

    String generateReport();

    void writeData(String report);
}
