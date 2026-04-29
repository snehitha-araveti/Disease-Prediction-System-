package abstract_classes;

import java.util.ArrayList;
import java.util.List;

public abstract class ChronicDisease extends AbstractDisease {
    protected boolean isGenetic;
    protected String managementPlan;
    protected List<String> riskFactors = new ArrayList<>();

    public boolean isGenetic() { return isGenetic; }
    public String getManagementPlan() { return managementPlan; }
    public List<String> getRiskFactors() { return riskFactors; }
}