import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class getTwitter {
	public static void twitterGetter () {
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
                String tweetTime = rs.getString("Tweet_Time");
                String txt = rs.getString("txt");
                String emotion  = rs.getString("JEmotion");

                System.out.println(ST_AsText);                
                System.out.println(tweetTime);
                System.out.println(txt);
                System.out.println(emotion);
            }
          
            // gracefully close record set, statement and connection
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQLException occurred:\n");
            e.printStackTrace();
            
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException occurred:\n");
            e.printStackTrace();   
        }    	
    }
	
	
	}


