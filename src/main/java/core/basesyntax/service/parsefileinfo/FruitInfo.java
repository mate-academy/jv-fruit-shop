package core.basesyntax.service.parsefileinfo;

import core.basesyntax.service.functionalityexpansion.ActivityTypeEnum;

public record FruitInfo(ActivityTypeEnum activityType, String name, int quantity) {
}
