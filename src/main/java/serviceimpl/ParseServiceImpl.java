package serviceimpl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ParseService;

public class ParseServiceImpl implements ParseService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseService(List<String> dataList) {
        return dataList.stream()
                .skip(1)
                .map(this::getDataList)
                .collect(Collectors.toList());
    }

    private FruitTransaction getDataList(String dataList) {
        String[] dateParse = dataList.split(SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getOperationByLetter(dateParse[OPERATION_INDEX]));
        fruitTransaction.setFruit(dateParse[FRUIT_NAME]);
        fruitTransaction.setQuantity(Integer.parseInt(dateParse[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
