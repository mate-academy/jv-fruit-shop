package core.basesyntax.Imp;

import core.basesyntax.Service.CustomFileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CustomFileReadImp implements CustomFileReader {
    @Override
    public List<String> readFromFile(String nameFile) {
        FruitParseDtoParseImp fruitRecordImp = new FruitParseDtoParseImp();
        LinkedList<String> linkedList = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nameFile))) {
            String value = reader.readLine();
            while (value != null) {
                linkedList.add(value);
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        linkedList.remove(0);
        fruitRecordImp.parse(linkedList);
        return linkedList;
    }
}
