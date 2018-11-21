package org.dspace.compass.association.extractor.core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.dspace.compass.association.util.Tupple2;
import org.dspace.content.Collection;
import org.dspace.content.Item;
import org.dspace.content.ItemIterator;

/**
 *
 * @author Anastasios Tsolakidis.
 * @author Nikolaos Christidis.
 */
public class ItemsFromSameCollectionExtractor implements StrategyExtractor {

    /*
     {selected}                    {to_get_retrived}
     [COLLECTION] -----{0..*}------ [ITEM]
     */
    @Override
    public List<Tupple2> getAllItemsFromCollection(Collection collection) throws SQLException {

        final List<Tupple2> items = new ArrayList<>();

        List<Item> bufferItems = new ArrayList<>();

        //add all items from provided collection in a buffer....
        ItemIterator ii = collection.getAllItems();
        while (ii.hasNext()) {
            Item i = ii.next();
            bufferItems.add(i);
        }

        //save collection and it's items in a tupple...
        items.add(new Tupple2(collection, bufferItems));

        return items;
    }

}
