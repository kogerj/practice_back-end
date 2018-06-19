package playermgmt;
import java.io.*;
import java.sql.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PlayermgmtAdminLogin{
    
    static public Object AdminLogin(String loginRequest){
        
        try{       
            Connection cn = PlayermgmtDatabaseConnection.dbConnection();
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(loginRequest);
            String username = json.get("username").toString();
            String password = json.get("password").toString();
            String login = "SELECT id, password, last_login_dt, moderator FROM admins WHERE username=?";
            PreparedStatement preparedStatement = cn.prepareStatement(login);
            preparedStatement.setObject(1, username);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()) {
                if (rs.getString("password").equals(password)) {
                    JSONObject loginQuery = new JSONObject();
                    loginQuery.put("id", rs.getInt("id"));
                    loginQuery.put("last_login_dt", rs.getDate("last_login_dt"));
                    loginQuery.put("moderator", rs.getBoolean("moderator"));
                    cn.close();
                    return loginQuery;
                }
            }
            cn.close();
            return null;

        }catch(Exception e){
            System.out.println(e);
            return null;
        }

    }
}
