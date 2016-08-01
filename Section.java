//Inoue, Yuta   Salva, Trisha
import java.util.ArrayList;
public class Section {
    
    private String sectionName;
    private String faculty;
    private String schedule;
    private String startTime;
    private String endTime;
    private int capacity;
    private ArrayList<Student> students;
    private Course course;
    
        
    public Section(String name, String faculty, String schedule, String start, String end, int capacity){
        this.sectionName = name;
        this.faculty = faculty;
        this.schedule = schedule;
        this.startTime = start;
        this.endTime = end;
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }
    
    public String getStartTime(){return startTime;}
    public String getEndTime(){return endTime;}
    public String getSectionName(){return sectionName;}
    public String getFaculty(){return faculty;}
    public int getCapacity(){return capacity;}
    public ArrayList<Student> getStudents(){return students;}
    public Course getCourse(){return course;}
    public void setCourse(Course c){
        this.course = c;
    }
    
    public boolean isFull(){//returns true if the capacity is full and used for enlisting
        return capacity <= students.size();
    }
    
    public boolean isValidSchedule(){//returns true if valid and used for opening section
        return schedule.equals("MW") || schedule.equals("TH");
    }
    
    public boolean isValidTime(){
        return startTime.matches("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$") && endTime.matches("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$");
    }
    
    public boolean isNonConflic(Section s){//returns false if there is a conflic in schedule and used for enlisting

        int start = toMin(startTime);
        int end = toMin(endTime);
        int otherStart = toMin(s.startTime);
        int otherEnd = toMin(s.endTime);
        if(start >= end || otherStart >= otherEnd){
            return false;
        }//ex) start 7:30 end 6:00
        
        //think it over again
        if(this.schedule .equals(s.schedule)){//MW or TH
            if(start == otherStart || end == otherEnd || (end >= otherStart && start <= otherStart)
                || (start <= otherEnd && end >= otherEnd) || (end >= otherEnd && otherStart >= start) 
                || (otherEnd >= end && start >= otherStart) )
                return false; 
        }
        return true;
    }
    
    public boolean isUnique(Section s){//returns true if Unique
        return !(this.sectionName .equals(s.sectionName));
    }
    
    public boolean isThreeChar(){//returns true if three characters and used for opening section
        return sectionName.matches("\\w{3}");
    }
    
    private int toMin(String time){
        int min = 0;
        int index = time.indexOf(":");
        int hh = Integer.parseInt(time.substring(0, index));
        int mm = Integer.parseInt(time.substring(index + 1));
        min = (hh * 60) + mm;
        return min;
    }
    
    private String toHHMM(int min){
        String hhmm = "";
        int hh = min / 60;
        int mm = min % 60;
        hhmm = hh + ":" + mm;
        if(mm == 0)
            hhmm = hh + ":" + "00";
        return hhmm;
    }
    
    //for checking purpose
    public void display(){
        System.out.println("\tCouse: " + course.getCode());
        System.out.println("\tSection Name: " + sectionName);
        System.out.println("\tFaculty: " + faculty);
        System.out.println("\tSchedule: " + schedule);
        System.out.println("\tStart Time: " + startTime);
        System.out.println("\tEnd Time: " + endTime);
        System.out.println("\tCapacity: " + capacity);
    }
    
    //testing testing
    
    public static void main(String[] args) {
        Course c = new Course("INTPRG2", "Programming", 2);
        Course c2 = new Course("ARHC-OS", "Architecture", 0);
        Section s = new Section("S12", "Shirley Chu", "MW", "10:00", "12:00", 12);
        Section s1 = new Section("S12", "Roger Uy", "MW", "10:00", "12:00", 12);
    }
    
}
