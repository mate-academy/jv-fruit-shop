package service.impl;

import db.Storage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import model.Fruit;
import model.Operation;
import service.Reader;

public class ReaderImpl implements Reader {

    public static final int INDEX_OF_OPERATION = 0;
    public static final int INDEX_OF_NAME = 1;
    public static final int INDEX_OF_AMONG = 2;

    @Override
    public List<Fruit> readerData(String fileName) {
        
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                String[] string = line.split(",");
                try {
                    Integer.parseInt(string[INDEX_OF_AMONG]);
                } catch (NumberFormatException e) {
                    continue;
                }
                Storage.fruits.add(new Fruit(string[INDEX_OF_NAME],
                        string[INDEX_OF_OPERATION].equals((Operation.PURCHASE).getOperation())
                        ? (Integer.parseInt((string[INDEX_OF_AMONG])) * (-1))
                        : Integer.parseInt(string[INDEX_OF_AMONG])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file " + fileName);
        }
        return Storage.fruits;
    }

}
