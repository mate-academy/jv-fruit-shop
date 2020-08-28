package core.basesyntax.service;

import core.basesyntax.Transaction;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ConverterCsvToTransaction {
    public Transaction convert(List<String> data) {
        Transaction fruitDto = new Transaction();
        fruitDto.setOperation(data.get(0));
        fruitDto.setFruitName(data.get(1));
        fruitDto.setQuantity(Integer.parseInt(data.get(2)));
        fruitDto.setDate(LocalDate.parse(data.get(3), DateTimeFormatter.ISO_LOCAL_DATE));

        return fruitDto;
    }
}
