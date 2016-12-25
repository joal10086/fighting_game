package com.utils;

import java.util.Properties;

import org.springframework.beans.factory.FactoryBean;

public class PropertiesEncryptFactoryBean implements FactoryBean {

	private Properties properties;

	public Object getObject() throws Exception {
		return getProperties();
	}

	public Class getObjectType() {
		return java.util.Properties.class;
	}

	public boolean isSingleton() {
		return true;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties inProperties) throws Exception {
		this.properties = inProperties;
//		String originalJdbcUrl = properties.getProperty("jdbcUrl");
		String originalUsername = properties.getProperty("user");
		String originalPassword = properties.getProperty("password");
//		if (originalJdbcUrl != null) {
//			String newJdbcUrl = deEncryptString(originalJdbcUrl);
//			properties.put("jdbcUrl", newJdbcUrl);
//		}		
		if (originalUsername != null) {
			String newUsername = deEncryptString(originalUsername);
			properties.put("user", newUsername);
		}
		if (originalPassword != null) {
			String newPassword = deEncryptString(originalPassword);
			properties.put("password", newPassword);
		}
	}

	private String deEncryptString(String originalString) throws Exception {
		//return new DBEncrypt().dCode(originalString.getBytes());
		DESUtil desu=new DESUtil(Constant.DB_DES_KEY);
		return desu.decryptStr(originalString);
	}

    public static void main(String args[]) {
        try {
            
        	DESUtil desu = new DESUtil("zfmnllf");
            String pe=desu.encryptStr("root");
            String pd=desu.decryptStr(pe);
            System.out.println("密文:"+pe);
            System.out.println("解密:"+pd);

       } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
