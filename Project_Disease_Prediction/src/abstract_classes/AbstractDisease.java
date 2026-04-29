package abstract_classes;

import interfaces.DiseaseInfo;
import interfaces.TreatmentPlan;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDisease implements DiseaseInfo, TreatmentPlan {
    protected String name;
    protected List<String> symptoms = new ArrayList<>();
    protected List<String> precautions = new ArrayList<>();
    protected List<String> medications = new ArrayList<>();
    protected List<String> homeRemedies = new ArrayList<>();
    protected String severity;
    protected String description;
    protected String icdCode;
    protected String bodySystemAffected;
    protected List<String> primaryTreatments = new ArrayList<>();
    protected List<String> alternativeTreatments = new ArrayList<>();
    protected String recoveryTime;
    protected String whenToSeeDoctor;

    @Override public String getDiseaseName() { return name; }
    @Override public List<String> getSymptoms() { return symptoms; }
    @Override public List<String> getPrecautions() { return precautions; }
    @Override public List<String> getMedications() { return medications; }
    @Override public List<String> getHomeRemedies() { return homeRemedies; }
    @Override public String getSeverity() { return severity; }
    @Override public String getDescription() { return description; }
    @Override public String getICDCode() { return icdCode; }
    @Override public String getBodySystemAffected() { return bodySystemAffected; }
    @Override public List<String> getPrimaryTreatments() { return primaryTreatments; }
    @Override public List<String> getAlternativeTreatments() { return alternativeTreatments; }
    @Override public String getRecoveryTime() { return recoveryTime; }
    @Override public String getWhenToSeeDoctor() { return whenToSeeDoctor; }

    public void displayBasicInfo() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║          DISEASE INFORMATION         ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf("║ %-20s: %-15s ║\n", "Name", name);
        System.out.printf("║ %-20s: %-15s ║\n", "ICD Code", icdCode);
        System.out.printf("║ %-20s: %-15s ║\n", "Severity", severity);
        System.out.printf("║ %-20s: %-15s ║\n", "Body System", bodySystemAffected);
        System.out.println("╚══════════════════════════════════════╝");
    }
}