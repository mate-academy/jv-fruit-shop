package core.basesyntax.service;

import core.basesyntax.dto.ActivityDto;
import java.util.List;

public interface BalanceUpdater {
    public void updateFrom(List<ActivityDto> activities);
}
