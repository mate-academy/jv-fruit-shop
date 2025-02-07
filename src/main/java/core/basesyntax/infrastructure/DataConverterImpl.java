package core.basesyntax.infrastructure;

import core.basesyntax.service.FruitTransaction;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return inputReport.stream()
                .map(s -> s.split(SEPARATOR))
                .filter(s -> s.length == 3 && isNumeric(s[2])) // Перевіряємо довжину та чи є число
                .map(s -> new FruitTransaction(
                        FruitTransaction.getOperation(s[0]), s[1], Integer.parseInt(s[2])))
                .toList();
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
