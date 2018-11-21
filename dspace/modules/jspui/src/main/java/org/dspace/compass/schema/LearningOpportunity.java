package org.dspace.compass.schema;

/**
 *  [NEEDS REFACTOR!]
 * @author Anastasios Tsolakidis.
 * @author Nikolaos Christidis.
 * 
 */
public class LearningOpportunity {
    
    public static final String EN_US = "en_US";

    public static final String COMPASS_SCHEMA_NAME = "compass";
    public static final String DC_SCHEMA_NAME = "dc";

    public static final String LEARNING_OPPORTUNITY_SPECIFICATION_ELEMENT_NAME = "learningOpportunitySpecification";
    public static final String LEARNING_OPPORTUNITY_ELEMENT_NAME = "learningOpportunity";
    

    //-----------------------QUALIFIERS DECLARATION(SPECIFICATION - LOS)--------------------------
    //dc related...
    public static final String CONTRIBUTOR = "contributor";
    //COVERAGE
    public static final String CREATOR = "creator";
    public static final String DATE = "date";
    public static final String DESCRIPTION = "description";
    public static final String FORMAT = "format";
    public static final String IDENTIFIER = "identifier";
    public static final String LANGUAGE = "language";
    public static final String PUBLISHER = "publisher";
    public static final String RELATION = "relation";
    public static final String RIGHTS = "rights";
    public static final String SOURCE = "source";
    public static final String SUBJECT = "subject";
    public static final String TITLE = "title";
    public static final String TYPE = "type";
    //learningOpportunitySpecification related...
    public static final String ASSESSMENT = "assessment";
    public static final String CREDIT = "credit";
    public static final String HAS_PART = "hasPart";
    public static final String LEVEL = "level";
    public static final String OBJECTIVE = "objective";
    public static final String PREREQUISITE = "prerequisite";
    public static final String QUALIFICATION = "qualification";
    public static final String URL = "url";
    
       public static final String COMPETENCE = "competence";
    //-------------------------------------------------------------------------------------

    
    //---------------------QUALIFIERS DECLARATION(INSTANCE - LOI)--------------------------
    //dc related...
    //CONTRIBUTOR
    //COVERAGE
    //CREATOR
    //DATE
    //DESCRIPTION
    //FORMAT
    //IDENTIFIER
    //LANGUAGE
    //PUBLISHER
    //RELATION
    //RIGHTS
    //SOURCE
    //SUBJECT
    //TITLE
    //TYPE
    //learningOpportunity related...
    public static final String COST = "cost";
    public static final String DURATION = "duration";
    public static final String ENGAGEMENT = "engagement";
    //HAS_PART
    public static final String LANGUAGE_OF_INSTRUCTION = "languageOfInstruction";
    public static final String LOCATION = "location";
    //OBJECTIVE
    public static final String PLACES = "places";
    //PREREQUISITE    
    public static final String SPECIFIES = "specifies";
    public static final String START = "start";
    //URL
    //------------------------------------------------------------------------------------------
    
}
