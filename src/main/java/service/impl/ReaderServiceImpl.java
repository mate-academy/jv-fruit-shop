package service.impl;

import dao.DatabaseDao;
import dao.DatabaseDaoImpl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import model.FruitTransaction;
import model.Operation;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    private static final String SPLIT_SYMBOL = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final DatabaseDao dao = new DatabaseDaoImpl();

    @Override
    public void read(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] splittedData = line.split(SPLIT_SYMBOL);
                dao.addTransaction(
                        new FruitTransaction(Operation.getByValue(splittedData[OPERATION_INDEX]),
                                splittedData[FRUIT_INDEX],
                                Integer.parseInt(splittedData[QUANTITY_INDEX])));
            }
            System.out.println("File read!");
        } catch (IOException e) {
            throw new RuntimeException("Can't find a file");
        }
    }
}
