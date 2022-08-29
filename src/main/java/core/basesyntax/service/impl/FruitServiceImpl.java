package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.Reader;
import core.basesyntax.service.Writer;
import core.basesyntax.strategy.AmountStrategy;
import java.util.List;
import java.util.Optional;

public class FruitServiceImpl implements FruitService {
    private static final String DIVIDER = ",";
    private static final String HEADER = "fruit,quantity" + System.lineSeparator();
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int STARTING_AMOUNT = 0;
    private final AmountStrategy strategy;
    private final FruitDao fruitDao;
    private final Reader reader;
    private final Writer writer;

    public FruitServiceImpl(AmountStrategy strategy, FruitDao fruitDao,
                            Reader reader, Writer writer) {
        this.strategy = strategy;
        this.fruitDao = fruitDao;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void processData(String inputFile, String outputFile) {
        List<String> inputFruits = reader.readFromFile(inputFile);
        StringBuilder report = new StringBuilder(HEADER);
        for (int i = 1; i < inputFruits.size(); i++) {
            String[] fruitIncoming = inputFruits.get(i).split(DIVIDER);
            String operation = fruitIncoming[OPERATION_INDEX];
            String fruitName = fruitIncoming[NAME_INDEX];
            int fruitAmount = Integer.parseInt(fruitIncoming[AMOUNT_INDEX]);
            Optional<Fruit> fruitOptional = fruitDao.getByName(fruitName);
            Fruit fruit;
            if (fruitOptional.isPresent()) {
                fruit = fruitOptional.get();
            } else {
                fruit = new Fruit(fruitName, STARTING_AMOUNT);
                fruitDao.add(fruit);
            }
            fruit.setAmount(strategy.get(operation).changeAmount(fruit, fruitAmount));
        }
        for (Fruit fruitLine : Storage.fruits) {
            report.append(fruitLine.getName())
                    .append(DIVIDER)
                    .append(fruitLine.getAmount())
                    .append(System.lineSeparator());
        }
        writer.writeToFile(report.toString(), outputFile);
    }
}
