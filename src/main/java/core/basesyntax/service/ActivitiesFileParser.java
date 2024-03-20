package core.basesyntax.service;

import core.basesyntax.dto.ActivityDto;
import java.util.List;

public interface ActivitiesFileParser {
    List<ActivityDto> readFrom(String fileName);
}
