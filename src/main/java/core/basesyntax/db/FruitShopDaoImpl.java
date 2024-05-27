package core.basesyntax.db;

import core.basesyntax.service.CantWorkWithThisFileException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FruitShopDaoImpl implements FruitShopDao {
    private static final int ACTIVITIES_INDEX = 0;
    private static final int FRUITS_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String FRUIT = "fruit";

    @Override
    public void clearReportFile(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getFromFile(String fromFileName) {
        try {
            return Files.readAllLines(Path.of(fromFileName));
        } catch (IOException e) {
            throw new CantWorkWithThisFileException("Can't read file");
        }

    }

    @Override
    public List<String> getFruits(List<String> fromFile) {
        return fromFile.stream()
                .map(l -> l.split(","))
                .map(a -> a[FRUITS_INDEX])
                .filter(s -> !s.equals(FRUIT))
                .distinct()
                .toList();
    }

    @Override
    public List<String> calculate(List<String> fruitList,
                                  List<String> fromFile,
                                  String activities) {
        List<String> fruitsQuantity = new ArrayList<>();
        for (int i = 0; i < fruitList.size(); i++) {
            String actualFruit = fruitList.get(i);
            int balances = fromFile.stream()
                    .filter(a -> a.contains(actualFruit))
                    .filter(a -> FruitShopDaoImpl.correctActivity(a, activities))
                    .mapToInt(this::getFromCsvRow)
                    .sum();
            fruitsQuantity.add(String.valueOf(balances));
        }
        return fruitsQuantity;
    }

    private static boolean correctActivity(String a, String activities) {
        String[] strings = a.trim().split(",");
        return strings[ACTIVITIES_INDEX].equals(activities);
    }

    private int getFromCsvRow(String line) {
        String[] fields = line.split(",");
        return Integer.valueOf(fields[AMOUNT_INDEX]);
    }

    @Override
    public void reportFruitsToNewFile(List<String> fruits,
                                      List<Integer> fruitAmount,
                                      String toFileName) {
        File finalFile = new File(toFileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(finalFile, true))) {
            writer.write("fruit,quantity");
        } catch (IOException e) {
            throw new CantWorkWithThisFileException("You can't edit this file");
        }
        for (int i = 0; i < fruits.size(); i++) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(finalFile, true))) {
                writer.write(System.lineSeparator() + fruits.get(i) + "," + fruitAmount.get(i));
            } catch (IOException e) {
                throw new CantWorkWithThisFileException("You can't edit this file");
            }
        }
    }
}
