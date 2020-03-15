import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public String parseHamletToLeon(String data){
        Pattern p = Pattern.compile("(HAMLET)");
        Pattern p2 = Pattern.compile("(Hamlet)");
        Matcher m = p.matcher(data);
        Matcher m2 = p2.matcher(m.replaceAll("LEON"));
        return this.hamletData = m2.replaceAll("Leon");
    }

    public boolean findHamlet(String data){
        Pattern p = Pattern.compile("(HAMLET)");
        Pattern p2 = Pattern.compile("(Hamlet)");
        Matcher m = p.matcher(data);
        if(!m.find())
            m = p2.matcher(data);

        return m.find();
    }

    public String parseHoratioToTariq(String data){
        Pattern p = Pattern.compile("(HORATIO)");
        Pattern p2 = Pattern.compile("(Horatio)");
        Matcher m = p.matcher(data);
        Matcher m2 = p2.matcher(m.replaceAll("TARIQ"));
        return this.hamletData = m2.replaceAll("Tariq");
    }

    public boolean findHoratio(String data){
        Pattern p = Pattern.compile("(HORATIO)");
        Pattern p2 = Pattern.compile("(Horatio)");
        Matcher m = p.matcher(data);
        if(!m.find())
            m = p2.matcher(data);

        return m.find();
    }

    public boolean findPattern(String data ,String... str){
        for (String s:str) {
            Pattern p = Pattern.compile("("+s+")");
            if(p.matcher(data).find())
                return true;
        }
        return false;
    }


}
