import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        JsonDemo demo = new JsonDemo();
        Scanner input = new Scanner(System.in);

                int choice;
                while (true){
                    System.out.println("Json Operation");
                    System.out.println("=================");
                    System.out.println("1-Read JsonArray\n2-Add new Building\n3-search By specific city\n4-Search By Foundation Year\n5-Delete Item\n6-Exit");
                    choice = input.nextInt();
                    if(choice==1) {
                        Helper.helperRead();
                    }

                    else if(choice==2){
                        demo.writeJson("file.json");

                    }
                    else if(choice==3){
                        System.out.println("Enter city name");
                        String city = input.next();
                        String res =demo.returnSearchByCity(city);
                        System.out.println(res);

                    }
                    else if(choice==4){
                        System.out.println("Enter  Foundation Year");
                        String FoundationYear = input.next();
                        String res =demo.returnSearchByFoundationYear(FoundationYear);
                        System.out.println(res);

                    }

                    else if(choice==5){
                        System.out.println("Enter num of building you want to delete");
                        int num = input.nextInt();
                        demo.removeElement(num);
                    }
                    else if(choice==6)
                        break;
                    else
                        System.out.println("Invalid input");
                }
            }
        }









