package diseases;

import java.util.List;

import abstract_classes.InfectiousDisease;

public class Influenza extends InfectiousDisease {
    public Influenza() {
        name = "Influenza (Flu)";
        icdCode = "J10";
        description = "Highly contagious viral infection of respiratory system";
        bodySystemAffected = "Respiratory";
        severity = "Moderate to Severe";
        transmissionMethod = "Airborne droplets, contact with contaminated surfaces";
        isContagious = true;
        incubationPeriod = "1-4 days (average 2 days)";
        
        // Comprehensive symptoms
        symptoms.add("Sudden high fever (100-102°F, may reach 104°F)");
        symptoms.add("Severe muscle aches (especially back/arms/legs)");
        symptoms.add("Profound fatigue and weakness (can last 2-3 weeks)");
        symptoms.add("Dry, hacking cough");
        symptoms.add("Headache (often severe)");
        symptoms.add("Chills and sweats");
        symptoms.add("Nasal congestion (sometimes)");
        symptoms.add("Sore throat (sometimes)");
        
        // Detailed precautions
        precautions.add("Annual flu vaccination (best preventive measure)");
        precautions.add("Antiviral prophylaxis for high-risk exposed individuals");
        precautions.add("Stay home for at least 24 hours after fever subsides");
        precautions.add("N95 masks in healthcare settings during outbreaks");
        precautions.add("Respiratory hygiene/cough etiquette training");
        
        // Updated medications
        medications.add("Oseltamivir (Tamiflu) - most effective within 48h of symptoms");
        medications.add("Zanamivir (Relenza) - for uncomplicated cases");
        medications.add("Baloxavir marboxil (Xofluza) - single-dose treatment");
        medications.add("Peramivir (Rapivab) - IV administration for hospitalized");
        medications.add("Acetaminophen/NSAIDs for fever and pain");
        
        // Enhanced home care
        homeRemedies.add("Complete bed rest during acute phase");
        homeRemedies.add("Electrolyte solutions to prevent dehydration");
        homeRemedies.add("Warm compresses for muscle pain relief");
        homeRemedies.add("Humidifier to ease breathing (clean daily)");
        homeRemedies.add("Throat lozenges for cough/sore throat");
        
        // Treatment protocol
        primaryTreatments.add("Antiviral therapy initiated within 48h of symptoms");
        primaryTreatments.add("Supportive care (hydration, rest, fever control)");
        
        alternativeTreatments.add("Elderberry syrup (may reduce symptom severity)");
        alternativeTreatments.add("Garlic supplements (potential antiviral effects)");
        
        recoveryTime = "1-2 weeks for symptom resolution, "
                + "3+ weeks for full recovery in severe cases";
        whenToSeeDoctor = "Difficulty breathing, chest pain, "
                + "persistent high fever (>3 days), "
                + "bluish lips/face, severe dehydration signs";
    }

	}