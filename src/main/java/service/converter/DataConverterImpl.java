package service.converter;

import static model.FruitTransaction.Operation.findEnumValue;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;

public class DataConverterImpl implements DataConverter {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int HEADER_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransactionList(List<String> inputReport) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        inputReport.remove(HEADER_INDEX);

        for (String input : inputReport) {
            try {
                FruitTransaction fruitTransaction = new FruitTransaction();
                String[] inputSplitter = input.split(SEPARATOR);
                fruitTransaction.setOperation(findEnumValue(inputSplitter[OPERATION_INDEX]));
                fruitTransaction.setFruit(inputSplitter[FRUIT_INDEX]);
                fruitTransaction.setQuantity(Integer.parseInt(inputSplitter[QUANTITY_INDEX]));
                fruitTransactionList.add(fruitTransaction);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid format input ", e);
            }
        }

        return fruitTransactionList;
    }
}
