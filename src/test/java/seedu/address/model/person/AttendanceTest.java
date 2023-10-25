package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class AttendanceTest {
    @Test
    public void constructor_validAttendanceString_success() {
        Attendance attendance = new Attendance("0,1,0,1,0,1,0,1,0,1,0,1", Attendance.ORIGINAL_PART);
        assertEquals(12, attendance.getTotalWeeks());
        assertEquals(6, attendance.getWeeksPresent());
    }

    @Test
    public void isValidWeek_validWeekNumber_returnsTrue() {
        assertTrue(Attendance.isValidTutorial("1"));
        assertTrue(Attendance.isValidTutorial("12"));
    }

    @Test
    public void isValidWeek_invalidWeekNumber_returnsFalse() {
        assertFalse(Attendance.isValidTutorial("0"));
        assertFalse(Attendance.isValidTutorial("13"));
        assertFalse(Attendance.isValidTutorial("invalid"));
    }

    @Test
    public void isValidParticipation_validInput_true() {
        assertTrue(Attendance.isValidParticipation("0"));
        assertTrue(Attendance.isValidParticipation("100"));
    }

    @Test
    public void isValidParticipation_invalidInput_false() {
        assertFalse(Attendance.isValidParticipation("-1"));
        assertFalse(Attendance.isValidParticipation("abc"));
    }

    @Test
    public void markAttendance_validWeek_success() {
        Attendance attendance = new Attendance(Attendance.ORIGINAL_ATD, Attendance.ORIGINAL_PART);
        attendance.markAttendance(1);
        assertTrue(attendance.isMarkedWeek(1));
    }

    @Test
    public void unmarkAttendance_validWeek_success() {
        Attendance attendance = new Attendance(Attendance.ORIGINAL_ATD, Attendance.ORIGINAL_PART);
        attendance.unmarkAttendance(1);
        assertFalse(attendance.isMarkedWeek(1));
    }

    @Test
    public void addParticipationPoints_success() {
        Attendance attendance = new Attendance(Attendance.ORIGINAL_ATD, Attendance.ORIGINAL_PART);
        attendance.inputParticipationPoints(1, 350);
        assertEquals(350, attendance.getParticipationPoints(1));
    }

    @Test
    public void isMarkedWeek_markedWeek_returnsTrue() {
        Attendance attendance = new Attendance("1,0,0,0,0,0,0,0,0,0,0,0", Attendance.ORIGINAL_PART);
        assertTrue(attendance.isMarkedWeek(0));
    }

    @Test
    public void isMarkedWeek_unmarkedWeek_returnsFalse() {
        Attendance attendance = new Attendance(Attendance.ORIGINAL_ATD, Attendance.ORIGINAL_PART);
        assertFalse(attendance.isMarkedWeek(1));
    }

    @Test
    public void convertToIntegerWeek_validWeekString_success() {
        int week = Attendance.convertToIntegerWeek("5");
        assertEquals(5, week);
    }

    @Test
    public void convertToIntegerWeek_invalidWeekString_throwsException() {
        assertThrows(NumberFormatException.class, () -> Attendance.convertToIntegerWeek("invalid"));
    }

    @Test
    public void equals_sameObject_returnsTrue() {
        Attendance attendance = new Attendance(Attendance.ORIGINAL_ATD, Attendance.ORIGINAL_PART);
        assertTrue(attendance.equals(attendance));
    }

    @Test
    public void equals_sameValues_returnsTrue() {
        Attendance attendance1 = new Attendance(Attendance.ORIGINAL_ATD, Attendance.ORIGINAL_PART);
        Attendance attendance2 = new Attendance(Attendance.ORIGINAL_ATD, Attendance.ORIGINAL_PART);
        assertTrue(attendance1.equals(attendance2));
    }

    @Test
    public void equals_differentValues_returnsFalse() {
        Attendance attendance1 = new Attendance(Attendance.ORIGINAL_ATD, Attendance.ORIGINAL_PART);
        Attendance attendance2 = new Attendance("1,0,0,0,0,0,0,0,0,0,0,0", Attendance.ORIGINAL_PART);
        assertFalse(attendance1.equals(attendance2));
    }

    @Test
    public void equals_differentTypes_returnsFalse() {
        Attendance attendance = new Attendance(Attendance.ORIGINAL_ATD, Attendance.ORIGINAL_PART);
        assertFalse(attendance.equals(1));
    }
    @Test
    public void hashCodeTest() {
        Attendance attendance = new Attendance(Attendance.ORIGINAL_ATD, Attendance.ORIGINAL_PART);
        assertEquals(attendance.hashCode(), attendance.hashCode());
    }
}
