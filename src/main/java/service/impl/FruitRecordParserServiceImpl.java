package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitRecordDto;
import service.ActivityService;
import service.FruitRecordParserService;
import service.validator.DataValidator;

public class FruitRecordParserServiceImpl implements FruitRecordParserService {
    private ActivityService activityService;

    public FruitRecordParserServiceImpl(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Override
    public List<FruitRecordDto> getRecord(List<String> stringsFromFile) {
        List<FruitRecordDto> outputList = new ArrayList<>();
        for (String string : stringsFromFile) {
            new DataValidator().test(string);
            String[] stringElements = string.split(",");
            outputList.add(new FruitRecordDto(activityService.getActivity(stringElements[0]),
                    stringElements[1],
                    Integer.parseInt(stringElements[2])));
        }
        return outputList;
    }
}
