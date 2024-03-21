package core.basesyntax.dto;

import core.basesyntax.enums.ActivityType;

public record ActivityDto(ActivityType type,
                          String productTitle, int productQuantity) { }
