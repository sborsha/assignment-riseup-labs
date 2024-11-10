package utils;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class Utils {
    public static int generateRandomNumber(int min, int max){
        double randomId= Math.random()*(max-min)+min;
        return (int) randomId;
    }

    public static String geneateRandomEmail() throws IOException, ParseException {

        JSONParser parser=new JSONParser();
        JSONArray jsonArray= (JSONArray) parser.parse(new FileReader("./src/test/resources/users.json"));
        int num = jsonArray.size()+1;
        String originalEmail = "safiaborsha2566+" + num  + "@gmail.com";
        return originalEmail;
    }

    public static void saveUserInfo(String filePath, JSONObject jsonObject) throws IOException, ParseException {
        JSONParser jsonParser=new JSONParser();
        JSONArray jsonArray= (JSONArray) jsonParser.parse(new FileReader(filePath));
        jsonArray.add(jsonObject);
        FileWriter fileWriter=new FileWriter(filePath);
        fileWriter.write(jsonArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }

    public static void scroll(WebDriver driver , int w , int h){
        JavascriptExecutor js =  (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+w+","+h+")", "" );
    }

}
