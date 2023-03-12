package service.impl;

import java.util.List;
import model.ReportException;
import service.general.DataPreparationService;
import service.general.InputStorageService;

public class DataPreparationServiceImpl implements DataPreparationService {
    private static final String LEGEND_REGEX = "\\w++,\\w++,\\w++";
    private static final String CORRECT_DATA_REGEX = "[bspr],\\w++,\\d++";
    private static final int LEGEND_INDEX = 0;

    @Override
    public boolean getDataPrepared() {
        InputStorageService storageService = new InputStorageServiceImpl();
        List<String> inputData = storageService.getStorageData();
        if (inputData.isEmpty()) {
            throw new ReportException("Incoming file has no data");
        }
        String legend = inputData.get(LEGEND_INDEX);
        if (legend.matches(LEGEND_REGEX) && !legend.matches(CORRECT_DATA_REGEX)) {
            inputData.remove(LEGEND_INDEX);
        }
        for (String line : inputData) {
            if (!line.matches(CORRECT_DATA_REGEX)) {
                throw new ReportException("Incorrect data met at line: " + line);
            }
        }
        return true;
    }
}
