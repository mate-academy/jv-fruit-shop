package core.dao;

import core.service.ActivitiesStrategy;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GetDataFromFileCsv implements GetDataFromFile {
    private static final int ACTIVITY_TYPE = 0;
    private static final int FRUIT_TYPE = 1;
    private static final int AMOUNT_OF_FRUITS = 2;
    private final ActivitiesStrategy activitiesStrategy;

    public GetDataFromFileCsv(ActivitiesStrategy activitiesStrategy) {
        this.activitiesStrategy = activitiesStrategy;
    }

    @Override
    public String getData(String fileName) {
        Map<String, Integer> fruits = new LinkedHashMap<>();
        try (BufferedReader readFile = new BufferedReader(new FileReader(fileName))) {
            readFile.readLine();
            String lineText;
            while ((lineText = readFile.readLine()) != null) {
                String[] line = lineText.split(",");
                int fruitsInShop = fruits.get(line[FRUIT_TYPE]) != null
                        ? fruits.get(line[FRUIT_TYPE]) : 0;
                fruits.put(line[FRUIT_TYPE], activitiesStrategy.get(line[ACTIVITY_TYPE])
                        .getAmountOfFruits(fruitsInShop, Integer.parseInt(line[AMOUNT_OF_FRUITS])));
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found - " + fileName, e);
        }
        return fruits.entrySet().stream()
                .map(s -> s.getKey() + "," + s.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
