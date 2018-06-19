package playermgmt;

import org.junit.*;
import static org.junit.Assert.*;

public class DBTest{
    @Test
    public void DBConnect()throws Exception{
        assertNotNull(PlayermgmtDatabaseConnection.dbConnection());
    }
}