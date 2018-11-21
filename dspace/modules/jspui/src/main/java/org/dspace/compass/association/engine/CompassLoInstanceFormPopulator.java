package org.dspace.compass.association.engine;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.dspace.compass.association.extractor.util.ItemMetadatumExtractor;
import org.dspace.compass.schema.LearningOpportunity;
import org.dspace.compass.schema.form.LOInstanceFormDb;
import org.dspace.content.Item;
import org.dspace.content.Metadatum;
import org.dspace.core.Context;

/**
 *  Used by COMPASS ASSOCIATION ENGINE.
 * 
 * @author Anastasios Tsolakidis.
 * @author Nikolaos Christidis.
 */
public class CompassLoInstanceFormPopulator implements Serializable {

    private static final Logger LOG = Logger.getLogger(CompassLoInstanceFormPopulator.class);

    private static final long serialVersionUID = -1190252704302430344L;
    
    private final Set<Integer> pagesToApplyFunction;
    
    public CompassLoInstanceFormPopulator() {
        pagesToApplyFunction = new HashSet<>();
        pagesToApplyFunction.add(2);//page with number 2.
        pagesToApplyFunction.add(3);//page with number 3.
    }

    public Item getSelectedLOSpecificationFromSpecifierAttributeOfLOInstance(
            String labelName, 
            int pageNumber,
            Item itemToBeSubmitted, 
            Context context) throws SQLException {

        LOG.error("start");
        
        if (!LOInstanceFormDb.isFieldToPrepopulate(labelName)) {
            LOG.error("out from 1");
            return null;
        }

        
        if (!pagesToApplyFunction.contains(pageNumber)) {
            LOG.error("out from 2");
            return null;
        }

        LOG.error("second page in loinstance");

        Metadatum[] ms = itemToBeSubmitted.getMetadata(LearningOpportunity.COMPASS_SCHEMA_NAME,
                LearningOpportunity.LEARNING_OPPORTUNITY_ELEMENT_NAME,
                LearningOpportunity.SPECIFIES,
                LearningOpportunity.EN_US);

        if (ms == null || ms.length == 0) {

            LOG.error("not retrieved specifies");
            return null;

        } else {

            String value = ms[0].value; //this will have the format: 123456789/21#72
            LOG.error("value: " + value);

            String loSpecificationItemId = value.split("#")[1];
            LOG.error("loSpecificationItemId: " + loSpecificationItemId);

            Item loSpecification = Item.find(context, Integer.parseInt(loSpecificationItemId));
            LOG.error("loSpecification: " + (loSpecification != null));

            //JUST TO SEE IF IT WORKS CORRECTLY!!!
            Metadatum[] mds = ItemMetadatumExtractor.extractIdentifierOrTitleMetadatumFromItem(loSpecification);
            LOG.error("LOSPEC ID || TITLE: " + mds[0].value);

            return loSpecification;
        }
    }

}
