package playermgmt;

import java.sql.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PlayermgmtData{
 
    static public Object ReadAllPlayersFromDB(){
      try {
        JSONArray array = new JSONArray();
        Connection cn = PlayermgmtDatabaseConnection.dbConnection();
        Statement st=cn.createStatement();
        ResultSet rs=st.executeQuery("SELECT id, account_id,last_login_dt, nickname, moderator, ban, ban_reason, ban_end_dt, updated_dt, total_play_time, play_time_left, gold, silver, active FROM users LIMIT 400");
        while (rs.next()) { // Creating JSON object for each contact and storing it in JSON array
            JSONObject player = new JSONObject();
            player.put("id", rs.getInt("id"));
            player.put("account_id", rs.getString("account_id"));
            player.put("nickname", rs.getString("nickname"));
            player.put("last_login_dt", rs.getDate("last_login_dt"));
            player.put("moderator", rs.getString("moderator"));
            player.put("ban", rs.getString("ban"));
            player.put("ban_reason", rs.getString("ban_reason"));
            player.put("ban_end_dt", rs.getDate("ban_end_dt"));
            player.put("updated_dt", rs.getDate("updated_dt"));
            player.put("total_play_time", rs.getInt("total_play_time"));
            player.put("play_time_left", rs.getInt("play_time_left"));
            player.put("gold", rs.getInt("gold"));
            player.put("silver", rs.getInt("silver"));
            player.put("active", rs.getString("active"));
            array.add(player);
        }
        cn.close();
        return array;
        
      } catch (Exception e) {
        System.out.println(e);
        return null;
      }

    }
    static public Object ReadAllBannedPlayersFromDB(){
      try {
        JSONArray array = new JSONArray();
      Connection cn = PlayermgmtDatabaseConnection.dbConnection();
      Statement st=cn.createStatement();
      ResultSet rs=st.executeQuery("SELECT id, account_id,last_login_dt, nickname, moderator, ban, ban_reason, ban_end_dt, updated_dt, total_play_time, play_time_left, gold, silver, active FROM users WHERE ban=true");
      while (rs.next()) { // Creating JSON object for each contact and storing it in JSON array
          JSONObject player = new JSONObject();
          player.put("id", rs.getInt("id"));
          player.put("account_id", rs.getString("account_id"));
          player.put("nickname", rs.getString("nickname"));
          player.put("last_login_dt", rs.getDate("last_login_dt"));
          player.put("moderator", rs.getString("moderator"));
          player.put("ban", rs.getString("ban"));
          player.put("ban_reason", rs.getString("ban_reason"));
          player.put("ban_end_dt", rs.getDate("ban_end_dt"));
          player.put("updated_dt", rs.getDate("updated_dt"));
          player.put("total_play_time", rs.getInt("total_play_time"));
          player.put("play_time_left", rs.getInt("play_time_left"));
          player.put("gold", rs.getInt("gold"));
          player.put("silver", rs.getInt("silver"));
          player.put("active", rs.getString("active"));
          array.add(player);
      }
      cn.close();
      return array;
        
      } catch (Exception e) {
        System.out.println(e);
        return null;
      }
      
  }

    static public Object ReadPlayersFromDB(int offset, int limit ){
      try {
        String orderBy = "id";
        String orderDirection = "ASC";
        int count = 0;
        JSONObject json = new JSONObject();
        JSONArray array = new JSONArray();
        Connection cn = PlayermgmtDatabaseConnection.dbConnection();
        Statement st=cn.createStatement();
        // Getting the total count of contacts
        ResultSet countQuery=st.executeQuery("SELECT COUNT(id) AS cCount FROM users");
        while (countQuery.next()){count = countQuery.getInt("cCount");}
        ResultSet rs=st.executeQuery("SELECT id, account_id,last_login_dt, nickname, moderator, ban, ban_reason, ban_end_dt, updated_dt, total_play_time, play_time_left, gold, silver, active FROM users OFFSET "+offset+" LIMIT "+limit+" ORDER BY "+orderBy+" "+orderDirection+"");
        while (rs.next()) { // Creating JSON object for each contact and storing it in JSON array
            JSONObject player = new JSONObject();
            player.put("id", rs.getInt("id"));
            player.put("account_id", rs.getString("account_id"));
            player.put("nickname", rs.getString("nickname"));
            player.put("last_login_dt", rs.getDate("last_login_dt"));
            player.put("moderator", rs.getString("moderator"));
            player.put("ban", rs.getString("ban"));
            player.put("ban_reason", rs.getString("ban_reason"));
            player.put("ban_end_dt", rs.getDate("ban_end_dt"));
            player.put("updated_dt", rs.getDate("updated_dt"));
            player.put("total_play_time", rs.getInt("total_play_time"));
            player.put("play_time_left", rs.getInt("play_time_left"));
            player.put("gold", rs.getInt("gold"));
            player.put("silver", rs.getInt("silver"));
            player.put("active", rs.getString("active"));

            array.add(player);
        }
        cn.close();
        json.put("query", array);
        json.put("count", count);
        return json;
        
      } catch (Exception e) {
        System.out.println(e);
        return null;
      }
        
    }

    static public Object ReadPlayerfromDB(int playerid){
      try {
        Connection cn = PlayermgmtDatabaseConnection.dbConnection();
        Statement st=cn.createStatement();
        JSONArray array = new JSONArray();
        JSONObject player = new JSONObject();
        String playeridSearch = "SELECT id, account_id, last_login_dt, nickname, moderator, ban, ban_reason, ban_end_dt, updated_dt, total_play_time, play_time_left, ban_reason, ban_end_dt, gold, silver, active FROM users WHERE id=" + playerid;
        ResultSet rs=st.executeQuery(playeridSearch);
        if (!rs.isBeforeFirst()){
            cn.close();
            return null;
        }else{ 
        while (rs.next()) {
          player.put("id", rs.getInt("id"));
          player.put("account_id", rs.getString("account_id"));
          player.put("nickname", rs.getString("nickname"));
          player.put("last_login_dt", rs.getDate("last_login_dt"));
          player.put("moderator", rs.getString("moderator"));
          player.put("ban", rs.getString("ban"));
          player.put("ban_reason", rs.getString("ban_reason"));
          player.put("ban_end_dt", rs.getDate("ban_end_dt"));
          player.put("updated_dt", rs.getDate("updated_dt"));
          player.put("total_play_time", rs.getInt("total_play_time"));
          player.put("play_time_left", rs.getInt("play_time_left"));
          player.put("ban_end_dt", rs.getString("ban_end_dt"));
          player.put("gold", rs.getInt("gold"));
          player.put("silver", rs.getInt("silver"));
          player.put("active", rs.getString("active"));
          
          array.add(player);
          }
          cn.close();
          return array;
          }
        
      } catch (Exception e) {
        System.out.println(e);
        return null;
      }
      
      }

      static public Object SearchByNickname(String playerNickname){
        try {
          JSONArray array = new JSONArray();
          Connection cn = PlayermgmtDatabaseConnection.dbConnection();
          Statement st=cn.createStatement();
          String nickNameSearch = "SELECT id, account_id, last_login_dt, nickname, moderator, ban, ban_reason, ban_end_dt, updated_dt, total_play_time, play_time_left, gold, silver, active FROM users WHERE nickname ~* '" + playerNickname +"'";
          ResultSet rs=st.executeQuery(nickNameSearch);
          while (rs.next()) {
            JSONObject player = new JSONObject();
            player.put("id", rs.getInt("id"));
            player.put("account_id", rs.getString("account_id"));
            player.put("nickname", rs.getString("nickname"));
            player.put("last_login_dt", rs.getDate("last_login_dt"));
            player.put("moderator", rs.getString("moderator"));
            player.put("ban", rs.getString("ban"));
            player.put("ban_reason", rs.getString("ban_reason"));
            player.put("ban_end_dt", rs.getDate("ban_end_dt"));
            player.put("updated_dt", rs.getDate("updated_dt"));
            player.put("total_play_time", rs.getInt("total_play_time"));
            player.put("play_time_left", rs.getInt("play_time_left"));
            player.put("ban_end_dt", rs.getString("ban_end_dt"));
            player.put("gold", rs.getInt("gold"));
            player.put("silver", rs.getInt("silver"));
            player.put("active", rs.getString("active"));

            array.add(player);
            }
            cn.close();
            return array;
          
        } catch (Exception e) {
          System.out.println(e);
          return null;
        }
        
      }

     static public Object SearchByField(String searchObject){
      try {
        
        String searchvalue = "o";
        String searchStatement;
        int isInt = 0;
        int isDate = 0;
        JSONArray array = new JSONArray();
        Connection cn = PlayermgmtDatabaseConnection.dbConnection(); 
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(searchObject);
        String column = json.get("column").toString();

        if (column.equals("created_dt") || column.equals("last_login_dt") || column.equals("verified_dt") || column.equals("ban_end_dt") || column.equals("updated_dt")) {
          isDate = 1; 
        }
        try{
          searchvalue = json.get("searchvalue").toString();
          Integer.parseInt(searchvalue);
          isInt = 1;
        }catch(Exception e){
          isInt = 0;
        }

        Statement st=cn.createStatement();
       if (isInt == 0 || isDate == 1 || column.equals("nickname") || column.equals("account_id")) {
          searchStatement = "SELECT id, account_id, last_login_dt, nickname, moderator, ban, ban_reason, ban_end_dt, updated_dt, total_play_time, play_time_left, gold, silver, active FROM users WHERE " + column +"::text ~* '" +  searchvalue + "'";
        }else{
          searchStatement = "SELECT id, account_id, last_login_dt, nickname, moderator, ban, ban_reason, ban_end_dt, updated_dt, total_play_time, play_time_left, gold, silver, active FROM users WHERE " + column +" = " +  searchvalue;
        }
        
        try {
          ResultSet rs=st.executeQuery(searchStatement);
          if (!rs.isBeforeFirst()){
            return null;
          }else{
            while (rs.next()) {
            JSONObject player = new JSONObject();
            player.put("id", rs.getInt("id"));
            player.put("account_id", rs.getString("account_id"));
            player.put("nickname", rs.getString("nickname"));
            player.put("last_login_dt", rs.getDate("last_login_dt"));
            player.put("moderator", rs.getString("moderator"));
            player.put("ban", rs.getString("ban"));
            player.put("ban_reason", rs.getString("ban_reason"));
            player.put("ban_end_dt", rs.getDate("ban_end_dt"));
            player.put("updated_dt", rs.getDate("updated_dt"));
            player.put("total_play_time", rs.getInt("total_play_time"));
            player.put("play_time_left", rs.getInt("play_time_left"));
            player.put("ban_end_dt", rs.getString("ban_end_dt"));
            player.put("gold", rs.getInt("gold"));
            player.put("silver", rs.getInt("silver"));
            player.put("active", rs.getString("active"));

            array.add(player);
            }
            cn.close();
            return array; 
          }
        }catch(org.postgresql.util.PSQLException e) {
          System.out.println(e);
          return array;
        }
        
      } catch (Exception e) {
        System.out.println(e);
        return null;
      }

     }
}