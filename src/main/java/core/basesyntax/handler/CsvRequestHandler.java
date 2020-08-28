package core.basesyntax.handler;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toList;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.Action;
import core.basesyntax.service.FruitService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CsvRequestHandler implements RequestHandler {

    private FileProcessor fileProcessor;
    private FruitService fruitService;
    private Map<String, Action> operations = new HashMap<>();

    public CsvRequestHandler(FileProcessor fileProcessor, FruitService fruitService) {
        this.fileProcessor = fileProcessor;
        this.fruitService = fruitService;

        operations.put("s", r -> IntStream.range(0, r.getQuantity())
                .forEach(i -> fruitService.add(r.getFruit())));
        operations.put("b", r -> fruitService
                .sell(r.getFruit().getName(), r.getFruit().getExpirationDate(), r.getQuantity()));
        operations.put("r", r -> IntStream.range(0, r.getQuantity())
                .forEach(i -> fruitService.add(r.getFruit())));
    }

    @Override
    public String handle(String fileName) {
        fileProcessor.read(fileName)
                .forEach(r -> this.operations.get(r.getActionType()).execute(r));

        List<Fruit> allFruits = fruitService.getAll();
        return fileProcessor.write(buildCsvRow(allFruits));
    }

    private List<String> buildCsvRow(List<Fruit> fruits) {
        return fruits.stream()
                .collect(Collectors.groupingBy(Fruit::getName, counting()))
                .entrySet().stream()
                .map(e -> String.format("%s,%d", e.getKey(), e.getValue()))
                .collect(toList());
    }
}
