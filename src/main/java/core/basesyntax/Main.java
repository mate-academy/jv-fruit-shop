package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.service.fileservices.CreateReportFile;
import core.basesyntax.service.fileservices.ParseFile;
import core.basesyntax.service.fileservices.ReadFileImpl;
import core.basesyntax.service.summaryofoperations.GeneralCalculation;
import core.basesyntax.service.summaryofoperations.PreparationReportList;
import core.basesyntax.storage.FruitStorage;
import core.basesyntax.storage.PrepareList;
import core.basesyntax.storage.ProcessingData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String inputFilePath = "src/main/java/core/basesyntax/resources"
            + "/FruitFiles.csv";
    private static final String reportFilePath = "src/main/java/core/basesyntax/resources"
            + "/reportFiles/report.csv";
    private static final Map<Operation, Map<String, List<Integer>>> fruitMaps = new HashMap<>();

    public static void main(String[] args) {
        ParseFile parseFile = new ParseFile();
        String filePath = parseFile.parseFileWithData(inputFilePath);
        ReadFileImpl readFile = new ReadFileImpl(parseFile);
        List<String> listOfFruits = readFile.readFromCsvFile(filePath);
        PrepareList prepareList = new PrepareList();
        List<String> listOperation = prepareList.prepareListWithoutTitle(listOfFruits);
        StorageDao storageDao = new StorageDaoImpl();
        ProcessingData processingData = new ProcessingData(storageDao);
        FruitStorage fruitStorage = new FruitStorage(processingData);
        Map<Operation, Map<String, List<Integer>>> fruitsStorage =
                fruitStorage.createStorage(fruitMaps, listOperation);
        GeneralCalculation generalCalculation = new GeneralCalculation(storageDao);
        PreparationReportList preparationReportList = new PreparationReportList(generalCalculation);
        CreateReportFile createReportFile = new CreateReportFile(preparationReportList);
        createReportFile.createReportFile(reportFilePath, fruitsStorage);
    }
}
