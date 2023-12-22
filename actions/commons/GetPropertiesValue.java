package commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class GetPropertiesValue {

    public static String sDirPath = System.getProperty("user.dir");

    public static String getObjectRepository(String pageName, String dataName) {
        Properties pro = new Properties();
        try {
            FileInputStream ip = new FileInputStream(sDirPath + "/testdata/comNopCommercesData/" + pageName + ".properties");
            pro.load(new InputStreamReader(ip, "UTF-8"));
            ip.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String dataValue = pro.getProperty(dataName);
        return dataValue;
    }

}
