package core.basesyntax;

import core.basesyntax.models.Product;
import core.basesyntax.models.activities.ActivityHandler;

public interface ActivityStrategy {
    ActivityHandler getActivity(Product.TypeOfActivity type);
}
