package core.basesyntax.service.work.with.file;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.operation.Operation;
import java.util.ArrayList;
import java.util.List;

public class ReadFromCsvFileImpl implements ReadFromCsvFile {
    private static final String SPLITERATOR = ",";
    private static final String BALANCE_OPERATION = "b";
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int AMOUNT = 2;
    private final FruitDao fruitDao;
    private String fileName;

    public ReadFromCsvFileImpl(FruitDao fruitDao, String fileName) {
        this.fruitDao = fruitDao;
        this.fileName = fileName;
    }

    @Override
    public void addNewFruit() {
        ReadInformationFromFileImpl readInformationFromFile = new ReadInformationFromFileImpl();
        readInformationFromFile.setFileName(fileName);
        List<String> allLines = readInformationFromFile.getAllLines();
        FruitService fruitService = new FruitServiceImpl(fruitDao);
        for (int i = 0; i < allLines.size(); i++) {
            String[] oneLineInfo = allLines.get(i).split(SPLITERATOR);
            if (oneLineInfo[OPERATION].toUpperCase().equals(Operation.Type.S.toString())
                    || oneLineInfo[OPERATION].toUpperCase().equals(Operation.Type.P.toString())
                    || oneLineInfo[OPERATION].toUpperCase().equals(Operation.Type.R.toString())) {
                return;
            }
            if (oneLineInfo[OPERATION].toLowerCase().equals(BALANCE_OPERATION)) {
                fruitService.addNewFruit(oneLineInfo[FRUIT_NAME],
                        Integer.parseInt(oneLineInfo[AMOUNT]));
            }
        }
    }

    @Override
    public List<String[]> readInformationFromFile() {
        ReadInformationFromFileImpl readInformationFromFile = new ReadInformationFromFileImpl();
        readInformationFromFile.setFileName(fileName);
        List<String> allLines = readInformationFromFile.getAllLines();
        List<String[]> fruitsList = new ArrayList<>();
        for (int i = 0; i < allLines.size(); i++) {
            String[] oneLineInfo = allLines.get(i).split(SPLITERATOR);
            String operation = oneLineInfo[OPERATION].toUpperCase();
            if (operation.equals(Operation.Type.S.toString())
                    || operation.equals(Operation.Type.P.toString())
                    || operation.equals(Operation.Type.R.toString())) {
                fruitsList.add(oneLineInfo);
            }
        }
        return fruitsList;
    }
}

