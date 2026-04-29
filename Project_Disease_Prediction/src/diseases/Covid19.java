package diseases;

import java.util.List;

import abstract_classes.InfectiousDisease;

public  class Covid19 extends InfectiousDisease {
    public Covid19() {
        name = "COVID-19";
        icdCode = "U07.1";
        description = "Coronavirus disease 2019 caused by SARS-CoV-2 virus";
        bodySystemAffected = "Respiratory";
        severity = "Variable";
        transmissionMethod = "Respiratory droplets";
        isContagious = true;
        incubationPeriod = "2-14 days";
        
        symptoms.add("Fever");
        symptoms.add("Dry cough");
        symptoms.add("Fatigue");
        symptoms.add("Loss of taste/smell");
        symptoms.add("Difficulty breathing");
        
        precautions.add("Vaccination");
        precautions.add("Mask wearing");
        precautions.add("Social distancing");
        
        medications.add("Paxlovid");
        medications.add("Remdesivir");
        medications.add("Dexamethasone (severe cases)");
        
        homeRemedies.add("Rest");
        homeRemedies.add("Hydration");
        homeRemedies.add("Steam inhalation");
        
        primaryTreatments.add("Antiviral therapy");
        primaryTreatments.add("Symptomatic treatment");
        
        recoveryTime = "2-6 weeks";
        whenToSeeDoctor = "If oxygen saturation < 94% or difficulty breathing";
    }

	
}