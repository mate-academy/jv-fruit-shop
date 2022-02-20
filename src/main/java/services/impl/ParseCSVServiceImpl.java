package services.impl;

import model.Fruit;
import model.FruitRecord;
import services.ParseCSVService;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ParseCSVServiceImpl implements ParseCSVService {
    private static final String RECORD_SEPARATOR = "\r\n";
    private static final String DATA_SEPARATOR = ",";
    private static final int APPEND_TO_REMOVE_TITLE = 2;

    @Override
    public List<FruitRecord> parseFromCsv(String datInString) {
        List<FruitRecord> listOfRecords;
        datInString = datInString.substring(datInString.indexOf(RECORD_SEPARATOR)
                + APPEND_TO_REMOVE_TITLE);
        String[] arrOfRecords = datInString.split(RECORD_SEPARATOR);
        listOfRecords = Arrays.stream(arrOfRecords)
                .map(String::trim)
                .map(this::parseIntoFruitRecord)
                .collect(Collectors.toList());
        return listOfRecords;
    }

    private FruitRecord parseIntoFruitRecord(String recordInString) {
        String[] dataInArray = recordInString.split(DATA_SEPARATOR);
        char typeOfOperation = dataInArray[0].charAt(0);
        String nameOfFruit = dataInArray[1];
        int amountOfFruits = Integer.parseInt(dataInArray[2]);
        return new FruitRecord(typeOfOperation, nameOfFruit, amountOfFruits);
    }

    @Override
    public String parseIntoCsv(Set<Fruit> datInString) {
        StringBuilder stringBuilderOfOutPutData = new StringBuilder();
        for (Fruit fruit : datInString) {
            stringBuilderOfOutPutData.append(fruit.getName());
            stringBuilderOfOutPutData.append(DATA_SEPARATOR);
            stringBuilderOfOutPutData.append(fruit.getAmount());
            stringBuilderOfOutPutData.append(RECORD_SEPARATOR);
        }
        return stringBuilderOfOutPutData.toString().trim();
    }
}
