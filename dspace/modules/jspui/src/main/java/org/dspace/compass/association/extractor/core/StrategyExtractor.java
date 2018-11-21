/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dspace.compass.association.extractor.core;

import java.sql.SQLException;
import java.util.List;
import org.dspace.compass.annotation.Pattern;
import org.dspace.compass.annotation.Patterns;
import org.dspace.compass.association.util.Tupple2;
import org.dspace.content.Collection;

/**
 *
 * @author Anastasios Tsolakidis.
 * @author Nikolaos Christidis.
 */
@Pattern(value = Patterns.STRATEGY)
public interface StrategyExtractor {
 
    public List<Tupple2> getAllItemsFromCollection(Collection collection) throws SQLException;
}
