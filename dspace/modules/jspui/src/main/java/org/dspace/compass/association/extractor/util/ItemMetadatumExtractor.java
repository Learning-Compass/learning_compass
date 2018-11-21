package org.dspace.compass.association.extractor.util;

import org.dspace.compass.schema.LearningOpportunity;
import org.dspace.content.Item;
import org.dspace.content.Metadatum;

/**
 * Used by COMPASS ASSOCIATION ENGINE.
 * 
 * @author Anastasios Tsolakidis.
 * @author Nikolaos Christidis.
 */
public class ItemMetadatumExtractor {

    /*
     Extract metadatum TITLE or IDENTIFIER item based on COMPASS SCHEMA (in our case DC schema).
     */
    public static Metadatum[] extractIdentifierOrTitleMetadatumFromItem(Item tempItem) {

        //first try to grab the IDENTIFIER metadata info....
        Metadatum[] metadatums = tempItem.getMetadata(LearningOpportunity.DC_SCHEMA_NAME,
                LearningOpportunity.IDENTIFIER,
                null,
                LearningOpportunity.EN_US);

        //if has not IDENTIFIER metadata info next best choice is TITLE metadata info....
        if (metadatums == null || metadatums.length == 0) {

            metadatums = tempItem.getMetadata(LearningOpportunity.DC_SCHEMA_NAME,
                    LearningOpportunity.TITLE,
                    null,
                    LearningOpportunity.EN_US);
        }

        return metadatums;
    }

}
