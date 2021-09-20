package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FruitShop {
    final static String FILE_PATH = "src/inputexample.csv";
    final static String CSV_FIELDS_NAMES = "type,fruit,quantity";

    private String getRecordsFromFile(String filePath) {
        File myFile = new File(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t find file", e);
        }
        return stringBuilder.toString().replace(CSV_FIELDS_NAMES,"").replace("\r","").trim();


    }

    public static void main(String[] args) {

        FruitShop fruitShop = new FruitShop();
        String recordsAsString = fruitShop.getRecordsFromFile(FILE_PATH);
        RecordParser recordParser = new RecordParser();
        List<Record> recordList = recordParser.parseRecords(recordsAsString);
        for (Record r : recordList) {
            System.out.println(r.getFruit());
            System.out.println(r.getActivity());
            System.out.println(r.getAmount());
        }
    }

}
