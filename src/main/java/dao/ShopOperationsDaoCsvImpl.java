package dao;

import fileManagers.FileManager;
import fileManagers.FileManagerCsvImpl;
import fruitOperationManagers.FruitOperationManager;
import fruitOperationManagers.FruitOperationManagerCsvImpl;
import validators.FruitDataValidator;
import validators.FruitDataValidatorCsvImpl;

import java.util.List;
import java.util.stream.Collectors;

public class ShopOperationsDaoCsvImpl implements ShopOperationsDao {
    private final String INPUT_FILE_NAME;
    private final String OUTPUT_FILE_NAME;

    public ShopOperationsDaoCsvImpl(String inputFileName, String outputFileName) {
        this.INPUT_FILE_NAME = inputFileName;
        this.OUTPUT_FILE_NAME = outputFileName;
    }

    @Override
    public boolean validate() {
        FruitDataValidator dataValidator = new FruitDataValidatorCsvImpl(INPUT_FILE_NAME);
        return dataValidator.validate();
    }

    @Override
    public void generateReport() {
        if (!validate()) {
            throw new RuntimeException("File " + INPUT_FILE_NAME + " is not valid!");
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity").append(System.lineSeparator());

        FruitOperationManager operationManager = new FruitOperationManagerCsvImpl(INPUT_FILE_NAME);
        operationManager.getAllOperations()
                .stream()
                .map(this::cutFruitDataToNameValueFormat)
                .collect(Collectors.groupingBy(row -> row.split(",")[0]))
                .entrySet().stream()
                .map(s -> getFruitTotal(s.getKey(), s.getValue()))
                .forEach(s -> stringBuilder.append(s).append(System.lineSeparator()));

        FileManager fileManager = new FileManagerCsvImpl();
        fileManager.writeToFile(OUTPUT_FILE_NAME, stringBuilder.toString().trim());
    }

    private String getFruitTotal(String fruit, List<String> operationList) {
        return fruit + "," + operationList.stream()
                .map(this::cutFruitDataToValueFormat)
                .mapToInt(v -> v)
                .sum();
    }

    private String cutFruitDataToNameValueFormat(String row) {
        String[] data = row.split(",");
        return data[1] + "," + (data[0].equals("p") ? "-" : "") + data[2];
    }

    private int cutFruitDataToValueFormat(String row) {
        String[] data = row.split(",");
        return Integer.parseInt(data[1]);
    }
}
