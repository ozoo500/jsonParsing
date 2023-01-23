import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.json.*;
import java.io.*;
import java.util.*;

public class JsonDemo {
    File f = new File("file.json");

    public ArrayList<Building> parseFile(String fileName) {
        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();
        ArrayList<Building> buildings = new ArrayList<>();
        JSONArray jsonArray = new JSONArray();
        try {

            jsonArray = (JSONArray) jsonParser.parse(new FileReader(fileName));
            //Forming URL
            //Retrieving the array
         if(jsonArray.isEmpty()){
             System.out.println("File is Empty");
         }else {
            System.out.println("Building details: ");
            Iterator iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObjec = (JSONObject) iterator.next();
                String blName = (String) jsonObjec.get("BlName");
                String city = (String) jsonObjec.get("city");
                String FoundationYear = (String) jsonObjec.get("FoundationYear");
                buildings.add(new Building(blName, city, FoundationYear));
            }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return buildings;
    }

    public void writeJson(String fileName) throws IOException, ParseException {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter  name :");
        String name = myObj.nextLine();
        System.out.println("Enter  city :");
        String city = myObj.nextLine();
        System.out.println("Enter  Foundation year :");
        String FoundationYear= myObj.nextLine();
        Building building =new Building(name,city,FoundationYear);

      // JsonObjectBuilder builder = Json.createObjectBuilder();
       Map<String,String> builder=new LinkedHashMap<>();
        JSONArray array = Helper.helperParse("file.json");
        builder.put("BlName", building.getBlName());
        builder.put("city",building.getCity());
        builder.put("FoundationYear", building.getFoundationYear());
      //  JsonObject data = builder.build();
        array.add(builder);

        try {

            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(array.toJSONString());
            fileWriter.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("JSON file created: " + array);
    }



    public String returnSearchByCity(String searchValue) throws IOException, ParseException {
        JSONArray array=Helper.helperParse("file.json");
        JSONArray filtedArray = new JSONArray();
        JSONObject object=new JSONObject();
        Iterator iterator = array.iterator();
        while (iterator.hasNext()) {
            JSONObject jsonObjec = (JSONObject) iterator.next();
            String blName = (String) jsonObjec.get("BlName");
            String city = (String) jsonObjec.get("city");
            String FoundationYear = (String) jsonObjec.get("FoundationYear");
            if(city.equals(searchValue)){
                object.put("BlName",blName);
                object.put("FoundationYear",FoundationYear);
                filtedArray.add(object);
            }
        }
        String result = filtedArray.toString();
        return result;
    }

    public String returnSearchByFoundationYear(String searchValue) throws IOException, ParseException {
        JSONArray array=Helper.helperParse("file.json");
        JSONArray filtedArray = new JSONArray();
        JSONObject object= new JSONObject();
        Iterator iterator = array.iterator();
        while (iterator.hasNext()) {
            JSONObject jsonObjec = (JSONObject) iterator.next();
            String blName = (String) jsonObjec.get("BlName");
            String city = (String) jsonObjec.get("city");
            String FoundationYear = (String) jsonObjec.get("FoundationYear");
            if(FoundationYear.equals(searchValue)){
               object.put("BlName",blName);
               object.put("city",city);
               filtedArray.add(object);

            }
        }
        String result = filtedArray.toString();
        return result;
    }
    public
    void removeElement(int index) throws IOException, ParseException {
        JSONArray array=Helper.helperParse("file.json");
            array.remove(index);
        System.out.println(array);
        FileWriter fileWriter = new FileWriter("file.json");
        fileWriter.write(String.valueOf(array));
        fileWriter.close();


    }
}
