package seedu.address.model.person;

/**
 * The `Attendance` class represents a student's attendance record for a 12-week period.
 * It provides methods for managing and querying attendance information.
 */
public class Attendance {
    public static final String WEEK_ERROR_MSG = "Week number is out of range, should be integer between 1-12";
    public static final String ORIGINAL_ATD = "0,0,0,0,0,0,0,0,0,0,0,0";
    private int totalWeek;
    private final boolean[] attendanceList = new boolean[12];


    /**
     * Constructs an `Attendance` object from a comma-separated attendance string.
     *
     * @param atd A comma-separated string representing attendance for 1-12 weeks (e.g., "0,1,0,1,0,1,0,1,0,1,0,1").
     */
    public Attendance(String atd) {
        String[] atdArr = atd.split(",");
        this.totalWeek = atdArr.length;
        for (int i = 0; i < totalWeek; i++) {
            if (atdArr[i] == "1") {
                this.attendanceList[i] = true;
            }
        }
    }

    /**
     * Checks if a given week is a valid week number (between 1 and 12).
     *
     * @param week A string representing a week number.
     * @return `true` if the week is valid; otherwise, `false`.
     */
    public static boolean isValidWeek(String week) {
        if (!week.matches("[0-9]+")) {
            return false;
        }
        int intWeek = Integer.parseInt(week);
        if (intWeek <= 0 || intWeek > 12) {
            System.out.println(week);
            return false;
        }
        return true;
    }

    /**
     * Returns the number of weeks present based on the attendance record.
     *
     * @return The count of weeks marked as present.
     */
    public int getWeeksPresent() {
        int count = 0;
        for (int i = 0; i < 12; i++) {
            if (this.attendanceList[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the total number of tutorial weeks.
     *
     * @return the total number of tutorial weeks.
     */
    public int getTotalWeeks() {
        return this.totalWeek;
    }

    /**
     * Marks a specific week as attended.
     *
     * @param week The week to mark as attended (1-12).
     */
    public void markAttendance(int week) {
        this.attendanceList[week] = true;
    }

    /**
     * Unmarks a specific week as attended.
     *
     * @param week The week to unmark (1-12).
     */
    public void unmarkAttendance(int week) {
        this.attendanceList[week] = false;
    }

    /**
     * Checks if a specific week is marked as attended.
     *
     * @param week The week to check (1-12).
     * @return `true` if the week is marked as attended; otherwise, `false`.
     */
    public boolean isMarkedWeek(int week) {
        return this.attendanceList[week];
    }

    /**
     * Converts a week represented as a string to an integer.
     *
     * @param week A string representing a week number.
     * @return The week number as an integer.
     */
    public static int convertToIntegerWeek(String week) {
        return Integer.parseInt(week);
    }

    /**
     * Converts attendanceList to a string.
     *
     * @return string version of attendancelist
     */
    public String toString() {
        String s = "";
        for (boolean atd : this.attendanceList) {
            if (atd) {
                s += "1,";
            } else {
                s += "0,";
            }
        }
        return s.substring(0, 23);
    }
}
