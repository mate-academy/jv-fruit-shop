package serviceimpl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final int FRUIT_NAME = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(this::getFruitTransaction)
                .collect(Collectors.toList());
    }

    public FruitTransaction getFruitTransaction(String line) {
        String[] splittedLine = line.split(SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getOperationByLetter(splittedLine[FRUIT_NAME]));
        fruitTransaction.setFruit(splittedLine[FRUIT_NAME_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(splittedLine[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
