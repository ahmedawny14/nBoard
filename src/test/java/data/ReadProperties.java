package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public  class ReadProperties
{
  public static Properties userData= userProperty(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\userdata.properties");



    public static Properties userProperty(String path)  {

        Properties pro = new Properties();
        // stream for reading file
        try {
            FileInputStream stream = new FileInputStream(path);
            pro.load(stream);
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred :  " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error occurred :  " + e.getMessage());
        }
        catch (NullPointerException e) {
            System.out.println("Error occurred :  " + e.getMessage());
        }

        return pro;


    }









}
