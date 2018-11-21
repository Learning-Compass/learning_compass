package org.dspace.compass.association.extractor.util;

import org.dspace.content.Item;

/**
 * Used by COMPASS ASSOCIATION ENGINE.
 *
 * @author Anastasios Tsolakidis.
 * @author Nikolaos Christidis.
 */
public class ItemIdExtractor {

    public static String extractId(Item item) {
        return String.valueOf(item.getID());
    }

    public static String extractFromDcIdentifierUriTheHandleUrl(Item item) {
        //dc.identifier.uri will contain something like this: http://hdl.handle.net/123456789/8
        String dcIdentifierUri = item.getMetadata("dc", "identifier", "uri", null)[0].value;
        String[] splittedData = dcIdentifierUri.split("/");

        String firstPart = splittedData[splittedData.length - 2];
        String secondPart = splittedData[splittedData.length - 1];

        return firstPart + "/" + secondPart;
    }
}
