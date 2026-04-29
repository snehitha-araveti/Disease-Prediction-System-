package interfaces;

import java.util.List;
import java.util.stream.Stream;

public interface DiseaseInfo {
    String getDiseaseName();
    List<String> getSymptoms();
    List<String> getPrecautions();
    List<String> getMedications();
    List<String> getHomeRemedies();
    String getSeverity();
    String getDescription();
	Iterable<String> getPrimaryTreatments();
	String getWhenToSeeDoctor();
	String getRecoveryTime();
	String getICDCode();
	String getBodySystemAffected();
	 
	
}