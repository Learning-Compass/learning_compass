package org.dspace.compass.association.rules;

import java.util.Map;

/**
 *
 * Used by COMPASS ASSOCIATION ENGINE.
 *
 * @author Anastasios Tsolakidis.
 * @author Nikolaos Christidis.
 */
public final class AssociationOptions {

    private boolean applyAssociation;
    private Map<Integer, ExtractionRule> extractionRulePerPageMap;

    private AssociationOptions() {
    }

    public static AssociationOptions getInstance(boolean applyAssociation, Map<Integer, ExtractionRule> extractionRulePerPageMap) {
        AssociationOptions associationOptions = new AssociationOptions();

        associationOptions.setApplyAssociation(applyAssociation);
        associationOptions.setExtractionRulePerPageMap(extractionRulePerPageMap);

        return associationOptions;
    }

    public boolean isApplyAssociation() {
        return applyAssociation;
    }

    public void setApplyAssociation(boolean applyAssociation) {
        this.applyAssociation = applyAssociation;
    }

    public Map<Integer, ExtractionRule> getExtractionRulePerPageMap() {
        return extractionRulePerPageMap;
    }

    public void setExtractionRulePerPageMap(Map<Integer, ExtractionRule> extractionRulePerPageMap) {
        this.extractionRulePerPageMap = extractionRulePerPageMap;
    }

}
