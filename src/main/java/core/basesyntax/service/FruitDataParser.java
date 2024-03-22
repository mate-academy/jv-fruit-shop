package core.basesyntax.service;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.exeptions.IncorrectDataFileExeption;
import core.basesyntax.service.exeptions.NegativeNumberExeption;
import java.util.ArrayList;
import java.util.List;

public class FruitDataParser implements DataParser<FruitTransactionDto> {
    public static final String SPLITTER = ",";
    public static final int COLUMN_COUNT = 3;
    public static final int MIN_VALUE = 0;
    public static final int QUANTITY_COLUMN_NUMBER = 2;

    public List<FruitTransactionDto> parse(List<String> data) {
        var dtos = new ArrayList<FruitTransactionDto>(data.size());
        for (int i = 1; i < data.size(); i++) {
            String line = data.get(i);
            String[] columns = line.split(SPLITTER);
            if (columns.length < COLUMN_COUNT) {
                throw new IncorrectDataFileExeption("Incorrect file data!");
            }
            if (Integer.parseInt(columns[QUANTITY_COLUMN_NUMBER]) < MIN_VALUE) {
                throw new NegativeNumberExeption("Negative quantity in file!");
            }
            var dto = new FruitTransactionDto(columns[0], columns[1], Integer.parseInt(columns[2]));
            dtos.add(dto);
        }
        return dtos;
    }
}
