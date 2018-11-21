package org.dspace.compass.schema.form;

import org.dspace.compass.annotation.Pattern;
import org.dspace.compass.annotation.Patterns;
import org.dspace.content.Item;
import org.dspace.content.Metadatum;

/**
 *
 * @author Anastasios Tsolakidis.
 * @author Nikolaos Christidis.
 */
@Pattern(value = Patterns.STRATEGY)
public interface LOInstanceFormAction {
    
    Metadatum[] extractCorrectInfoFromLOSpec(Item itemToFetchData);
}
