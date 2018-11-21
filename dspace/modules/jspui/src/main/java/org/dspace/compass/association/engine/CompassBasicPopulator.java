package org.dspace.compass.association.engine;

import java.io.Serializable;
import org.dspace.compass.association.extractor.util.ItemIdExtractor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.log4j.Logger;
import org.dspace.compass.association.extractor.StrategyExtractorDispatcher;
import org.dspace.compass.association.settings.FormSubmissionSettings;
import org.dspace.compass.association.rules.AssociationOptions;
import org.dspace.compass.association.extractor.util.ItemMetadatumExtractor;
import org.dspace.compass.association.rules.ExtractionRule;
import org.dspace.compass.association.util.Tupple2;
import org.dspace.content.Collection;
import org.dspace.content.Item;
import org.dspace.content.Metadatum;

/**
 * COMPASS Helper Class for making associations.
 *
 * IMPORTANT NOTE: In order to work the association engine the item must have at
 * least TITLE OR/AND IDENTIFIER column populated.
 *
 * @author Anastasios Tsolakidis.
 * @author Nikolaos Christidis.
 */
public class CompassBasicPopulator implements Serializable {

    private static final long serialVersionUID = 7351827927256402034L;

    private static final String CONCATENATOR_SYMBOL = "#";

    private static final String NO_LEARNING_OPPORTUNITY_SPECIFICATIONS_EXIST_LABEL = "No Learning Opportunity Specifications Exist!";
    private static final String NO_LEARNING_OPPORTUNITY_SPECIFICATIONS_EXIST_VALUE = "";

    private static final Logger LOG = Logger.getLogger(CompassBasicPopulator.class);

    private final Map<String, AssociationOptions> collectionHandlesToApplyAssociation;

    private final StrategyExtractorDispatcher strategyExtractorDispatcher;

    //----------------------------------methods---------------------------------
    public CompassBasicPopulator() {
        //initialization...
        strategyExtractorDispatcher = new StrategyExtractorDispatcher();
        collectionHandlesToApplyAssociation = new TreeMap<>();

        //declare handling for form submission....
        Map<Integer, ExtractionRule> settingsForTeiAthItDepPostGradLos = new HashMap<>();
        settingsForTeiAthItDepPostGradLos.put(3, ExtractionRule.ITEMS_FROM_SAME_COLLECTION);
        collectionHandlesToApplyAssociation.put(FormSubmissionSettings.ITALIAN_GRAD_LOS,
                AssociationOptions.getInstance(true, settingsForTeiAthItDepPostGradLos));
        collectionHandlesToApplyAssociation.put(FormSubmissionSettings.TUD_GRAD_LOS,
                AssociationOptions.getInstance(true, settingsForTeiAthItDepPostGradLos));
          collectionHandlesToApplyAssociation.put(FormSubmissionSettings.NQIS_GRAD_LOS,
                AssociationOptions.getInstance(true, settingsForTeiAthItDepPostGradLos));
          collectionHandlesToApplyAssociation.put(FormSubmissionSettings.TUT_GRAD_LOS,
                AssociationOptions.getInstance(true, settingsForTeiAthItDepPostGradLos));
          collectionHandlesToApplyAssociation.put(FormSubmissionSettings.TEI_GRAD_LOS,
                AssociationOptions.getInstance(true, settingsForTeiAthItDepPostGradLos));
            collectionHandlesToApplyAssociation.put(FormSubmissionSettings.UM_GRAD_LOS,
                AssociationOptions.getInstance(true, settingsForTeiAthItDepPostGradLos));
            collectionHandlesToApplyAssociation.put(FormSubmissionSettings.ES_GRAD_LOS,
                AssociationOptions.getInstance(true, settingsForTeiAthItDepPostGradLos));
        
        //declare handling for form submission...
        Map<Integer, ExtractionRule> settingsForTeiAthItDepPostGradLoi = new HashMap<>();
        settingsForTeiAthItDepPostGradLoi.put(1, ExtractionRule.LOSPECIFICATIONS_FOR_SELECTED_LO_INSTANCE);
        settingsForTeiAthItDepPostGradLoi.put(5, ExtractionRule.ITEMS_FROM_SAME_COLLECTION);
        collectionHandlesToApplyAssociation.put(FormSubmissionSettings.ITALIAN_GRAD_LOI,
                AssociationOptions.getInstance(true, settingsForTeiAthItDepPostGradLoi));
        collectionHandlesToApplyAssociation.put(FormSubmissionSettings.TUD_GRAD_LOI,
                AssociationOptions.getInstance(true, settingsForTeiAthItDepPostGradLoi));
        collectionHandlesToApplyAssociation.put(FormSubmissionSettings.NQIS_GRAD_LOI,
                AssociationOptions.getInstance(true, settingsForTeiAthItDepPostGradLoi));
        collectionHandlesToApplyAssociation.put(FormSubmissionSettings.TUT_GRAD_LOI,
                AssociationOptions.getInstance(true, settingsForTeiAthItDepPostGradLoi));
        collectionHandlesToApplyAssociation.put(FormSubmissionSettings.TEI_GRAD_LOI,
                AssociationOptions.getInstance(true, settingsForTeiAthItDepPostGradLoi));
        collectionHandlesToApplyAssociation.put(FormSubmissionSettings.UM_GRAD_LOI,
                AssociationOptions.getInstance(true, settingsForTeiAthItDepPostGradLoi));
           collectionHandlesToApplyAssociation.put(FormSubmissionSettings.ES_GRAD_LOI,
                AssociationOptions.getInstance(true, settingsForTeiAthItDepPostGradLoi));
       
        
    }

