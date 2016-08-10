import java.io.*;
import java.util.*;
public class SaveAndLoad {
    
    public void coursesWriter(ArrayList<Course> courses){
        File f = new File("Course.txt");
        BufferedWriter bw;
        
        try{
            bw = new BufferedWriter(new FileWriter(f));
            
            for(Course c : courses){
                bw.write("Course=" + c.getCode());
                bw.newLine();
                bw.write("Name=" + c.getName());
                bw.newLine();
                bw.write("Units=" + Double.toString(c.getUnits()));
                bw.newLine();
            }
            bw.flush();
            bw.close();
            
        }catch(Exception e){
            System.out.println("(SaveAndLoad:courseWriter): " + e.toString());
        }
        
        
    }
    
    public ArrayList<Course> coursesReader(){
        File f = new File("Course.txt");
        
        BufferedReader br;
        String line;
        ArrayList<Course> courses = new ArrayList<>();
        Course c = null;
        
        String code = null;
        String name = null;
        double units = -1;
        try{
            br = new BufferedReader(new FileReader(f));
            while((line = br.readLine()) != null){
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Course")){
                    code = line.substring(line.indexOf('=') + 1);
                }
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Name")){
                    name = line.substring(line.indexOf('=') + 1);
                }
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Units")){
                    units = Double.parseDouble(line.substring(line.indexOf ('=') + 1));
                }
                
                if(units != -1){
                    if(code != null && name != null)
                        c = new Course(code, name, units);
                    else
                        c = new Course(code, units);
                    code = null;
                    name = null;
                    units = -1;
                    courses.add(c);
                }
            }
            br.close();
            
        }catch(Exception e)
        {
            System.out.println("(SaveAndLoad:courseReader): " + e.toString());
        }
        return courses;
    }
    
    public void sectionWriter(ArrayList<Section> section){
        
    }
    
    public ArrayList<Section> sectionsReader(){
        File f = new File("Section.txt");
        
        BufferedReader br;
        String line;
        ArrayList<Course> sections = new ArrayList<>();
        Section s = null;
        Course c = null;
        
        String name = null;
        String faculty = null;
        String schedule = null;
        String start = null;
        String end = null;
        int capacity = -1;
        
        try{
            br = new BufferedReader(new FileReader(f));
            while((line = br.readLine()) != null){
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Section Name")){
                    faculty = line.substring(line.indexOf('=') + 1);
                }
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Faculty")){
                    faculty = line.substring(line.indexOf('=') + 1);
                }
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Schedule")){
                    schedule = line.substring(line.indexOf('=') + 1);
                }
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Start Time")){
                    start = line.substring(line.indexOf('=') + 1);
                }
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("End Time")){
                    end = line.substring(line.indexOf('=') + 1);
                }
                if(line.substring(0, line.indexOf('=')).equalsIgnoreCase("Capacity")){
                    capacity = Integer.parseInt(line.substring(line.indexOf ('=') + 1));
                }
                if(capacity != -1){
                    
                }
            }
            br.close();
            
            }catch(Exception e)
        {
            System.out.println("(SaveAndLoad:sectionReader): " + e.toString());
        }
    }
    
    public static void main(String[] args) {
        
    }
    
}
