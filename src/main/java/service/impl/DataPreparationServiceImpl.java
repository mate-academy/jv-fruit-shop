package service.impl;

import java.util.List;
import model.ReportException;
import service.general.DataPreparationService;
import service.general.InputStorageService;

public class DataPreparationServiceImpl implements DataPreparationService {
    private static final String LEGEND_REGEX = "\\w++,\\w++,\\w++";
    private static final String CORRECT_DATA_REGEX = "[bspr],\\w++,\\d++";

    public boolean getDataPrepared() {
        InputStorageService storageService = new InputStorageServiceImpl();
        List<String> inputData = storageService.getStorageData();
        if (inputData.isEmpty()) {
            throw new ReportException("Incoming file has no data");
        }
        if (inputData.get(0).matches(LEGEND_REGEX)) {
            inputData.remove(0);
        }
        for (String line : inputData) {
            if (!line.matches(CORRECT_DATA_REGEX)) {
                throw new ReportException("Incorrect data met at line: " + line);
            }
        }
        return true;
    }
}
