package utils;

import config.UserModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static int generateRandomNumber(int min, int max){
        double randomNumber=Math.random()*(max-min)+min;
        return (int) Math.round(randomNumber);
    }
    public static void saveJSONData(UserModel userModel) throws IOException, ParseException {
        String filePath="./src/test/resources/Users.json";
        JSONParser jsonParser=new JSONParser();
        JSONArray jsonArray= (JSONArray) jsonParser.parse(new FileReader(filePath));
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("firstName",userModel.getFirstname());
        jsonObject.put("lastName",userModel.getLastname());
        jsonObject.put("email",userModel.getEmail());
        jsonObject.put("password",userModel.getPassword());
        jsonObject.put("phoneNumber",userModel.getPhonenumber());
        jsonObject.put("address",userModel.getAddress());

        jsonArray.add(jsonObject);

        FileWriter fileWriter=new FileWriter(filePath);
        fileWriter.write(jsonArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();

    }
    public static JSONObject readJSONData(String filePath) throws IOException, ParseException {
        JSONParser jsonParser=new JSONParser();
        JSONArray jsonArray= (JSONArray) jsonParser.parse(new FileReader(filePath));
        return (JSONObject) jsonArray.get(jsonArray.size()-1);
    }
    public static void scrollDown(WebDriver driver, int px){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, "+px+");");
    }

}
