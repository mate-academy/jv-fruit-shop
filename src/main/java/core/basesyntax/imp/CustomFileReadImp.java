package core.basesyntax.imp;

import core.basesyntax.service.CustomFileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CustomFileReadImp implements CustomFileReader {
    @Override
    public List<String> readFromFile(String fileName) {
        FruitParseDtoParseImp fruitRecordImp = new FruitParseDtoParseImp();
        LinkedList<String> linkedList = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value;
            while ((value = reader.readLine()) != null) {
                linkedList.add(value);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        linkedList.remove(0);
        fruitRecordImp.parse(linkedList);
        return linkedList;
    }
}
