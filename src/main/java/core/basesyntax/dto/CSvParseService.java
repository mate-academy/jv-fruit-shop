package core.basesyntax.dto;

import core.basesyntax.models.Fruit;
import core.basesyntax.models.FruitRecord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CSvParseService implements ParseService {
    private static final String RECORD_SEPARATOR = "\r\n";
    private static final String DATA_SEPARATOR = ",";
    ;
    private static final int APPEND_TO_REMOVE_TITLE = 3;

    @Override
    public List<FruitRecord> convertStringDataIntoFruitRecordList(String datInString) {
        List<FruitRecord> listOfRecords = new ArrayList<>();
        datInString = datInString.substring(datInString.indexOf(RECORD_SEPARATOR) + APPEND_TO_REMOVE_TITLE);
        String[] arrOfRecords = datInString.split(RECORD_SEPARATOR);
        listOfRecords = Arrays.stream(arrOfRecords)
                .map(String::trim)
                .map(this::convertRecordIntoFruitRecord)
                .collect(Collectors.toList());
        return listOfRecords;
    }

    private FruitRecord convertRecordIntoFruitRecord(String recordInString) {
        String[] dataInArray = recordInString.split(DATA_SEPARATOR);
        char typeOfOperation = dataInArray[0].charAt(0);
        String nameOfFruit = dataInArray[1];
        int amountOfFruits = Integer.parseInt(dataInArray[2]);
        return new FruitRecord(typeOfOperation, nameOfFruit, amountOfFruits);
    }

    @Override
    public String convertStorageDataIntoWritableString(Set<Fruit> datInString) {
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
