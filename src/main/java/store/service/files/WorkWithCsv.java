package store.service.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import store.db.Actions;
import store.db.StorageInfo;
import store.model.Fruits;
import store.service.activities.ActionsOfFruits;

public class WorkWithCsv implements ReadWriteAble {
    private static final String COMA = ",";
    private static final String FILE_REPORT = "report.csv";
    private static final String TEMP_FILE = "temp.csv";
    private ActionsOfFruits actionsOfFruits;
    private String fileNameForRead;
    private File fileRead;
    private StorageInfo storageInfo;

    public WorkWithCsv() {
        storageInfo = new StorageInfo();
        actionsOfFruits = new ActionsOfFruits();
    }

    @Override
    public void read() {
        try {
            List<String> data = Files.readAllLines(Paths.get(fileRead.getAbsolutePath()));
            data.remove(0);
            checkData(data);
            addToDb(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file!");
        }
    }

    private void addToDb(List<String> data) {
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < Actions.values().length; j++) {
                String actionKey = data.get(i).substring(0, data.get(i).indexOf(COMA));
                int cost = Integer.parseInt(data.get(i)
                        .substring(data.get(i).lastIndexOf(COMA) + 1));

                if (Objects.equals(actionKey, String.valueOf(Actions.values()[j]))) {
                    storageInfo.add(Actions.values()[j],
                            new Fruits(data.get(i).substring(data.get(i).indexOf(COMA) + 1,
                                    data.get(i).lastIndexOf(COMA)), cost));
                }
            }
        }
    }

    private void checkData(List<String> data) {
        int sumBalance = 0;
        int sumBuyers = 0;

        for (int i = 0; i < data.size(); i++) {
            String[] dataInfo = data.get(i).split(COMA);
            int value = Integer.parseInt(dataInfo[2]);
            if (dataInfo[0].equals("b") && value >= 0) {
                sumBalance += value;
            }
            if (dataInfo[0].equals("p") && value >= 0) {
                sumBuyers += value;
            }
            if (dataInfo[0].equals("p") && value < 0) {
                throw new RuntimeException("Buyers will not be able to buy "
                        + value + " bananas." + value + " was incorrect input.");
            }
        }
        if (sumBalance < sumBuyers) {
            throw new RuntimeException("Buyers will not be able to buy "
                    + sumBuyers + " bananas, because they are only "
                    + sumBalance + " units in stock.");
        }
    }

    private void writeToTempFile() {
        Map<Actions, List<Fruits>> dataFromDb = storageInfo.getDb();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEMP_FILE))) {
            for (Map.Entry<Actions, List<Fruits>> entry : dataFromDb.entrySet()) {
                List<Fruits> fruits = entry.getValue();
                StringBuilder builder = new StringBuilder();

                for (int i = 0; i < fruits.size(); i++) {
                    builder.append(entry.getKey()).append(COMA)
                            .append(fruits.get(i).getName()).append(COMA)
                            .append(fruits.get(i).getCost()).append(System.lineSeparator());
                }
                writer.write(builder.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to the file!");
        }
    }

    @Override
    public List<String> readFromTempFile() {
        List<String> listOfDb;
        try {
            listOfDb = Files.readAllLines(Paths
                    .get(new File(TEMP_FILE).getAbsolutePath()));
        } catch (IOException e) {
            throw new RuntimeException("Can't read temp file!");
        }
        actionsOfFruits.storeBalance(listOfDb);
        return listOfDb;
    }

    @Override
    public String writeToReport() {
        Map<String, Integer> resultData = actionsOfFruits.getResultData();
        StringBuilder result = new StringBuilder();
        result.append("fruit").append(COMA)
                .append("quantity").append(System.lineSeparator());

        for (Map.Entry<String, Integer> entry : resultData.entrySet()) {
            result.append(entry.getKey()).append(COMA)
                    .append(entry.getValue()).append(System.lineSeparator());
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_REPORT))) {
            bufferedWriter.write(result.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to rhe file!");
        }
        return result.toString();
    }

    @Override
    public void startWork() {
        read();
        writeToTempFile();
        List<String> listForReport = readFromTempFile();
        actionsOfFruits.doActions(listForReport);
    }

    public void setFileNameForRead(String fileNameForRead) {
        Objects.requireNonNull(fileNameForRead);
        this.fileNameForRead = fileNameForRead;
        fileRead = new File(fileNameForRead);
    }

    public ActionsOfFruits getActionsOfFruits() {
        return actionsOfFruits;
    }
}
