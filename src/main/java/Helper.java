import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Helper {

 static JSONArray helperParse(String file) throws IOException, ParseException {
     //Creating a JSONParser object
     JSONParser jsonParser = new JSONParser();
     ArrayList<Building> buildings = new ArrayList<>();
     JSONArray jsonArray = new JSONArray();
     try {
         jsonArray = (JSONArray) jsonParser.parse(new FileReader(file));
     }catch (Exception e){
         System.out.println("Exception");
     }
     return jsonArray;


 }
 static void helperRead(){
     JsonDemo demo =new JsonDemo();
     ArrayList<Building>buildings =demo.parseFile("file.json") ;

     for(int i=0;i<buildings.size();i++) {
         System.out.println("Name " + i + ": " + buildings.get(i).getBlName());
         System.out.println("City " + i + ": " + buildings.get(i).getCity());
         System.out.println("FoundationYear " + i + ": " + buildings.get(i).getFoundationYear());
         System.out.println("========================");

     }
 }


 }

