import java.io.*;

import types.CourseCandidate;

public class App {

    public static void findBestSchedule(CourseManager uCourses, CourseManager bestSchedule, CourseManager currSchedule,
        CourseCandidate currCourse, String time) {
        
        boolean addCourse = true; 
        int timeIndex = currCourse.potentialTimes.indexOf(time) ;

        // skip time slots where higher priority courses don't get added.
        while (currSchedule.curTimes.contains(time)) { 

            if (timeIndex + 1 == currCourse.potentialTimes.size()){
                addCourse = false;
                break;
            }
            timeIndex++;
            time = currCourse.potentialTimes.get(timeIndex);
        }

        if (addCourse) {
            currSchedule.curTimes.add(time);
            currSchedule.addCourse(currCourse);
        }

        if (currCourse.next != null) {
            // check all time slots for remaining classes.
            for (int i = 0; i < currCourse.next.potentialTimes.size(); i++) {
                findBestSchedule(uCourses, bestSchedule, currSchedule, currCourse.next,
                        currCourse.next.potentialTimes.get(i)); 
            }
        }

        // select schedule with the most courses selected.
        if (bestSchedule.size() < currSchedule.size()) {
            bestSchedule.copy(currSchedule);
        }

        // Remove last class added for next recursive cycle.
        if (addCourse) { 
            currSchedule.removeLast();
        }
        return;
    }

    public static void main(String[] args) throws IOException {

        CourseManager choices = new CourseManager();
        CourseManager bestSchedule = new CourseManager();
        CourseManager currSchedule = new CourseManager();

        // file IO.
        File in = null;
        if (args.length > 0) {
            in = new File(args[0]);
        } else {
            System.err.println("Did not recieve a file from command line;");
            System.exit(0);
        }

        BufferedReader reader = new BufferedReader(new FileReader(in));

        String readLine = null;

        // assigns

        while ((readLine = reader.readLine()) != null) {

            String[] individualWords = readLine.split(" ");
            for (int i = 0; i < individualWords.length; i++) {
                if (i == 0) {
                    choices.addCourse(individualWords[i]);
                } else {
                    choices.addTime(individualWords[i]);
                }

            }
        }

        reader.close();

        findBestSchedule(choices, bestSchedule, currSchedule, choices.head,
                choices.head.potentialTimes.get(0));

        bestSchedule.printBestSchedule();
        bestSchedule.printUnassigned(choices);
    }
}
