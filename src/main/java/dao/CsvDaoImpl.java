package dao;

import static db.StorageTransaction.fruitTransactionList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import service.impl.PositiveBalanceCheck;

public class CsvDaoImpl implements CsvDao {
    @Override
    public List<String> readFromFile(String filename) {
        List<String> dataFromFile;
        try {
            dataFromFile = Files.readAllLines(Path.of(filename));
        } catch (Exception e) {
            throw new RuntimeException("Can`t read from file " + filename, e);
        }
        return dataFromFile;
    }

    @Override //              TODO positive balance check !!!
    public void writeToFile(Map<String, Integer> fruitTotalBalanceMap, String toFileName) {
        if (!PositiveBalanceCheck.check(fruitTotalBalanceMap)) {
            throw new RuntimeException("The fruit storage balance is negative!");
        }
        Field[] fields = fruitTransactionList.get(1).getClass().getDeclaredFields();
        String column0Name = fields[1].getName();
        String column1Name = fields[2].getName();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(toFileName, false))) {
            writer.write(column0Name + "," + column1Name);
            for (Map.Entry<String, Integer> entry : fruitTotalBalanceMap.entrySet()) {
                writer.write(System.lineSeparator() + entry.getKey() + "," + entry.getValue());
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't write the file", e);
        }
    }
}
