// Java 
import java.util.ArrayList;

// Custom
import types.CourseCandidate;

public class CourseManager {

        ArrayList<String> courseNames = new ArrayList<String>(10);
        ArrayList<String> curTimes = new ArrayList<String>(20);
        CourseCandidate head = null;
        CourseCandidate tail = null;
        

        public void addCourse(String courseName) {
            this.courseNames.add(courseName);
            if (head == null) {
                head = new CourseCandidate(courseName);
                tail = head;
            } else {
                tail.next = new CourseCandidate(courseName);
                tail = tail.next;
            }
        }

        public void addCourse(CourseCandidate course) {
            this.courseNames.add(course.courseName);
            if (head == null) {
                head = course;
                tail = head;
            } else {
                tail.cNext = course;
                tail.cNext.cPrev = tail;
                tail = tail.cNext;
            }
        }

        public void addTime(String courseTime) {
            tail.potentialTimes.add(courseTime);
        }

        /* Utilized during testing, prints all courses and possible times */
        public void printList() {
            CourseCandidate curCourse = head;

            while (curCourse != null) {
                System.out.println(curCourse.courseName);
                for (String time : curCourse.potentialTimes) {
                    System.out.print(time + "   ");
                }
                System.out.println("\n--");
                curCourse = curCourse.next;
            }
        }

        public int size() {
            int counter = 0;
            CourseCandidate currCourse = this.head;
            while (currCourse != null) {
                counter++;
                currCourse = currCourse.next;
            }
            return counter;
        }

        public void erase() {
            this.head = null;

        }

        public void copy(CourseManager schedule) { 
            // Creates Best schedule from the passed in temp schedule
            this.erase();

            CourseCandidate curCourse = schedule.head; 

            for (int timeCounter = 0; timeCounter < schedule.curTimes.size(); timeCounter++) { 

                this.addCourse(curCourse); 
                curCourse.bNext = curCourse.cNext; 

                curCourse.bestTime = schedule.curTimes.get(timeCounter);

                curCourse = curCourse.cNext;

            }
            return;
        }

        public void printUnassigned(CourseManager allCourses) {

            ArrayList<String> notInList = new ArrayList<String>(10);

            System.out.println("\n---Courses With a Time Conflict---");
            for (int counter = 0; counter < allCourses.courseNames.size(); counter++) {

                if (!this.courseNames.contains(allCourses.courseNames.get(counter))) {
                    notInList.add(allCourses.courseNames.get(counter));
                }
            }

            CourseCandidate ogCourse = allCourses.head;

            for (int counter = 0; counter < allCourses.size(); counter++) {
                if (notInList.contains(ogCourse.courseName)) {
                    System.out.print(ogCourse.courseName + " ");

                    for (String time : ogCourse.potentialTimes) {
                        System.out.print(time + " ");
                    }
                }

                ogCourse = ogCourse.next;
            }

        }

        public void printBestSchedule() {

            CourseCandidate currCourse = this.head;

            System.out.println("---Course Schedule---");

            while (currCourse != null) {
                System.out.println(currCourse.courseName + " " + currCourse.bestTime);
                currCourse = currCourse.bNext;
            }
        }

        public void removeLast() {

            if (this.head == this.tail) {
                return;
            } else {
                this.tail = this.tail.cPrev;
                this.tail.cNext = null;

                this.curTimes.remove((this.curTimes.size() - 1));
            }
        }
    }