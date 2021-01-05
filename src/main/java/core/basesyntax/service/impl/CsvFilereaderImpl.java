package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static core.basesyntax.model.Operation.fromString;

public class CsvFilereaderImpl implements Filereader {
    public static final int OPERATION = 0;
    public static final int FRUIT = 1;
    public static final int QUANTITY = 2;

    @Override
    public List<TransactionDto> readFile(String fileName) {
        StringBuilder report = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                report.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file - " + fileName, e);
        }
        String[] valuesReport = report.toString().split(System.lineSeparator());
        List<TransactionDto> dataFromFile = new ArrayList<>();
        for(String value: valuesReport) {
            String[] splittedData =  value.split(",");
            dataFromFile.add(new TransactionDto(fromString(splittedData[OPERATION]),
                    new Fruit(splittedData[FRUIT]) ,Integer.valueOf(splittedData[QUANTITY])));
        }

        return dataFromFile;
    }
}
