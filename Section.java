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
    
    public boolean isFull(){//returns true if the capacity is full
        return capacity < students.size();
    }
    
    public boolean isValidSchedule(){//returns true if valid
        return schedule.equals("MW") || schedule.equals("TH");
    }
    
    public boolean isNonConflict(Section s){//returns false if there is a conflic in schedule
        int start = toMin(startTime);
        int end = toMin(endTime);
        int otherStart = toMin(s.startTime);
        int otherEnd = toMin(s.endTime);
        if(this.schedule .equals(s.schedule)){//MW or TH
            if(start == otherStart || end == otherEnd || (end >= otherStart && start <= otherStart)
                || (start <= otherEnd && end >= otherEnd) || (end >= otherEnd && otherStart >= start) 
                || (otherEnd >= end && start >= otherStart) )
                return false; 
        }
        return true;
    }
    
    public boolean isThreeChar(){//returns true if three characters;
        return sectionName.length() == 3;
    }
    //Don't add this in the UML yet
    private int toMin(String time){
        int min = 0;
        int index = time.indexOf(":");
        int hh = Integer.parseInt(time.substring(0, index));
        int mm = Integer.parseInt(time.substring(index + 1));
        
        min = (hh * 60) + mm;
        return min;
    }
    
    //testing testing
    /*public static void main(String[] args) {
        Section s = new Section("s15", "Ms.Chierly Chu", "TH", "6:00", "7:00", 20);
        Section s2 = new Section("s15", "Ms.Chierly Chu", "TH", "9:00","10:00", 20);
        System.out.println(s.isNonConflic(s2));
        System.out.println(s2.isNonConflic(s));
    }*/
    
}
