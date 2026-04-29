package diseases;

import java.util.List;

import abstract_classes.InfectiousDisease;

public class CommonCold extends InfectiousDisease {
    public CommonCold() {
        name = "Common Cold";
        icdCode = "J00";
        description = "Viral infection of the upper respiratory tract";
        bodySystemAffected = "Respiratory";
        severity = "Mild";
        transmissionMethod = "Airborne droplets, direct contact";
        isContagious = true;
        incubationPeriod = "1-3 days";
        
        // Enhanced symptoms list
        symptoms.add("Runny or stuffy nose");
        symptoms.add("Sneezing");
        symptoms.add("Sore or scratchy throat");
        symptoms.add("Cough (mild to moderate)");
        symptoms.add("Watery eyes");
        symptoms.add("Low-grade fever (more common in children)");
        symptoms.add("Mild headache");
        symptoms.add("Body aches (mild)");
        
        // Expanded precautions
        precautions.add("Frequent hand washing with soap for 20+ seconds");
        precautions.add("Avoid touching face (especially eyes, nose, mouth)");
        precautions.add("Disinfect frequently touched surfaces");
        precautions.add("Use tissues when sneezing/coughing and dispose immediately");
        precautions.add("Maintain 3+ feet distance from infected individuals");
        
        // Updated medications
        medications.add("Acetaminophen (for fever/pain)");
        medications.add("Ibuprofen (for inflammation)");
        medications.add("Pseudoephedrine (nasal decongestant)");
        medications.add("Dextromethorphan (cough suppressant)");
        medications.add("Antihistamines for runny nose (e.g., Loratadine)");
        
        // Comprehensive home remedies
        homeRemedies.add("Warm salt water gargle (1/2 tsp salt in 8oz warm water)");
        homeRemedies.add("Chicken soup (reduces inflammation)");
        homeRemedies.add("Honey (1 tsp) for cough relief (not for children under 1)");
        homeRemedies.add("Zinc lozenges at symptom onset (may reduce duration)");
        homeRemedies.add("Steam inhalation with essential oils (eucalyptus/menthol)");
        homeRemedies.add("Elevate head while sleeping to reduce congestion");
        
        // Treatment plan
        primaryTreatments.add("Rest and hydration (8-10 glasses of fluids daily)");
        primaryTreatments.add("Symptomatic relief with OTC medications");
        
        alternativeTreatments.add("Vitamin C supplementation (may shorten duration)");
        alternativeTreatments.add("Echinacea supplements (controversial efficacy)");
        
        recoveryTime = "7-10 days (up to 2 weeks in some cases)";
        whenToSeeDoctor = "If symptoms persist beyond 10 days, fever >101°F (38.3°C), "
                + "or difficulty breathing develops";
    }

	
}