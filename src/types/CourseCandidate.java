package types;

import java.util.ArrayList;

public class CourseCandidate {
    
    public String courseName;
    public ArrayList<String> potentialTimes = new ArrayList<String>(20);
    public String bestTime = null;
    public CourseCandidate next = null;
    public CourseCandidate bNext = null;
    public CourseCandidate cNext = null;
    public CourseCandidate cPrev = null;

    public CourseCandidate(String name) {
        courseName = name;
    }


}