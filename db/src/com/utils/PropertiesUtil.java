
package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesUtil {
    private Properties properties=new Properties();
    //文件在class根目录
    public PropertiesUtil(String propertiesfile) {
        InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesfile);
        try {
            properties.load(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
   public String getvalue(String key){
      return (String)properties.get(key);
    }
}
