package seedu.address.model.person;

/**
 * The `Attendance` class represents a student's attendance, attendance status
 * and participation record for a 12-week period.
 * It provides methods for managing and querying attendance information.
 */
public class Attendance {
    public static final String TUTORIAL_ERROR_MSG = "Tutorial number is out of range, should be integer between 1-12";
    public static final String PARTICIPATION_ERROR_MSG = "PP number is out of range, should be >= 0";
    public static final String STATUS_ERROR_MSG = "Status is invalid! It should either be P, VR or A.";
    public static final String ORIGINAL_ATD = "U,U,U,U,U,U,U,U,U,U,U,U";
    public static final String ORIGINAL_PART = "0,0,0,0,0,0,0,0,0,0,0,0";
    private static int totalTut = 12;
    private final int[] participationList = new int[totalTut];
    private final AttendanceStatus[] attendanceList = new AttendanceStatus[totalTut];


    /**
     * Constructs an `Attendance` object from a comma-separated attendance string.
     *
     * @param atd A comma-separated string representing attendance for 12 weeks (e.g., "0,1,0,2,0,3,0,1,0,1,0,1").
     * @param pp A comma-separated string representing participation for 12 weeks (e.g., "120,0,100,130,110,150,100,100,
     *           0,150,150,120").
     */
    public Attendance(String atd, String pp) {
        String[] atdArr = atd.split(",");
        String[] ppArr = pp.split(",");
        for (int i = 0; i < totalTut; i++) {
            attendanceList[i] = new AttendanceStatus(i);
            participationList[i] = Integer.parseInt(ppArr[i]);
            switch (atdArr[i]) {
            case "A":
                attendanceList[i].setAbsent();
                break;
            case "P":
                attendanceList[i].setPresent();
                break;
            case "VR":
                attendanceList[i].setVR();
                break;
            default:
            }
        }
    }

    /**
     * Checks if a given week is a valid tutorial number (between 1 and the maximum tutorial count).
     * @param tutorial A string representing a tutorial number.
     * @return `true` if the week is valid; otherwise, `false`.
     */
    public static boolean isValidTutorial(String tutorial) {
        if (!tutorial.matches("[0-9]++")) {
            return false;
        }

        int week = 0;

        week = Integer.parseInt(tutorial);
        return week > 0 && week <= totalTut;
    }

    /**
     * Checks if the participation points is a valid value (Non-negative integer).
     * @param pp String version of points to be checked
     * @return 'true' if points is valid, else 'false'.
     */
    public static boolean isValidParticipation(String pp) {
        final int points;
        try {
            points = Integer.parseInt(pp);
        } catch (NumberFormatException e) {
            return false;
        }
        return points >= 0;
    }

    /**
     * Checks if the status string is a valid status.
     * @param status The status string.
     * @return 'true' if the status is valid, else 'false'.
     */
    public static boolean isValidStatus(String status) {
        return status.equals("P") || status.equals("A") || status.equals("VR");
    }

    /**
     * Returns the number of weeks for which attendance was marked.
     * @return The count of weeks marked for attendance.
     */
    public int getWeeksPresent() {
        int count = 0;
        for (int i = 0; i < 12; i++) {
            if (this.attendanceList[i].statusString().equals("U")
                    || this.attendanceList[i].statusString().equals("A")) {
                continue;
            }
            count++;
        }
        return count;
    }

    /**
     * Returns the total number of tutorial weeks.
     * @return the total number of tutorial weeks.
     */
    public int getTotalWeeks() {
        return this.totalTut;
    }

    /**
     * Returns the total sum of participation points.
     * @return the total sum of participation points.
     */
    public int getTotalPart() {
        int sum = 0;
        for (int pp : participationList) {
            sum += pp;
        }
        return sum;
    }

    /**
     * Marks a specific tutorial with the given status.
     * @param tutorial The week to mark as attended (1-12).
     * @param status The status to mark the week as.
     */
    public void markAttendance(int tutorial, String status) {
        switch(status) {
        case "A":
            attendanceList[tutorial].setAbsent();
            break;
        case "VR":
            attendanceList[tutorial].setVR();
            break;
        case "P":
            attendanceList[tutorial].setPresent();
            break;
        default:
        }
    }

    /**
     * Unmarks a specific tutorial as attended.
     * @param tutorial The week to unmark (1-12).
     */
    public void unmarkAttendance(int tutorial) {
        this.attendanceList[tutorial].unMark();
    }

    /**
     * Checks if a specific tutorial is marked as attended.
     * @param tutorial The week to check (1-12).
     * @return `true` if the week is marked as attended; otherwise, `false`.
     */
    public boolean isMarkedWeek(int tutorial) {
        return this.attendanceList[tutorial].isMarked();
    }

