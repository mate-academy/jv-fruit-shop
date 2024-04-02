package servece.impl;

import model.FruitTransaction;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.DataReaderService;

public class DataReaderServiceImpl implements DataReaderService {
    private static final int OPERATION_PART = 0;
    private static final int FRUIT_PART = 1;
    private static final int QUANTITY_PART = 2;

    @Override
    public List<FruitTransaction> readDataInFile(String filePath) {
        List<FruitTransaction> transaktion = new ArrayList<>();
        File file = new File(filePath);
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();
            while (value != null) {
                String[] current = value.split(",");
                FruitTransaction fruitTransaction =
                        new FruitTransaction(
                                FruitTransaction.fromCode(current[OPERATION_PART]),
                                current[FRUIT_PART],
                                Integer.parseInt(current[QUANTITY_PART]));
                transaktion.add(fruitTransaction);
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not read file : " + e);
        }
        return transaktion;

    }
}
