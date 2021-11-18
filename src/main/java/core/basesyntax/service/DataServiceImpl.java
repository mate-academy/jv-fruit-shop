package core.basesyntax.service;

import core.basesyntax.dao.InputFileDao;
import core.basesyntax.model.InputData;

public class DataServiceImpl implements DataService {
    private InputFileDao inputFileDao;

    public DataServiceImpl(InputFileDao inputFileDao) {
        this.inputFileDao = inputFileDao;
    }

    @Override
    public void registerDataFromFile(String inputFileName) {
        InputData inputData = new InputData(inputFileName);
        inputData.parseFile();
        Validator validator = new Validator();
        validator.validate(inputData);
        inputFileDao.add(inputData);
    }
}
