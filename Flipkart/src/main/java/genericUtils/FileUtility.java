package genericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.PropertyFilePath);
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}

}
