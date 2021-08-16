package core.basesyntax.service;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReaderServiceImpl implements ReaderService {
    private FruitStorageDao fruitStorageDao;
    private OperationStrategy operationStrategy;

    public ReaderServiceImpl(FruitStorageDao fruitStorageDao, OperationStrategy operationStrategy) {
        this.fruitStorageDao = fruitStorageDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void readFromFile(String fileName) {
        List<String> data = new ArrayList<>();
        try {
            data = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + fileName);
        }

        data.stream()
                .map(this::getFromCsvRow)
                .filter(new FileDataValidator())
                .forEach(this::performOperations);
    }

    private Operation getFromCsvRow(String line) {
        String[] fields = line.split(",");
        Operation operation = new Operation();
        try {
            operation.setType(fields[0]);
            operation.setFruitName(fields[1]);
            operation.setQuantity(new BigDecimal(fields[2]));
        } catch (Exception e) {
            throw new RuntimeException("The input file has incorrect data!");
        }
        return operation;
    }

    private void performOperations(Operation operation) {
        Optional<Fruit> fruitOptional = fruitStorageDao.getFruit(operation.getFruitName());
        Fruit fruit;
        if (fruitOptional.isEmpty()) {
            fruit = new Fruit(operation.getFruitName());
        } else {
            fruit = fruitOptional.get();
        }

        BigDecimal calculation = operationStrategy.get(operation.getType())
                .perform(fruit, operation.getQuantity());

        fruit.setQuantity(calculation);
        fruitStorageDao.update(fruit);
    }
}
