package org.dspace.compass.schema.form;

import java.util.HashMap;
import java.util.Map;
import org.dspace.compass.schema.LearningOpportunity;
import org.dspace.content.Item;
import org.dspace.content.Metadatum;

/**
 * Used by COMPASS ASSOCIATION ENGINE.
 * 
 * @author Anastasios Tsolakidis.
 * @author Nikolaos Christidis.
 */
public class LOInstanceFormDb {

    //add the labels of the fiels you wish to populate....
    private static final Map<String, LOInstanceFormAction> FIELDS_TO_POPULATE = new HashMap<>();

    static {

        FIELDS_TO_POPULATE.put("Contributor", new LOInstanceFormAction() {
            @Override
            public Metadatum[] extractCorrectInfoFromLOSpec(Item itemToFetchData) {
                return itemToFetchData.getMetadata(
                        LearningOpportunity.DC_SCHEMA_NAME,
                        LearningOpportunity.CONTRIBUTOR,
                        null,
                        LearningOpportunity.EN_US);
            }
        });

        FIELDS_TO_POPULATE.put("Creator", new LOInstanceFormAction() {
            @Override
            public Metadatum[] extractCorrectInfoFromLOSpec(Item itemToFetchData) {
                return itemToFetchData.getMetadata(
                        LearningOpportunity.DC_SCHEMA_NAME,
                        LearningOpportunity.CREATOR,
                        null,
                        LearningOpportunity.EN_US);
            }
        });

        FIELDS_TO_POPULATE.put("Date", new LOInstanceFormAction() {
            @Override
            public Metadatum[] extractCorrectInfoFromLOSpec(Item itemToFetchData) {
                return itemToFetchData.getMetadata(
                        LearningOpportunity.DC_SCHEMA_NAME,
                        LearningOpportunity.DATE,
                        null,
                        LearningOpportunity.EN_US);
            }
        });

        FIELDS_TO_POPULATE.put("Description", new LOInstanceFormAction() {
            @Override
            public Metadatum[] extractCorrectInfoFromLOSpec(Item itemToFetchData) {
                return itemToFetchData.getMetadata(
                        LearningOpportunity.DC_SCHEMA_NAME,
                        LearningOpportunity.DESCRIPTION,
                        null,
                        LearningOpportunity.EN_US);
            }
        });

        FIELDS_TO_POPULATE.put("Format", new LOInstanceFormAction() {
            @Override
            public Metadatum[] extractCorrectInfoFromLOSpec(Item itemToFetchData) {
                return itemToFetchData.getMetadata(
                        LearningOpportunity.DC_SCHEMA_NAME,
                        LearningOpportunity.FORMAT,
                        null,
                        LearningOpportunity.EN_US);
            }
        });

        FIELDS_TO_POPULATE.put("Identifier", new LOInstanceFormAction() {
            @Override
            public Metadatum[] extractCorrectInfoFromLOSpec(Item itemToFetchData) {

                return itemToFetchData.getMetadata(
                        LearningOpportunity.DC_SCHEMA_NAME,
                        LearningOpportunity.IDENTIFIER,
                        null,
                        LearningOpportunity.EN_US);
            }
        });

        FIELDS_TO_POPULATE.put("Language", new LOInstanceFormAction() {
            @Override
            public Metadatum[] extractCorrectInfoFromLOSpec(Item itemToFetchData) {

                return itemToFetchData.getMetadata(
                        LearningOpportunity.DC_SCHEMA_NAME,
                        LearningOpportunity.LANGUAGE,
                        null,
                        LearningOpportunity.EN_US);
            }
        });

        FIELDS_TO_POPULATE.put("Publisher", new LOInstanceFormAction() {
            @Override
            public Metadatum[] extractCorrectInfoFromLOSpec(Item itemToFetchData) {

                return itemToFetchData.getMetadata(
                        LearningOpportunity.DC_SCHEMA_NAME,
                        LearningOpportunity.PUBLISHER,
                        null,
                        LearningOpportunity.EN_US);
            }
        });

        FIELDS_TO_POPULATE.put("Equivalent", new LOInstanceFormAction() {
            @Override
            public Metadatum[] extractCorrectInfoFromLOSpec(Item itemToFetchData) {

                return itemToFetchData.getMetadata(
                        LearningOpportunity.DC_SCHEMA_NAME,
                        LearningOpportunity.RELATION,
                        null,
                        LearningOpportunity.EN_US);
            }
        });

        FIELDS_TO_POPULATE.put("Rights", new LOInstanceFormAction() {
            @Override
            public Metadatum[] extractCorrectInfoFromLOSpec(Item itemToFetchData) {

                return itemToFetchData.getMetadata(
                        LearningOpportunity.DC_SCHEMA_NAME,
                        LearningOpportunity.RIGHTS,
                        null,
                        LearningOpportunity.EN_US);
            }
        });

        FIELDS_TO_POPULATE.put("Source", new LOInstanceFormAction() {
            @Override
            public Metadatum[] extractCorrectInfoFromLOSpec(Item itemToFetchData) {

                return itemToFetchData.getMetadata(
                        LearningOpportunity.DC_SCHEMA_NAME,
                        LearningOpportunity.SOURCE,
                        null,
                        LearningOpportunity.EN_US);
            }
        });

        FIELDS_TO_POPULATE.put("Subject", new LOInstanceFormAction() {
            @Override
            public Metadatum[] extractCorrectInfoFromLOSpec(Item itemToFetchData) {

                return itemToFetchData.getMetadata(
                        LearningOpportunity.DC_SCHEMA_NAME,
                        LearningOpportunity.SUBJECT,
                        null,
                        LearningOpportunity.EN_US);
            }
        });

        FIELDS_TO_POPULATE.put("Title", new LOInstanceFormAction() {
            @Override
            public Metadatum[] extractCorrectInfoFromLOSpec(Item itemToFetchData) {

                return itemToFetchData.getMetadata(
                        LearningOpportunity.DC_SCHEMA_NAME,
                        LearningOpportunity.TITLE,
                        null,
                        LearningOpportunity.EN_US);
            }
        });

        FIELDS_TO_POPULATE.put("Type", new LOInstanceFormAction() {
            @Override
            public Metadatum[] extractCorrectInfoFromLOSpec(Item itemToFetchData) {

                return itemToFetchData.getMetadata(
                        LearningOpportunity.DC_SCHEMA_NAME,
                        LearningOpportunity.TYPE,
                        null,
                        LearningOpportunity.EN_US);
            }
        });

        FIELDS_TO_POPULATE.put("Outcomes", new LOInstanceFormAction() {
            @Override
            public Metadatum[] extractCorrectInfoFromLOSpec(Item itemToFetchData) {

                return itemToFetchData.getMetadata(
                        LearningOpportunity.COMPASS_SCHEMA_NAME,
                        LearningOpportunity.LEARNING_OPPORTUNITY_SPECIFICATION_ELEMENT_NAME,
                        LearningOpportunity.OBJECTIVE,
                        LearningOpportunity.EN_US);
            }
        });

        FIELDS_TO_POPULATE.put("Prerequisite Learning Outcomes", new LOInstanceFormAction() {
            @Override
            public Metadatum[] extractCorrectInfoFromLOSpec(Item itemToFetchData) {

                return itemToFetchData.getMetadata(
                        LearningOpportunity.COMPASS_SCHEMA_NAME,
                        LearningOpportunity.LEARNING_OPPORTUNITY_SPECIFICATION_ELEMENT_NAME,
                        LearningOpportunity.PREREQUISITE,
                        LearningOpportunity.EN_US);
            }
        });
           FIELDS_TO_POPULATE.put("Prerequisite Competences", new LOInstanceFormAction() {
            @Override
            public Metadatum[] extractCorrectInfoFromLOSpec(Item itemToFetchData) {

                return itemToFetchData.getMetadata(
                        LearningOpportunity.COMPASS_SCHEMA_NAME,
                        LearningOpportunity.LEARNING_OPPORTUNITY_SPECIFICATION_ELEMENT_NAME,
                        LearningOpportunity.COMPETENCE,
                        LearningOpportunity.EN_US);
            }
        });

        FIELDS_TO_POPULATE.put("URL", new LOInstanceFormAction() {
            @Override
            public Metadatum[] extractCorrectInfoFromLOSpec(Item itemToFetchData) {

                return itemToFetchData.getMetadata(
                        LearningOpportunity.COMPASS_SCHEMA_NAME,
                        LearningOpportunity.LEARNING_OPPORTUNITY_SPECIFICATION_ELEMENT_NAME,
                        LearningOpportunity.URL,
                        LearningOpportunity.EN_US);
            }
        });

    }

    public static boolean isFieldToPrepopulate(String labelName) {
        return FIELDS_TO_POPULATE.keySet().contains(labelName);
    }

    public static LOInstanceFormAction getFieldExtractor(String labelName) {
        return FIELDS_TO_POPULATE.get(labelName);
    }
}
