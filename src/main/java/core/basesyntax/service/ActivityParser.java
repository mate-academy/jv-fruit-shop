package core.basesyntax.service;

import core.basesyntax.dto.ActivityDto;
import java.util.List;

public interface ActivityParser {
    List<ActivityDto> parse(List<String> activityRows);
}
