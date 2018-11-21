package org.dspace.compass.association.util;

import java.util.List;
import org.dspace.content.Collection;
import org.dspace.content.Item;

/**
 * Used by COMPASS ASSOCIATION ENGINE.
 *
 * @author Anastasios Tsolakidis.
 * @author Nikolaos Christidis.
 */
public final class Tupple2 {

    private Collection collection;
    private List<Item> items;

    public Tupple2(Collection c, List<Item> i) {
        this.collection = c;
        this.items = i;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
