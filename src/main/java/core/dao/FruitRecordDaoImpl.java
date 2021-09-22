package core.dao;

import core.db.Storage;
import core.exception.ValidationException;
import core.model.FruitRecord;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordDaoImpl implements FruitRecordDao {
    private static final String PATH_REPORT_INPUT = "src/main/resources/report_input.csv";
    private ValidatorImpl validator = new ValidatorImpl();

    @Override
    public void add(FruitRecord fruitRecord) {
        for (FruitRecord record : Storage.getListFruits()) {
            if (record.getFruit() != null && isPresentInDB(fruitRecord)) {
                int currentAmount = record.getAmount();
                record.setAmount(currentAmount + fruitRecord.getAmount());
                return;
            }
        }
        Storage.getListFruits().add(fruitRecord);
    }

    public boolean isPresentInDB(FruitRecord fruitRecord) {
        for (FruitRecord record : Storage.getListFruits()) {
            if (record != null && record.equals(fruitRecord)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<FruitRecord> parseFruitRecords(List<String> rawRecords) throws ValidationException {
        List<FruitRecord> fruitRecordList = new ArrayList<>();
        for (int i = 0; i < rawRecords.size(); i++) {
            fruitRecordList.add(mapToFruit(rawRecords.get(i)));
        }
        return fruitRecordList;
    }

    public List<String> readFile(String filePath) throws ValidationException {
        File file = new File(PATH_REPORT_INPUT);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            List<String> list = null;
            while ((line = br.readLine()) != null) {
                mapToFruit(line);
                list.add(line);
                return list;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        } catch (IOException e) {
            System.err.println("Reading from filed " + filePath + " faild");
        }
        return null;

    }

    public FruitRecord mapToFruit(String record) throws ValidationException {
        validator.validate(record);
        String[] splitRecord = record.split(",");
        FruitRecord fruitRecord = new FruitRecord();
        fruitRecord.setFruit(splitRecord[1]);
        fruitRecord.setOperationType(splitRecord[0]);
        fruitRecord.setAmount(Integer.parseInt(splitRecord[2]));
        return fruitRecord;
    }
}
