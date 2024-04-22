package service.impl;

import dao.FruitDao;
import dao.FruitDaoImpl;
import exception.CheckSplitLine;
import exception.CheckSplitLineImpl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import model.Fruit;
import service.GetFruitFromFile;
import service.GetValueForFruit;
import service.WriteToStorage;

public class WriteToStorageImpl implements WriteToStorage {
    private static final int FRUIT_INDEX = 1;

    private final FruitDao fruitDao = new FruitDaoImpl();
    private final GetFruitFromFile getFruitFromFile = new GetFruitFromFileImpl();
    private final GetValueForFruit getValueForFruit = new GetValueForFruitImpl();
    private final CheckSplitLine checkSplitLine = new CheckSplitLineImpl();

    @Override
    public void writeToDataBase(String fromFileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fromFileName))) {
            String line;
            br.readLine();//skipping first line with "columns" description
            while ((line = br.readLine()) != null) {
                String[] splitLine = checkSplitLine.checkAndGetLine(line);
                Fruit fruit = getFruitFromFile.getFruit(splitLine[FRUIT_INDEX]);
                fruitDao.add(fruit, getValueForFruit.calculateNewValue(line));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file: " + fromFileName, e);
        }
    }
}
