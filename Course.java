//Inoue, Yuta   Salva, Trisha
import java.io.*;
import java.util.ArrayList;
public class Course {
    
    private String courseCode;
    private String courseName;
    private double courseUnit;
    
    public Course(String code, String name, double units){
        code = code.toUpperCase();
        this.courseCode = code;
        this.courseName = name;
        this.courseUnit = units;
    }
    
    public String getCode(){return courseCode;}
    public String getName(){return courseName;}
    public double getUnits(){return courseUnit;}
    
    public boolean isSeven(){//returns true if code is 7
        return courseCode.matches("[\\w-]{7}$");
    }
    
    public boolean isNotUnique(Course c){//returns true if not unique
        return this.courseCode.equals(c.courseCode);
    }
    
    //Testing Testing
    
    public static void main(String[] args){
        File f = new File("Course.txt");
        BufferedWriter bw = null;
        BufferedReader br = null;
        try{
            //Writer 
            bw = new BufferedWriter(new FileWriter(f));
            bw.write("INTPRG2");
            bw.newLine();
            bw.write("Programming 2");
            bw.newLine();
            bw.write("3");
            bw.newLine();
            bw.flush();
            bw.close();
            //Reader
            br = new BufferedReader(new FileReader(f));
            if(!f.exists())
                System.out.println("File does not exist");
            System.out.println("Reading Data");
            int i = br.read();
            while(i != -1){
                char c = (char) i;
                System.out.print(c);
                i = br.read();
            }
            System.out.println("End of File");
            br.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        
    }
    
}
