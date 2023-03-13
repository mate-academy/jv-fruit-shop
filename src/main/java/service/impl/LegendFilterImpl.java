package service.impl;

import dao.InputDao;
import dao.impl.InputDaoImpl;
import java.util.List;
import service.LegendFilter;

public class LegendFilterImpl implements LegendFilter {
    private static final String LEGEND_REGEX = "\\w++,\\w++,\\w++";
    private static final String CORRECT_DATA_REGEX = "[bspr],\\w++,\\d++";
    private static final int LEGEND_INDEX = 0;
    private final InputDao storageService = new InputDaoImpl();

    @Override
    public void getLegendFiltered() {
        List<String> inputData = storageService.getStorageData();
        String legend = storageService.getStorageData().get(LEGEND_INDEX);
        if (legend.matches(LEGEND_REGEX) && !legend.matches(CORRECT_DATA_REGEX)) {
            inputData.remove(LEGEND_INDEX);
        }
    }
}
