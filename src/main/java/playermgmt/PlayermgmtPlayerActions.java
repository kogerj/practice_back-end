package playermgmt;

import java.sql.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PlayermgmtPlayerActions{
        static public Object ChangeBanStatus(String updateBanstatus){
            try{ 
                Connection cn = PlayermgmtDatabaseConnection.dbConnection();
                JSONParser parser = new JSONParser();
                JSONObject json = (JSONObject) parser.parse(updateBanstatus);
                JSONArray array = new JSONArray();
                Long id = (Long) json.get("id");
                //int id=163;
                boolean ban = (Boolean) json.get("ban");
                String ban_reason = json.get("ban_reason").toString();
                String ban_end_dt = json.get("ban_end_dt").toString();
                String banQuery = "UPDATE users SET ban=?, ban_reason=?, ban_end_dt=? WHERE id=?";
                PreparedStatement st = cn.prepareStatement(banQuery);
                st.setBoolean(1, ban);
                
                if (ban==false) {
                    st.setNull(2, Types.VARCHAR);
                    st.setNull(3, Types.TIMESTAMP);
                }else{
                    st.setString(2, ban_reason);
                    st.setString(3, ban_end_dt);
                }
                st.setLong(4, id);
                int rowsUpdated = st.executeUpdate();
                if (rowsUpdated==0){
                    cn.close();
                    return null;
                }
                JSONObject response = new JSONObject();
                response.put("rows_affected", rowsUpdated);
                array.add(response);
                cn.close();
                return array;

            }catch(Exception e){
                e.printStackTrace(System.out);
               // System.out.println(e.getStackTrace().toString());
                return null;
            }
           
        }
}