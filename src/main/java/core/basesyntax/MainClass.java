package core.basesyntax;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        String readFromFilePath = "";
        String writeToFileName = "";
        String separator = ",";

        Storage storage = new Storage();

        DataParser dataParser = new DataParser();

        FileReaderService fileReaderServiceImpl = new FileReaderServiceImpl();
        FileWriterService fileWriterServiceImpl = new FileWriterServiceImpl();

        OperationStorage operationStorage = new OperationStorage();

        List<List<String>> data = fileReaderServiceImpl.readFile(readFromFilePath, separator);
        for (List<String> row : data) {
            operationStorage.getOperationMap()
                    .get(row.get(0)).toDo(dataParser.toReadFromSting(row), storage);
        }
        TypesOfFruits typesOfFruits = new TypesOfFruits();
        Conclusion conclusion = new Conclusion();
        fileWriterServiceImpl.writeFile(conclusion.toGetResult(storage,
                typesOfFruits.toGetTypes(storage)), separator, writeToFileName);
    }
}
