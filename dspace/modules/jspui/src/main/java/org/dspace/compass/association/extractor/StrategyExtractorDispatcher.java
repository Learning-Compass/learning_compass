package org.dspace.compass.association.extractor;

import java.sql.SQLException;
import java.util.List;
import org.dspace.compass.association.extractor.core.FetchLoSpecificationsForLoInstanceExtractor;
import org.dspace.compass.association.extractor.core.ItemsFromSameCollectionExtractor;
import org.dspace.compass.association.extractor.core.StrategyExtractor;
import org.dspace.compass.association.rules.ExtractionRule;
import org.dspace.compass.association.util.Tupple2;
import org.dspace.content.Collection;

/**
 *
 * @author Anastasios Tsolakidis.
 * @author Nikolaos Christidis.
 */
public class StrategyExtractorDispatcher {

    //initialize strategies...
    private final StrategyExtractor itemsFromSameCollection = new ItemsFromSameCollectionExtractor();
    private final StrategyExtractor fetchLoSpecificationsForLoInstanceExtractor = new FetchLoSpecificationsForLoInstanceExtractor();

    
    //--------------------------methods------------------------------------------------------------------------------
    
    public List<Tupple2> getItems(ExtractionRule extractionRule, Collection collection) throws SQLException {

        switch (extractionRule) {

            case ITEMS_FROM_SAME_COLLECTION:
                return itemsFromSameCollection.getAllItemsFromCollection(collection);

            case LOSPECIFICATIONS_FOR_SELECTED_LO_INSTANCE:
                return fetchLoSpecificationsForLoInstanceExtractor.getAllItemsFromCollection(collection);
        }

        throw new RuntimeException("COMPASS ASSOCIATION ENGINE: COULD NOT FIND EXTRACTION RULE -> ASSOCIATION OPTIONS! collectionHandle= " +
                collection.getHandle());
    }

}
