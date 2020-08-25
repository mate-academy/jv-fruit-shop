package core.basesyntax.processing;

import core.basesyntax.model.Apple;
import core.basesyntax.model.Banana;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Orange;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.StorageServiceImpl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CsvStrategyImpl implements CsvStrategy {
    private int bananaCount;
    private int appleCount;
    private int orangeCount;

    CsvStrategyImpl() {
        bananaCount = 0;
        appleCount = 0;
        orangeCount = 0;
    }

    @Override
    public boolean countFruit(Fruit fruit) {
        if (fruit.getClass().equals(Banana.class)) {
            bananaCount++;
            return true;
        } else if (fruit.getClass().equals(Apple.class)) {
            appleCount++;
            return true;
        } else if (fruit.getClass().equals(Orange.class)) {
            orangeCount++;
            return true;
        }
        return false;
    }

    @Override
    public boolean chooseOperation(String[] operation) {
        StorageService storageService = new StorageServiceImpl();
        switch (operation[0].trim()) {
            case "type":
                return true;
            case "s":
                storageService.supplyFruit(operation[1], Integer.parseInt(operation[2]),
                        LocalDate.parse(operation[3]));
                return true;
            case "b":
                storageService.buyFruit(operation[1], Integer.parseInt(operation[2]),
                        LocalDate.parse(operation[3]));
                return true;
            case "r":
                storageService.returnFruit(operation[1], Integer.parseInt(operation[2]),
                        LocalDate.parse(operation[3]));
                return true;
            default:
                throw new RuntimeException("Uncorrected operation");
        }
    }

    @Override
    public List<String[]> reportStrategy() {
        List<String[]> report = new ArrayList<>();
        report.add(new String[]{"fruit", "quantity"});
        report.add(new String[]{"banana", String.valueOf(bananaCount)});
        report.add(new String[]{"apple", String.valueOf(appleCount)});
        report.add(new String[]{"orange", String.valueOf(orangeCount)});
        return report;
    }
}
