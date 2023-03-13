package service.impl;

import dao.InputDao;
import dao.impl.InputDaoImpl;
import exception.ReportException;
import java.util.List;
import service.DataCheckService;

public class DataCheckServiceImpl implements DataCheckService {
    private static final String CORRECT_DATA_REGEX = "[bspr],\\w++,\\d++";
    private final InputDao storageService = new InputDaoImpl();

    @Override
    public void getDataChecked() {
        List<String> inputData = storageService.getStorageData();
        if (inputData.isEmpty()) {
            throw new ReportException("Incoming file has no data");
        }
        for (int i = 1; i < inputData.size(); i++) {
            String line = inputData.get(i);
            if (!line.matches(CORRECT_DATA_REGEX)) {
                throw new ReportException("Incorrect data met at line: " + line);
            }
        }
    }
}
