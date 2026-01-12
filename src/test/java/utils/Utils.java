package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static int generateRandomNumber(int min, int max){
        double randomNumber=Math.random()*(max-min)+min;
        return (int) Math.round(randomNumber);
    }
    public static void saveJSONData(String firstName, String email, String password, String phoneNumber) throws IOException, ParseException {
        String filePath="./src/test/resources/Users.json";
        JSONParser jsonParser=new JSONParser();
        JSONArray jsonArray= (JSONArray) jsonParser.parse(new FileReader(filePath));
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("firstName",firstName);
        jsonObject.put("email",email);
        jsonObject.put("password",password);
        jsonObject.put("phoneNumber",phoneNumber);

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

}
