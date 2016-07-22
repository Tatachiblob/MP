import java.util.ArrayList;
public class Section {
    
    private String section_name;
    private String faculty;
    private String schedule;
    private String start_time;
    private String end_time;
    private int capacity;
    
    
    public Section(String name, String faculty, String schedue, String start, String end, int capacity){
        this.section_name = name;
        this.faculty = faculty;
        this.schedule = schedue;
        this.start_time = start;
        this.end_time = end;
        this.capacity = capacity;
    }
    
    public boolean isValidSchedule(){//returns true if valid
        return schedule.equals("MW") || schedule.equals("TH");
    }
    
    public boolean isThreeChar(){//returns true if three characters;
        return section_name.length() == 3;
    }
    
}
