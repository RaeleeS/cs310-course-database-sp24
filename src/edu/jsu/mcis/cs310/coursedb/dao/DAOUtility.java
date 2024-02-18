package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {
    
    public static final int TERMID_FA24 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {

                ResultSetMetaData mdata = rs.getMetaData();
                int count = mdata.getColumnCount();
                
                while(rs.next()) {
                    JsonObject row = new JsonObject();
                    for (int i = 1; i <= count; i++) {
                        String columnName = mdata.getColumnName(i);
                        Object columnValue = rs.getObject(i);
                        row.put(columnName, columnValue.toString());
                    }
                    
                    records.add(row);
                    
                }

            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}
