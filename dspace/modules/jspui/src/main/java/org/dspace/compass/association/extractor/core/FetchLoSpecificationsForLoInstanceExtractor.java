package org.dspace.compass.association.extractor.core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import org.dspace.compass.association.util.Tupple2;
import org.dspace.content.Collection;
import org.dspace.content.Community;
import org.dspace.content.Item;
import org.dspace.content.ItemIterator;

/**
 *
 * @author Anastasios Tsolakidis.
 * @author Nikolaos Christidis.
 */
public class FetchLoSpecificationsForLoInstanceExtractor implements StrategyExtractor {

    private static final Logger LOG = Logger.getLogger(FetchLoSpecificationsForLoInstanceExtractor.class);

    private static final String LEARNING_OPPORTUNITY_SPECIFICATION_SUFFIX = "Specifications";

    
    /*
        This method works as explained below:

        For example if we have a collection with name Postgraduate Courses and there we are going to 
        define 
     */
    @Override
    public List<Tupple2> getAllItemsFromCollection(Collection collection) throws SQLException {

        final String collectionNameToCompare = collection.getName();

        final List<Tupple2> items = new ArrayList<>();

        LOG.error("CompassHelper#getLOSpecificationsForLOInstance --> HERE!");

        for (Community c : Arrays.asList(collection.getCommunities())) {//for every community....

            LOG.error("CompassHelper#getLOSpecificationsForLOInstance --> first: " + c.getName());

            for (Collection col : Arrays.asList(c.getCollections())) {//for every collection of the selected community.....

                String collectionNameToBeCompared = col.getName();
                if (!collectionNameToBeCompared.contains(LEARNING_OPPORTUNITY_SPECIFICATION_SUFFIX)) {
                    continue;
                }

                LOG.error("collection(name) = " + collection.getName()); //Instances
                LOG.error("collectionName = " + collectionNameToBeCompared); //Specifications
                
                //collectionNameToBeCompared = collectionNameToBeCompared.replaceAll(LEARNING_OPPORTUNITY_SPECIFICATION_SUFFIX, "");

                LOG.error("CompassHelper#getLOSpecificationsForLOInstance --> second: " + col.getName());
                LOG.error("CompassHelper#getLOSpecificationsForLOInstance --> second to comp: " + collection.getName());

                if (collectionNameToBeCompared.equals(collectionNameToCompare) 
                        || Collections.singletonMap("Instances", "Specifications").containsKey(collection.getName())) {
                    LOG.error("CompassHelper#getLOSpecificationsForLOInstance --> strike a match!");

                    List<Item> tempListItems = new ArrayList<>();

                    ItemIterator ii = col.getAllItems();//grab the items from this collection....
                    while (ii.hasNext()) {
                        Item i = ii.next();

                        LOG.error("CompassHelper#getLOSpecificationsForLOInstance --> third(1): " + i.getName());
                        LOG.error("CompassHelper#getLOSpecificationsForLOInstance --> third(2): " + i);

                        tempListItems.add(i);
                    }//while.

                    items.add(new Tupple2(col, tempListItems));//and save them....

                } else {
                    LOG.error("CompassHelper#getLOSpecificationsForLOInstance --> not strike a match!");
                }

            }//for.
        }//for.

        LOG.error("CompassHelper#getLOSpecificationsForLOInstance --> tupplelist size: " + items.size());

        for (Tupple2 t : items) {
            LOG.error("CompassHelper#getLOSpecificationsForLOInstance --> collection name: " + t.getCollection().getName()
                    + ", items size: " + t.getItems().size());
        }

        return items;

    }

}
