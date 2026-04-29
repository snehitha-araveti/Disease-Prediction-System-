package diseases;

import java.util.List;

import abstract_classes.ChronicDisease;

public class Migraine extends ChronicDisease {
    public Migraine() {
        name = "Migraine";
        icdCode = "G43";
        description = "Neurological disorder characterized by recurrent headaches";
        bodySystemAffected = "Neurological";
        severity = "Variable";
        isGenetic = true;
        managementPlan = "Trigger avoidance and abortive/preventive therapy";
        
        riskFactors.add("Family history");
        riskFactors.add("Female gender (3:1 ratio)");
        riskFactors.add("Hormonal changes");
        
        symptoms.add("Unilateral throbbing headache (4-72 hours duration)");
        symptoms.add("Photophobia and phonophobia");
        symptoms.add("Nausea/vomiting");
        symptoms.add("Visual aura (flashing lights, zigzag patterns)");
        symptoms.add("Sensory disturbances");
        
        precautions.add("Identify and avoid triggers (common: stress, foods, sleep changes)");
        precautions.add("Regular sleep schedule");
        precautions.add("Hydration maintenance");
        precautions.add("Caffeine moderation");
        
        medications.add("Triptans (sumatriptan) - abortive");
        medications.add("NSAIDs (ibuprofen) - mild attacks");
        medications.add("Anti-emetics (metoclopramide)");
        medications.add("CGRP antagonists (erenumab) - preventive");
        
        homeRemedies.add("Cold compress to head/neck");
        homeRemedies.add("Peppermint oil to temples");
        homeRemedies.add("Ginger tea for nausea");
        
        primaryTreatments.add("Stepwise approach based on severity");
        primaryTreatments.add("Behavioral therapy for stress management");
        
        recoveryTime = "4-72 hours per episode";
        whenToSeeDoctor = "If 'worst headache of life', "
                + "or new neurological symptoms develop";
    }

	
}