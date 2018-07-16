package eotpackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKBReader;

public class getTwitter {
	public static double twitterGetter () {
Connection conn = null; // declare the connection object

        try {
            Class.forName("org.postgresql.Driver"); // the JDBC driver is dynamically loaded at runtime
            String url = "jdbc:postgresql://ZGIS221.geo.sbg.ac.at/lv856152_153";
            String username = "sgroup01";
            String password = "salzach2017$";
            conn = DriverManager.getConnection(url, username, password); // initialization of the connection object

            String query = "SELECT * FROM resch.twitter;"; // SQL query
            

            Statement statement = conn.createStatement(); // statement object based on the given connection
            ResultSet rs = statement.executeQuery(query); // rs object contains the result of the query

            while (rs.next()) // iterate as long as a next row in the result set exits
            {
            	String ST_AsText = rs.getString("geom");
            	
            	
            	//convert the wkb-format of the coordinates to wkt-format (=POINT (xx/yy))
        		byte[] aux = WKBReader.hexToBytes(ST_AsText);	
        		Geometry geom = null;
				try {
					geom = new WKBReader().read(aux);
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		String wktString = geom.toText();
            	

                

                
		        String ohnePoint = wktString.substring(7,wktString.length()-1);
		        
		        String[] split = ohnePoint.split(" ");
	        	double coordinatesLon = Double.parseDouble(split[0]);
	        	double coordinatesLat = Double.parseDouble(split[1]);
                
                
	        	System.out.println("Lat: " + coordinatesLat + ", Lon:" + coordinatesLon); 
	        	
	        	double[] transformedCoordinates = CoordinatesTransformer.transformCoordinates(coordinatesLon, coordinatesLat);

	        	float x = (float) transformedCoordinates[0];
	            float y = (float) transformedCoordinates[1];
	            

	        	
	        	System.out.println("T: " + x + ", " + y + "\n");
	        	return (double) x;
//			    TimeSeriesVisualiser point = new TimeSeriesVisualiser();
//	            point.setup(x,y);
            }
          
            // gracefully close record set, statement and connection
            rs.close();
            statement.close();
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("SQLException occurred:\n");
            e.printStackTrace();
            
        } catch (ClassNotFoundException e) {
            System.out.println("Lol ClassNotFoundException occurred:\n");
            e.printStackTrace();   
        }

		//		return null; 
        
    }
	
	
	}


