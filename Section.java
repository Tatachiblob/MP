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
    
    public boolean isFull(){//returns true if the capacity is full and used for enlisting
        return capacity < students.size();
    }
    
    public boolean isValidSchedule(){//returns true if valid and used for opening section
        return schedule.equals("MW") || schedule.equals("TH");
    }
    
    public boolean isValidTime(String time){//return true if time is valid
        boolean ok = false;
        int index = time.indexOf(":");
        String hh = time.substring(0, index);
        int mm = Integer.parseInt(time.substring(index + 1));
        
        switch(hh){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
            case "11":
            case "12":
            case "13":
            case "14":
            case "15":
            case "16":
            case "17":
            case "18":
            case "19":
            case "20":
            case "21":
            case "22":
            case "23":
            case "0":
            case "00":
                ok = mm >= 0 && mm < 60;
                break;
        }
        return ok;
    }
    
    public boolean isNonConflic(Section s){//returns false if there is a conflic in schedule and used for enlisting
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
    
    public boolean isUnique(Section s){//returns true if Unique
        return !(this.sectionName .equals(s.sectionName));
    }
    
    public boolean isThreeChar(){//returns true if three characters and used for opening section
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
    //Don't add this in UML yet
    private String toHHMM(int min){
        String hhmm = "";
        int hh = min / 60;
        int mm = min % 60;
        hhmm = hh + ":" + mm;
        if(mm == 0)
            hhmm = hh + ":" + "00";
        return hhmm;
    }
    
    public void display(){
        System.out.println("\tSection Name: " + sectionName);
        System.out.println("\tFaculty: " + faculty);
        System.out.println("\tSchedule: " + schedule);
        System.out.println("\tStart Time: " + startTime);
        System.out.println("\tEnd Time: " + endTime);
        System.out.println("\tCapacity: " + capacity);
    }
    
    //testing testing
    /*
    public static void main(String[] args) {
    }
    */
}
