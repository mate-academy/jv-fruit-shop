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
        List<String> csvLinesCopy = new ArrayList<>(csvLines);
        csvLinesCopy.remove(0);
        OperationHandlerSwitch operationHandlerSwitch = new OperationHandlerSwitchImpl();
        List<FruitTransaction> listOfTransactions = new ArrayList<>();
        for (String csvLine : csvLinesCopy) {
            String[] parts = csvLine.split(",");
            if (parts.length != 3) {
                throw new IllegalArgumentException("CSV line format is incorrect: " + csvLine);
            }
            String type = parts[0].trim();
            String fruit = parts[1].trim();
            int quantity = parseQuantity(parts[2].trim(), csvLine);

            listOfTransactions.add(new FruitTransaction(
                    operationHandlerSwitch.getOperation(type), fruit, quantity));
        }
        return listOfTransactions;
    }

    private int parseQuantity(String quantityStr, String csvLine) {
        if (Integer.parseInt(quantityStr) < 0) {
            throw new IllegalArgumentException("Quantity cannot be less than 0, "
                    + "actual quantity: " + Integer.parseInt(quantityStr));
        }
        int quantity;
        try {
            quantity = Integer.parseInt(quantityStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid quantity value in line: " + csvLine, e);
        }
        return quantity;
    }
}
