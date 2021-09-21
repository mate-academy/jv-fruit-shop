package Service;

import Service.Activities.Activities;
import Service.Activities.TypeOfActivities;

public interface ActivitiesStrategy {
    Activities get(TypeOfActivities type);

}
