package fruitshop.service.serviceimpl;

import fruitshop.model.DataLine;
import fruitshop.model.Operation;
import fruitshop.service.Parser;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ParserImpl implements Parser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<DataLine> parseStringToDataObject(List<String> stringList) {
        List<DataLine> dataLineList = new ArrayList<>();
        IntStream.range(1, stringList.size())
                .forEach(i -> {
                    String[] data = stringList.get(i).split(SEPARATOR);
                    dataLineList.add(new DataLine(parseStringToOperation(data[OPERATION_INDEX]),
                            data[FRUIT_INDEX], Integer.parseInt(data[AMOUNT_INDEX])));
                });
        return dataLineList;

    }

    private Operation parseStringToOperation(String letter) {
        switch (letter) {
            case "b": return Operation.BALANCE;
            case "r": return Operation.RETURN;
            case "p": return Operation.PURCHASE;
            case "s": return Operation.SUPPLY;
            default: throw new RuntimeException("not appropriate symbol for operation");
        }
    }
}
