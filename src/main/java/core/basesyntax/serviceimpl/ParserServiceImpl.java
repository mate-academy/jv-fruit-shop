package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationName;
import core.basesyntax.service.ParserService;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    public static final int AMOUNT = 2;
    public static final int CODE = 0;
    public static final int FRUIT = 1;
    private final String separator;

    public ParserServiceImpl(String separator) {
        this.separator = separator;
    }

    @Override
    public List<FruitTransaction> parseOperations(List<String> lines) {
        return lines.stream()
                .map(line -> {
                    String[] splitted = line.split(separator);
                    if (Integer.parseInt(splitted[AMOUNT]) < 0) {
                        throw new IllegalArgumentException("You can't add negative "
                                + "amount of products!");
                    }
                    return new FruitTransaction(OperationName.getByCode(splitted[CODE]),
                            splitted[FRUIT],
                            Integer.parseInt(splitted[AMOUNT]));
                })
                .toList();
    }
}
