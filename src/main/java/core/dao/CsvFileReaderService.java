package core.dao;

import core.model.Operations;
import core.service.ActivitiesStrategy;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReaderService implements FileReaderService {
    private static final int ACTIVITY_TYPE = 0;
    private static final int FRUIT_TYPE = 1;
    private static final int AMOUNT_OF_FRUITS = 2;
    private final ActivitiesStrategy activitiesStrategy;
    private final FruitsDao fruitsDao;

    public CsvFileReaderService(ActivitiesStrategy activitiesStrategy) {
        this.activitiesStrategy = activitiesStrategy;
        fruitsDao = new FruitsDaoImpl();
    }

    @Override
    public void getData(String fileName) {
        try (BufferedReader readFile = new BufferedReader(new FileReader(fileName))) {
            readFile.readLine();
            String lineText;
            while ((lineText = readFile.readLine()) != null) {
                String[] line = lineText.split(",");
                int fruitsInShop = fruitsDao.get(line[FRUIT_TYPE]);
                int operationAmount = Integer.parseInt(line[AMOUNT_OF_FRUITS]);
                if (operationAmount < 0) {
                    throw new RuntimeException("Incorrect value of operation: "
                            + Integer.parseInt(line[AMOUNT_OF_FRUITS]));
                }
                fruitsDao.add(line[FRUIT_TYPE], activitiesStrategy.get(Operations
                        .operationFromString(line[ACTIVITY_TYPE]))
                        .calculateAmount(fruitsInShop, operationAmount));
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found - " + fileName, e);
        }
    }
}
