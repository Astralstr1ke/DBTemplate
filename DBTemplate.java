import java.sql.*;
import java.util.Properties;

public class DBTemplate
{
    private static String databaseName =""; // <- Indsæt database navnet her
    private static String userName=""; // <- indsæt bruger navnet på SSMS login
    private static String password=""; // <- indæt password på SSMS login
    private static String port=""; //<- indsæt porten i bruger i SSMS, default er 1433

    private static String url="jdbc:sqlserver://localhost:"+port+";databaseName="+databaseName;
    private static Properties properties = new Properties();






    private static DBTemplate dbTemplate = null;
    private DBTemplate()
    {
        properties.setProperty("user", userName);
        properties.setProperty("password", password);

        // Set the SSL properties
        properties.setProperty("encrypt", "false");
    }

    public static DBTemplate getDbTemplate() {
        if (dbTemplate == null)
        dbTemplate = new DBTemplate();

        return dbTemplate;
    }

    public Connection makeConnection() throws SQLException {

        Connection conn = DriverManager.getConnection(url,properties);
        return conn;
    }

    public String getUrl() {
        return url;
    }
    public Properties getProperties()
        {
            return properties;
        }
}

