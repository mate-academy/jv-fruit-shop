package service.converter;

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
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        inputReport.remove(HEADER_INDEX);

        for (String input : inputReport) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] inputSplitter = input.split(SEPARATOR);
            fruitTransaction.setOperation(
                    fruitTransaction.getOperation().findEnumValue(inputSplitter[OPERATION_INDEX]));
            fruitTransaction.setFruit(inputSplitter[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(inputSplitter[QUANTITY_INDEX]));
            fruitTransactionList.add(fruitTransaction);
        }

        return fruitTransactionList;
    }
}
