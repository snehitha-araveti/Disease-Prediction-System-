package diseases;

import java.util.List;

import abstract_classes.InfectiousDisease;

public class Pneumonia extends InfectiousDisease {
    public Pneumonia() {
        name = "Pneumonia";
        icdCode = "J18";
        description = "Acute lung infection causing inflammation of air sacs";
        bodySystemAffected = "Respiratory";
        severity = "Moderate to Severe";
        transmissionMethod = "Airborne droplets, aspiration";
        isContagious = true;
        incubationPeriod = "1-3 days (bacterial), 1-4 weeks (viral)";
        
        symptoms.add("Productive cough (yellow/green/bloody sputum)");
        symptoms.add("High fever with chills");
        symptoms.add("Sharp chest pain worsened by breathing/coughing");
        symptoms.add("Shortness of breath (even at rest in severe cases)");
        symptoms.add("Fatigue and confusion (especially in elderly)");
        
        precautions.add("Pneumococcal and influenza vaccinations");
        precautions.add("Hand hygiene and respiratory etiquette");
        precautions.add("Smoking cessation");
        precautions.add("Proper oral hygiene to prevent aspiration");
        
        medications.add("Antibiotics (amoxicillin, azithromycin for bacterial)");
        medications.add("Antivirals (for viral pneumonia)");
        medications.add("Bronchodilators (albuterol)");
        medications.add("Cough suppressants (dextromethorphan)");
        
        homeRemedies.add("Warm fluids to loosen secretions");
        homeRemedies.add("Chest percussion therapy");
        homeRemedies.add("Humidified air");
        
        primaryTreatments.add("Oxygen therapy if saturation <90%");
        primaryTreatments.add("Antibiotic therapy based on pathogen");
        
        recoveryTime = "3-6 weeks (longer for elderly)";
        whenToSeeDoctor = "Immediate care if breathing difficulty, "
                + "confusion, or cyanosis occurs";
    }

	
}
