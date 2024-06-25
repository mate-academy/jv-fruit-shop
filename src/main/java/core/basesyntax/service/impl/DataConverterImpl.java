package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SPLIT_SYMBOL = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int SKIP_TITLE_LINE = 1;
    private static final int NUMBER_OF_COLUMNS = 3;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> convertedList = new ArrayList<>();
        for (int i = SKIP_TITLE_LINE; i < inputReport.size(); i++) {
            String[] data = inputReport.get(i).split(SPLIT_SYMBOL);
            int quantity;
            if (data.length != NUMBER_OF_COLUMNS) {
                throw new RuntimeException("The data in file don't separate by comma");
            }
            try {
                quantity = Integer.parseInt(data[QUANTITY_INDEX]);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Quantity data is not valid. Actual: "
                        + data[QUANTITY_INDEX], e);
            }
            convertedList.add(
                    new FruitTransaction(Operation.getValueFromCode(data[OPERATION_INDEX]),
                    data[FRUIT_NAME_INDEX],
                    quantity));
        }
        return convertedList;
    }
}
