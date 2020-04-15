package MVCdemo.Model;
import java.util.*;
import java.sql.*;

public class CoffeeExpert
{
    public String getBrands(String colour) throws Exception
    {
        try
        {
            String user = "root";
            String password = "";
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iplab?autoReconnect=true&useSSL=false", user, password);
            
            Statement st = con.createStatement();
            String sql = "select * from coffeedetails where colour = \'" + colour + "\'";
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next())
            {
                String res = rs.getString("brand");
                return res;
            }
            else
            {
                return "0";
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
            return "0";
        }
    }
}
