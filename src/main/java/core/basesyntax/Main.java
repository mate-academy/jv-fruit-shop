package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReadFromCsvFileService;
import core.basesyntax.service.impl.ReadFromCsvFileServiceImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ReadFromCsvFileService reader = new ReadFromCsvFileServiceImpl();
        reader.readFile("fruits.csv");
        System.out.println(Arrays.toString(reader.readFile("fruits.csv").toArray()));
    }
}
