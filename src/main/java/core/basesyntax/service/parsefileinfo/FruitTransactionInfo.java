package core.basesyntax.service.parsefileinfo;

import core.basesyntax.service.functionalityexpansion.ActivityType;

public record FruitTransactionInfo(ActivityType activityType, String name, int quantity) {
}
