package services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import model.Fruit;
import model.FruitRecord;
import services.ParseService;

public class ParseServiceImpl implements ParseService {
    private static final String DATA_SEPARATOR = ",";
    private static final int APPEND_TO_REMOVE_TITLE = 2;

    @Override
    public List<FruitRecord> parseFromCsv(String dataInString) {
        List<FruitRecord> listOfRecords;
        dataInString = dataInString.substring(dataInString.indexOf(System.lineSeparator())
                + APPEND_TO_REMOVE_TITLE);
        String[] arrOfRecords = dataInString.split(System.lineSeparator());
        return Arrays.stream(arrOfRecords)
                .map(String::trim)
                .map(this::parseIntoFruitRecord)
                .collect(Collectors.toList());
    }

    private FruitRecord parseIntoFruitRecord(String recordInString) {
        String[] dataInArray = recordInString.split(DATA_SEPARATOR);
        char typeOfOperation = dataInArray[0].charAt(0);
        String nameOfFruit = dataInArray[1];
        int amountOfFruits = Integer.parseInt(dataInArray[2]);
        return new FruitRecord(typeOfOperation, nameOfFruit, amountOfFruits);
    }

    @Override
    public String parseToString(Set<Fruit> fruitSet) {
        StringBuilder stringBuilderOfOutPutData = new StringBuilder();
        for (Fruit fruit : fruitSet) {
            stringBuilderOfOutPutData.append(fruit.getName());
            stringBuilderOfOutPutData.append(DATA_SEPARATOR);
            stringBuilderOfOutPutData.append(fruit.getAmount());
            stringBuilderOfOutPutData.append(System.lineSeparator());
        }
        return stringBuilderOfOutPutData.toString().trim();
    }
}
