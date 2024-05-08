package service;

import exception.FruitShopException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitTransaction;

public class FruitShopServiceImpl implements FruitShopService {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final String REPORT_ANNOTATION = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public List<String> fileReader(String filePath) {
        List<String> dataFromFile;
        Path path = Paths.get(filePath);
        try {
            dataFromFile = Files.lines(path)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new FruitShopException("Can't read data from file" + filePath);
        }
        return dataFromFile;
    }

    @Override
    public void fileWriter(List<String> statistic, String filePath) {
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                boolean created = file.createNewFile();
                if (!created) {
                    throw new FruitShopException("Can't create file:" + filePath);
                }
            }
            try (FileOutputStream fos = new FileOutputStream(filePath);
                    BufferedOutputStream bos = new BufferedOutputStream(fos)) {
                for (String fruitQuantity : statistic) {
                    bos.write((fruitQuantity + System.lineSeparator()).getBytes());
                }
            }
            System.out.println("Data written to file " + filePath + " successfully!");
        } catch (IOException e) {
            throw new FruitShopException("Can't write to file:" + filePath);
        }
    }

    @Override
    public FruitTransaction parseStringToTransaction(String inputString) {
        String[] data = inputString.split(SEPARATOR);
        if (data.length != 3) {
            throw new FruitShopException("Can't parse data from file");
        }
        return new FruitTransaction(data[OPERATION], data[FRUIT], data[QUANTITY]);
    }

    @Override
    public List<String> parseStatisticToString(Map<String, Integer> statistic) {
        List<String> finalFile = new ArrayList<>();
        finalFile.add(REPORT_ANNOTATION);

        List<String> statisticToString = statistic.entrySet().stream()
                .peek(kv -> {
                    if (kv.getValue() < 0) {
                        throw new RuntimeException("Balance is negative");
                    }
                })
                .map(kv -> kv.getKey() + SEPARATOR + kv.getValue())
                .collect(Collectors.toList());
        finalFile.addAll(statisticToString);
        return finalFile;
    }
}