    private AssociationOptions getAssociationOptions(String collectionHandle) {

        AssociationOptions result = collectionHandlesToApplyAssociation.get(collectionHandle);
        
        for(Map.Entry<String, AssociationOptions> entry : collectionHandlesToApplyAssociation.entrySet()) {
            
            LOG.error("# " + entry.getKey() + " ---- " + entry.getValue());
        }

        if (result == null) {
            throw new RuntimeException("COMPASS ASSOCIATION ENGINE: COULD NOT FIND ASSOCIATION OPTIONS! collectionHandle = " + collectionHandle);
        }

        return result;
    }

    public List modify_doDropDown_valueList_jspui_method(
            int pageNumber,
            Collection collection,
            String collectionHandle,
            Item itemToBeSubmitted) throws SQLException {

        final AssociationOptions associationOptions = this.getAssociationOptions(collectionHandle);

        //find the extraction approach...
        ExtractionRule extractionRule = associationOptions.getExtractionRulePerPageMap().get(pageNumber);
        if (extractionRule == null) {
            return Collections.emptyList();
        }
        
        //extract the items based on extraction rule...
        List<Tupple2> items = strategyExtractorDispatcher.getItems(extractionRule, collection);

        LOG.error("CompassHelper#modify_doDropDown_valueList_jspui_method --> pageNumber: " + pageNumber + ", collection: "
                + collection + ", collectionHandle: " + collectionHandle
                + ", items size: " + items.size());

        if (associationOptions.isApplyAssociation() && !isEmpty(items)) {

            LOG.error("CompassHelper#modify_doDropDown_valueList_jspui_method --> passed association options check!");

            List<String> itemsFromSameCollection = new ArrayList<>();

            if (!associationOptions.getExtractionRulePerPageMap().keySet().contains(pageNumber)) {
                //leave dropdown control as it is...
                return Collections.emptyList();
            }

            //time to populate our list with items from the same collection....
            boolean hasResults = false;
            for (Tupple2 tupple2Record : items) { //for every tupple....

                String collectionName = tupple2Record.getCollection().getName();

                LOG.error("CompassHelper#modify_doDropDown_valueList_jspui_method --> collectionName: " + collectionName + ", items size: " + tupple2Record.getItems().size());

                for (Item tempItem : tupple2Record.getItems()) {//for every item of current tupple perform...

                    //get the [value item]...
                    String retrievedItemIdStr
                            = ItemIdExtractor.extractFromDcIdentifierUriTheHandleUrl(tempItem)
                            + CONCATENATOR_SYMBOL
                            + ItemIdExtractor.extractId(tempItem);

                    //get the [display item]...
                    Metadatum[] metadatums = ItemMetadatumExtractor.extractIdentifierOrTitleMetadatumFromItem(tempItem);

                    if (metadatums != null && metadatums.length > 0) {
                        final int INDEX = 0;//TODO fix in form to enter only one! [FIXED]
                        Metadatum learningOpportunityMetadatum = metadatums[INDEX];
                        String learningOpportunitySpecificationTitle = learningOpportunityMetadatum.value;

                        LOG.error("CompassHelper#modify_doDropDown_valueList_jspui_method --> DEBUGGINGGGG " + learningOpportunitySpecificationTitle + " - [" + collectionName + "]");

                        //first we enter [display item], and then [value item]...
                        itemsFromSameCollection.add(learningOpportunitySpecificationTitle + " - [" + collectionName + "]");
                        itemsFromSameCollection.add(retrievedItemIdStr);

                        hasResults = true;
                    }
                }//for.

            }//for.
            if (hasResults) {
                return itemsFromSameCollection;
            }
        }
        return Arrays.asList(NO_LEARNING_OPPORTUNITY_SPECIFICATIONS_EXIST_LABEL,
                NO_LEARNING_OPPORTUNITY_SPECIFICATIONS_EXIST_VALUE);

    }

    private boolean isEmpty(List<Tupple2> tupples) {

        if (tupples == null) {
            LOG.error("CompassHelper#isEmpty --> out of 1");
            return true;
        }
        if (tupples.isEmpty()) {
            LOG.error("CompassHelper#isEmpty --> out of 2");
            return true;
        }

        for (Tupple2 t : tupples) {
            if (t.getItems() == null) {
                LOG.error("CompassHelper#isEmpty --> out of 3");

                return true;
            }
            if (t.getItems().isEmpty()) {
                LOG.error("CompassHelper#isEmpty --> out of 4");
                return true;
            }
        }
        return false;
    }
}
