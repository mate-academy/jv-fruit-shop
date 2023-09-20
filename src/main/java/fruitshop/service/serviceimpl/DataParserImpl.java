package fruitshop.service.serviceimpl;

import fruitshop.model.FruitTransaction;
import fruitshop.model.Operation;
import fruitshop.service.DataParser;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DataParserImpl implements DataParser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parseStringToDataObject(List<String> stringList) {
        List<FruitTransaction> dataLineList = new ArrayList<>();
        IntStream.range(1, stringList.size())
                .forEach(i -> {
                    String[] data = stringList.get(i).split(SEPARATOR);
                    dataLineList
                            .add(new FruitTransaction(Operation.getOperation(data[OPERATION_INDEX]),
                            data[FRUIT_INDEX], Integer.parseInt(data[AMOUNT_INDEX])));
                });
        return dataLineList;

    }
}