    /**
     * Returns a styled representation of an attendance list
     * using the specified symbols for positive and negative attendance.
     * @param absent The symbol to represent absent attendance status.
     * @param present The symbol to represent present attendance status.
     * @param vr The symbol to represent VR attendance status.
     * @param unknown The symbol to represent unknown attendance status.
     * @return A stylized representation of the attendance list with symbols indicating respective attendance status.
     */
    public String getStyledStatusList(String absent, String present, String vr, String unknown) {
        StringBuilder styledList = new StringBuilder();
        for (int i = 0; i < totalTut; i++) {
            String toAppend;
            if (attendanceList[i].isAbsent) {
                toAppend = absent;
            } else if (attendanceList[i].isPresent) {
                toAppend = present;
            } else if (attendanceList[i].isVR) {
                toAppend = vr;
            } else {
                toAppend = unknown;
            }

            if (i == totalTut - 1) {
                styledList.append(toAppend);
                continue;
            }

            styledList.append(toAppend).append("|");
        }

        return styledList.toString();
    }

    /**
     * Converts a tutorial represented as a string to an integer.
     *
     * @param tutorial A string representing a tutorial number.
     * @return The week number as an integer.
     */
    public static int convertToIntegerWeek(String tutorial) {
        return Integer.parseInt(tutorial);
    }

    /**
     * Give participation points to the given tutorial.
     *
     * @param tut tutorial to add points
     * @param pp value to add
     */
    public void inputParticipationPoints(int tut, int pp) {
        this.participationList[tut] = pp;
    }

    /**
     * Return the participation points of the given week.
     * @param tut A string representing a tutorial number
     * @return the participation points of the given week.
     */
    public int getParticipationPoints(int tut) {
        return this.participationList[tut];
    }

    /**
     * Gets the total number of marked tutorials.
     * @return The total number of tutorials with marked attendances.
     */
    public int getTotalMarkedTut() {
        int markedTut = 0;

        for (AttendanceStatus status : attendanceList) {
            markedTut += status.isMarked() ? 0 : 1;
        }

        return markedTut;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Attendance)) {
            return false;
        }

        Attendance otherAttendance = (Attendance) other;
        return atdToString().equals(otherAttendance.atdToString()) && ppToString().equals(otherAttendance.ppToString());
    }

    /**
     * Converts attendanceList to a string, where each attendance is separated by a comma.
     *
     * @return string version of attendancelist
     */
    public String atdToString() {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < totalTut - 1; i++) {
            s.append(this.attendanceList[i].statusString()).append(",");
        }

        s.append(this.attendanceList[totalTut - 1].statusString());
        return s.toString();
    }

    /**
     * Converts participationList to a string, where each participation is separated by a comma.
     *
     * @return string version of participationlist
     */
    public String ppToString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.participationList.length - 1; i++) {
            s.append(this.participationList[i]).append(",");
        }
        if (this.participationList.length > 0) {
            s.append(this.participationList[this.participationList.length - 1]);
        }
        return s.toString();
    }

    /**
     * Converts students participation record to a string.
     *
     * @return String version of Attendance message to be shown
     */
    public String listParticipation() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.totalTut; i++) {
            s.append(String.format("Tutorial %d: [%s], Participation Points: [%d]\n",
                    i + 1, this.attendanceList[i].statusString(), this.participationList[i]));
        }
        return s.toString();
    }

    /**
     * Converts Attendance to a string.
     *
     * @return string version of Attendance
     */
    public String toString() {
        return String.format("Attendance: %s | Participation: %s", atdToString(), ppToString());
    }

    /**
     * Internal class to represent a single attendance.
     */
    private class AttendanceStatus {
        private int index;

        private boolean isPresent = false;

        private boolean isAbsent = false;

        private boolean isVR = false;

        private boolean isUnmarked = true;

        /**
         * Constructs a single instance of AttendanceStatus.
         * @param index The index (week) of the single attendance.
         */
        public AttendanceStatus(int index) {
            this.index = index;
        }

        /**
         * Sets the current status of the AttendanceStatus as present.
         */
        public void setPresent() {
            this.isUnmarked = false;
            this.isAbsent = false;
            this.isVR = false;
            this.isPresent = true;
        }

        /**
         * Sets the current status of the AttendanceStatus as absent.
         */
        public void setAbsent() {
            this.isUnmarked = false;
            this.isAbsent = true;
            this.isVR = false;
            this.isPresent = false;
        }

        /**
         * Sets the current status of the AttendanceStatus as VR.
         */
        public void setVR() {
            this.isUnmarked = false;
            this.isAbsent = false;
            this.isVR = true;
            this.isPresent = false;
        }

        /**
         * Unmarks the instance of AttendanceStatus
         */
        public void unMark() {
            this.isUnmarked = true;
            this.isAbsent = false;
            this.isVR = false;
            this.isPresent = false;
        }

        public boolean isMarked() {
            return !isUnmarked;
        }

        /**
         * Returns the attendance status as a String.
         * @return The status as a String.
         */
        public String statusString() {
            return isUnmarked ? "U" : isAbsent ? "A" : isVR ? "VR" : "P";
        }

        @Override
        public String toString() {
            return index
                    + statusString();
        }
    }
}
