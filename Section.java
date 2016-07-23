//Inoue, Yuta   Salva, Trisha
import java.util.ArrayList;
public class Section {
    
    private String sectionName;
    private String faculty;
    private String schedule;
    private String startTime;
    private String endTime;
    private int capacity;
    
    
    public Section(String name, String faculty, String schedule, String start, String end, int capacity){
        this.sectionName = name;
        this.faculty = faculty;
        this.schedule = schedule;
        this.startTime = start;
        this.endTime = end;
        this.capacity = capacity;
    }
    
    public boolean isValidSchedule(){//returns true if valid
        return schedule.equals("MW") || schedule.equals("TH");
    }
    
    public boolean isThreeChar(){//returns true if three characters;
        return sectionName.length() == 3;
    }
    
}
