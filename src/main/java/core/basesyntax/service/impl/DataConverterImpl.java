package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.utility.OperationHandlerSwitch;
import core.basesyntax.utility.impl.OperationHandlerSwitchImpl;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransactions(List<String> csvLines) {
        List<String> csvLinesCopy = csvLines;
        csvLinesCopy.remove(0);
        OperationHandlerSwitch operationHandlerSwitch = new OperationHandlerSwitchImpl();
        List<FruitTransaction> listOfTransactions = new ArrayList<>();
        for (int i = 0; i < csvLinesCopy.size(); i++) {
            String type = getType(csvLinesCopy, i);
            String fruit = getFruit(csvLinesCopy, i);
            int quantity = getQuantity(csvLinesCopy, i);
            listOfTransactions.add(new FruitTransaction(operationHandlerSwitch
                    .getOperation(type.trim()), fruit, quantity));
        }
        return listOfTransactions;
    }

    public String getType(List<String> csvLines, int index) {
        return csvLines.get(index).substring(0, csvLines.get(index).indexOf(","));
    }

    public String getFruit(List<String> csvLines, int index) {
        return csvLines.get(index)
                .substring(csvLines.get(index).indexOf(",") + 1,
                        csvLines.get(index).lastIndexOf(","));
    }

    public int getQuantity(List<String> csvLines, int index) {
        int quantity;
        try {
            quantity = Integer.parseInt(csvLines.get(index)
                    .substring(csvLines.get(index)
                            .lastIndexOf(",") + 1));
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
        if (quantity < 0) {
            throw new RuntimeException("Quantity cannot be less than 0, actual quantity: "
                    + quantity);
        }
        return quantity;
    }
}

