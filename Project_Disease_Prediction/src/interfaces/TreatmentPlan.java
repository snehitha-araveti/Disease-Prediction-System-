package interfaces;

import java.util.List;

public interface TreatmentPlan {
    List<String> getPrimaryTreatments();
    List<String> getAlternativeTreatments();
    String getRecoveryTime();
    String getWhenToSeeDoctor();
}