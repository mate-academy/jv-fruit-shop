package core.basesyntax.service;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
    public List<String> readFromFile(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + fileName);
        }
    }

    @Override
    public void packToStorage(List<String> data) {
        data.stream()
                .map(this::getFromCsvRow)
                .peek(new FileDataValidator())
                .forEach(this::performOperations);
    }

    private Operation getFromCsvRow(String line) {
        String[] fields = line.split(",");
        Operation operation = new Operation();
        try {
            operation.setType(fields[0]);
            operation.setFruitName(fields[1]);
            operation.setQuantity(Long.parseLong(fields[2]));
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

        long calculation = operationStrategy.get(operation.getType())
                .perform(fruit, operation.getQuantity());

        fruit.setQuantity(calculation);
        fruitStorageDao.update(fruit);
    }
}
