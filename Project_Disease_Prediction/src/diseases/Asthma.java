package diseases;

import java.util.List;

import abstract_classes.ChronicDisease;

public class Asthma extends ChronicDisease {
    public Asthma() {
        name = "Asthma";
        icdCode = "J45";
        description = "Chronic inflammatory airway disease with reversible obstruction";
        bodySystemAffected = "Respiratory";
        severity = "Chronic";
        isGenetic = true;
        managementPlan = "Trigger avoidance and stepwise pharmacotherapy";
        
        riskFactors.add("Atopy (eczema, allergic rhinitis)");
        riskFactors.add("Family history");
        riskFactors.add("Childhood respiratory infections");
        
        symptoms.add("Recurrent wheezing");
        symptoms.add("Chest tightness");
        symptoms.add("Shortness of breath");
        symptoms.add("Nocturnal cough");
        symptoms.add("Symptoms worse with exercise/cold air");
        
        precautions.add("Identify and avoid triggers (allergens, smoke)");
        precautions.add("Annual influenza vaccination");
        precautions.add("Action plan for exacerbations");
        precautions.add("Regular peak flow monitoring");
        
        medications.add("Short-acting beta agonists (albuterol) - rescue");
        medications.add("Inhaled corticosteroids (fluticasone) - controller");
        medications.add("Leukotriene modifiers (montelukast)");
        medications.add("Biologics (omalizumab for severe allergic asthma)");
        
        homeRemedies.add("Breathing exercises (pursed-lip breathing)");
        homeRemedies.add("Caffeine (mild bronchodilator effect)");
        homeRemedies.add("Honey (cough suppressant, not for infants)");
        
        primaryTreatments.add("Stepwise approach based on severity");
        primaryTreatments.add("Regular controller medication for persistent asthma");
        
        recoveryTime = "Lifelong condition with episodic exacerbations";
        whenToSeeDoctor = "If rescue inhaler needed >2x/week, "
                + "or peak flow <50% of personal best";
    }

	

}

