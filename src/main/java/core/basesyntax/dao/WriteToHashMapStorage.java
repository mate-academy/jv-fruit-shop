package core.basesyntax.dao;

import core.basesyntax.products.Fruit;
import core.basesyntax.service.HandleCheck;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class WriteToHashMapStorage {

    public void writeToHashMapStorage(String dataString) {
        String[] arrayData = dataString.split(",");
        if (arrayData[0].length() > 1) {
            return;
        }
        arrayData[0] = arrayData[0].substring(0, 1).toLowerCase();
        LocalDate localDate = LocalDate.now();

        try {
            localDate = LocalDate.parse(arrayData[3], DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            System.out.println(arrayData[3] + " Date format error!");
        }
        int amount = Integer.parseInt(arrayData[2]);
        Fruit fruit = new Fruit(arrayData[1], amount, localDate);

        HandleCheck handle = new HandleCheck();
        handle.operationWithProduct(arrayData[0], fruit);
    }
}

