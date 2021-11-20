package core.basesyntax.strategy;

import core.basesyntax.db.dao.ActivityDao;

public class Balance extends Activity{
    ActivityDao activityDao = new ActivityDao();

    public Balance() {

    }

    @Override
    public void apply(Activity activity) {

    }
}
