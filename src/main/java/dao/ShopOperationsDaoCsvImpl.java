package dao;

import fm.FileManager;
import fm.FileManagerCsvImpl;
import fom.FruitOperationManager;
import fom.FruitOperationManagerCsvImpl;
import java.util.List;
import java.util.stream.Collectors;
import validators.FruitDataValidator;
import validators.FruitDataValidatorCsvImpl;

public class ShopOperationsDaoCsvImpl implements ShopOperationsDao {
    private final String inputFileName;
    private final String outputFileName;

    public ShopOperationsDaoCsvImpl(String inputFileName, String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }

    @Override
    public boolean validate() {
        FruitDataValidator dataValidator = new FruitDataValidatorCsvImpl();
        FruitOperationManager operationManager = new FruitOperationManagerCsvImpl(inputFileName);
        return dataValidator.validate(operationManager.getAllOperations());
    }

    @Override
    public void generateReport() {
        if (!validate()) {
            throw new RuntimeException("File " + inputFileName + " is not valid!");
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity").append(System.lineSeparator());

        FruitOperationManager operationManager = new FruitOperationManagerCsvImpl(inputFileName);
        operationManager.getAllOperations()
                .stream()
                .map(this::cutFruitDataToNameValueFormat)
                .collect(Collectors.groupingBy(row -> row.split(",")[0]))
                .entrySet().stream()
                .map(s -> getFruitTotal(s.getKey(), s.getValue()))
                .forEach(s -> stringBuilder.append(s).append(System.lineSeparator()));

        FileManager fileManager = new FileManagerCsvImpl();
        fileManager.writeToFile(outputFileName, stringBuilder.toString().trim());
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
