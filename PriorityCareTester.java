//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Care admission tester
// Course:   CS 300 Spring 2023
//
// Author:   Arnav Srivastav
// Email:    asrivastav3@wisc.edu
// Lecturer:  Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// None
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// None
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// None
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * This is a Utility class which contains tester methods to ensure the correctness of the
 * implementation of the main operations defined in cs300 spring 2023 p10 Priority Care.
 */
public class PriorityCareTester {

    /**
     * Tests whether compareTo() method implemented in PatientRecord returns a positive integer when
     * a
     * higher triage level is compared to a lower triage level, regardless of patient order of
     * arrival. Similarly, this method tests whether compareTo() method implemented in PatientRecord
     * returns a negative integer when a lower triage level is compared to a higher triage level,
     * regardless of patient order of arival.
     *
     * @return true if the tester verifies a correct functionality and false if at least one bug is
     * detected
     * @see PatientRecord#compareTo(PatientRecord)
     */
    public static boolean testPatientRecordCompareToDifferentTriage() {
        // TODO complete the implementation of this tester method

        PatientRecord record1 = new PatientRecord('M', 33, TriageLevel.RED);
        PatientRecord record2 = new PatientRecord('F', 39, TriageLevel.YELLOW);
        PatientRecord.resetCounter();
        PatientRecord record3 = new PatientRecord('F', 89, TriageLevel.GREEN);

        //testing for higher priority
        if (record1.compareTo(record2) > 0) {
            return false;
        }

        //testing for lower priority
        if (record3.compareTo(record2) < 0) {
            return false;
        }

        return true;
    }

    /**
     * Tests whether patients in the same triage level are compared based on their order of arrival.
     * Patients of the same triage level with a lower arrival number compared to patients with a
     * higher arrival number should return a negative integer. The reverse situation should return a
     * positive integer.
     *
     * @return true if the tester verifies a correct functionality and false if at least one bug is
     * detected
     * @see PatientRecord#compareTo(PatientRecord)
     */
    public static boolean testPatientRecordCompareToSameTriageDifferentArrival() {
        // TODO complete the implementation of this tester method

        PatientRecord.resetCounter();
        PatientRecord record1 = new PatientRecord('F', 33, TriageLevel.RED);
        PatientRecord record2 = new PatientRecord('F', 39, TriageLevel.RED);

        if (record2.compareTo(record1) < 0) {
            return false;
        }
        return true;
    }

    /**
     * Tests whether patients in the same triage level and with the same order of arrival are equal
     * (compareTo should return 0). Even though this case will not be possible in your priority queue,
     * it is required for testing the full functionality of the compareTo() method. Hint: you will
     * need to use the resetCounter() to create equivalent PatientRecords.
     *
     * @return true if the tester verifies a correct functionality and false if at least one bug is
     * detected
     * @see PatientRecord#compareTo(PatientRecord)
     */
    public static boolean testPatientRecordCompareToSameTriageSameArrival() {
        // TODO complete the implementation of this tester method
        PatientRecord.resetCounter();
        PatientRecord record1 = new PatientRecord('F', 33, TriageLevel.RED);
        PatientRecord.resetCounter();
        PatientRecord record2 = new PatientRecord('M', 39, TriageLevel.RED);

        if (record2.compareTo(record1) != 0) {
            return false;
        }

        return true;
    }

    /**
     * Tests the functionality of the constructor for PriorityCareAdmissions Should implement at least
     * the following tests:
     * <p>
     * - Calling the PriorityCareAdmissions with an invalid capacity should throw an
     * IllegalArgumentException
     * - Calling the PriorityCareAdmissions with a valid capacity should not throw any errors, and
     * should result in a new PriorityCareAdmissions which is empty, has size 0, a capacity equal to
     * the capacity that was passed as a parameter.
     *
     * @return true if the constructor of PriorityCareAdmissions functions properly, false otherwise
     * @see PriorityCareAdmissions#PriorityCareAdmissions(int)
     */
    public static boolean testConstructor() {
        // TODO complete the implementation of this tester method

        // checking IllegalArgumentException
        try {
            PriorityCareAdmissions test = new PriorityCareAdmissions(0);
            return false;
        } catch (IllegalArgumentException e) {

        }

        //checking with a correct implementation.

        int capacity = 9;
        PriorityCareAdmissions correctTest = new PriorityCareAdmissions(capacity);
        if (correctTest.capacity() != capacity || correctTest.size() != 0) {
            return false;
        }


        return true; // default return statement added to resolve compiler errors
    }


    /**
     * Tests the functionality of peek() method by calling peek on an empty queue and verifying it
     * throws a NoSuchElementException.
     *
     * @return true if PriorityCareAdmissions.peek() exhibits expected behavior, false otherwise.
     */
    public static boolean testPeekEmpty() {
        // TODO complete the implementation of this tester method
        PriorityCareAdmissions queue1 = new PriorityCareAdmissions(9);
        try {
            queue1.peek();
            return false;
        } catch (NoSuchElementException e) {
            if (!e.getMessage().equals("Warning: Empty Admissions Queue!")) {
                return false;
            }
        }

        return true;
    }

    /**
     * Tests the functionality of peek() method by calling peek on a non-empty queue and verifying it
     * 1) returns the PatientRecord having the highest priority (the minimum) and 2) does not remove
     * the PatientRecord from the queue.
     *
     * @return true if the tester verifies a correct functionality and false if at least one bug is
     * detected
     */
    public static boolean testPeekNonEmpty() {
        // TODO complete the implementation of this tester method

        PriorityCareAdmissions queue = new PriorityCareAdmissions(9);
        PatientRecord.resetCounter();
        PatientRecord record1 = new PatientRecord('F', 33, TriageLevel.RED);
        PatientRecord record2 = new PatientRecord('M', 38, TriageLevel.YELLOW);
        queue.addPatient(record1);
        queue.addPatient(record2);

        if (!queue.peek().equals(record1) || queue.isEmpty()) {
            return false;
        }

        return true;
    }

    /**
     * Tests the functionality of addPatient() method by calling addPatient() on an empty queue and
     * ensuring the method 1) adds the PatientRecord and 2) increments the size.
     *
     * @return true if PriorityCareAdmissions.addPatient() exhibits expected behavior, false
     * otherwise.
     */
    public static boolean testAddPatientEmpty() {
        // TODO complete the implementation of this tester method
        PriorityCareAdmissions queue9 = new PriorityCareAdmissions(9);
        PatientRecord record1 = new PatientRecord('F', 33, TriageLevel.RED);
        queue9.addPatient(record1);

        try {
            if (queue9.size() != 1 || !queue9.peek().equals(record1)) {
                return false;
            }
        } catch (NoSuchElementException e) {
            return false;
        }


        return true;


    }

    /**
     * Tests the functionality of addPatient() method by calling addPatient() on a non-empty queue and
     * ensuring the method 1) adds the PatientRecord at the proper position and 2) increments the
     * size. Try to add at least 5 PatientRecords.
     *
     * @return true if PriorityCareAdmissions.addPatient() exhibits expected behavior, false otherwise
     */
    public static boolean testAddPatientNonEmpty() {
        // TODO complete the implementation of this tester method
        PriorityCareAdmissions queue = new PriorityCareAdmissions(9);
        PatientRecord.resetCounter();
        PatientRecord record1 = new PatientRecord('F', 33, TriageLevel.YELLOW);
        PatientRecord record2 = new PatientRecord('M', 38, TriageLevel.YELLOW);
        PatientRecord record5 = new PatientRecord('F', 99, TriageLevel.RED);
        PatientRecord record6 = new PatientRecord('M', 19, TriageLevel.GREEN);
        PatientRecord record3 = new PatientRecord('F', 39, TriageLevel.GREEN);
        queue.addPatient(record1);
        queue.addPatient(record2);
        queue.addPatient(record5);
        queue.addPatient(record6);
        queue.addPatient(record3);


        //try adding a record as the first left child
        PatientRecord record4 = new PatientRecord('F', 39, TriageLevel.RED);
        queue.addPatient(record4);
        if (queue.size() != 6) {
            return false;
        }

        //removing the first record, so that peek returns the previously added record.
        queue.removeBestRecord();
        if (!queue.peek().equals(record4) || queue.size()!=5) {
            return false;
        }


        return true;
    }


    /**
     * Tests the functionality of addPatient() method by calling addPatient() on a full queue and
     * ensuring the method throws an IllegalStateException.
     *
     * @return true if PriorityCareAdmissions.addPatient() exhibits expected behavior, false
     * otherwise.
     */
    public static boolean testAddPatientFull() {
        // TODO complete the implementation of this tester method
        PriorityCareAdmissions queue = new PriorityCareAdmissions(2);
        PatientRecord.resetCounter();
        PatientRecord record1 = new PatientRecord('F', 33, TriageLevel.RED);
        PatientRecord record2 = new PatientRecord('M', 38, TriageLevel.YELLOW);
        queue.addPatient(record1);
        queue.addPatient(record2);
        PatientRecord record3 = new PatientRecord('F', 39, TriageLevel.RED);
        try {
            queue.addPatient(record3);
            return false;
        } catch (IllegalStateException e) {

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Tests the functionality of addPatient() method by calling addPatient() with a null
     * PatientRecord and ensuring the method throws a NullPointerException.
     *
     * @return true if PriorityCareAdmissions.addPatient() exhibits expected behavior, false
     * otherwise.
     */
    public static boolean testAddPatientNull() {
        // TODO complete the implementation of this tester method
        PriorityCareAdmissions queue = new PriorityCareAdmissions(2);

        try {
            queue.addPatient(null);
            return false;
        } catch (NullPointerException e) {

        } catch (Exception e) {
            return false;
        }
        return true;
    }


    /**
     * Tests the functionality of removeBestRecord() method by calling removeBestRecord() on an empty
     * queue.
     *
     * @return true if PriorityCareAdmissions.removeBestRecord() throws a NoSuchElementException,
     * false otherwise
     */
    public static boolean testRemoveBestRecordEmpty() {
        // TODO complete the implementation of this tester method
        PriorityCareAdmissions queue = new PriorityCareAdmissions(2);

        try {
            queue.removeBestRecord();
            return false;
        } catch (NoSuchElementException e) {

        } catch (Exception e) {
            return false;
        }
        return true; // default return statement added to resolve compiler errors
    }


    /**
     * Tests the functionality of removeBestRecord() method by calling removeBestRecord() on a queue
     * of size one.
     *
     * @return true if PriorityCareAdmissions.removeBestRecord() returns the correct PatientRecord and
     * size is 0
     */
    public static boolean testRemoveBestRecordSizeOne() {
        // TODO complete the implementation of this tester method

        PatientRecord.resetCounter();
        PriorityCareAdmissions queue = new PriorityCareAdmissions(1);
        PatientRecord record1 = new PatientRecord('F', 33, TriageLevel.RED);
        queue.addPatient(record1);


        if (!queue.removeBestRecord().equals(record1) || queue.size() != 0) {
            return false;
        }
        return true; // default return statement added to resolve compiler errors
    }

    /**
     * Tests the functionality of removeBestRecord() methods.
     * <p>
     * The removeBestRecord() method must remove, and return the patient record with the highest
     * priority in the queue. The size must be decremented by one, each time the removeBestRecord()
     * method is successfully called.
     * <p>
     * Remove the best record from a queue whose size is at least 6. Consider cases where
     * percolate-down recurses on left and right.
     *
     * @return true if PriorityCareAdmissions.removeBestRecord() returns the correct PatientRecord
     * each time it is called and size is appropriately decremented, false otherwise
     */
    public static boolean testRemoveBestRecordNonEmpty() {
        // TODO complete the implementation of this tester method

        PriorityCareAdmissions queue = new PriorityCareAdmissions(9);
        PatientRecord.resetCounter();
        PatientRecord record1 = new PatientRecord('F', 33, TriageLevel.RED);
        PatientRecord record2 = new PatientRecord('M', 38, TriageLevel.YELLOW);
        queue.addPatient(record1);
        queue.addPatient(record2);
        PatientRecord record3 = new PatientRecord('F', 39, TriageLevel.RED);
        queue.addPatient(record3);
        PatientRecord record4 = new PatientRecord('X', 30, TriageLevel.GREEN);
        PatientRecord record5 = new PatientRecord('F', 99, TriageLevel.YELLOW);
        PatientRecord record6 = new PatientRecord('M', 19, TriageLevel.YELLOW);
        queue.addPatient(record4);
        queue.addPatient(record5);
        queue.addPatient(record6);

        if (!queue.removeBestRecord().equals(record1) || queue.size() != 5) {
            return false;
        }

        if (!queue.removeBestRecord().equals(record3)) {
            return false;
        }


        return true; // default return statement added to resolve compiler errors
    }

    /**
     * Tests the functionality of the clear() method.
     * Should implement at least the following scenarios:
     * - clear can be called on an empty queue with no errors
     * - clear can be called on a non-empty queue with no errors
     * - After calling clear(), the queue should contain zero PatientRecords.
     * - After calling clear(), the size should be 0
     *
     * @return true if PriorityCareAdmissions.clear() functions properly
     */
    public static boolean testClear() {
        // TODO complete the implementation of this tester method

        //- clear can be called on an empty queue with no errors

        PriorityCareAdmissions queue = new PriorityCareAdmissions(9);
        PatientRecord.resetCounter();

        queue.clear();
        if (queue.size() != 0 || !queue.isEmpty()) {
            return false;
        }

        //clear can be called on a non-empty queue with no errors

        PriorityCareAdmissions queue1 = new PriorityCareAdmissions(9);
        PatientRecord.resetCounter();
        PatientRecord record1 = new PatientRecord('F', 33, TriageLevel.RED);
        PatientRecord record2 = new PatientRecord('M', 38, TriageLevel.YELLOW);
        queue1.addPatient(record1);
        queue1.addPatient(record2);
        queue1.clear();

        if (queue1.size() != 0 || !queue1.isEmpty()) {
            return false;
        }


        return true; // default return statement added to resolve compiler errors
    }


    /**
     * Tests toString() method of PriorityCareAdmissions class.
     *
     * @return true if the tester verifies a correct functionality and false if at least one bug is
     * detected
     */
    public static boolean testToString() {
        // TODO complete the implementation of this tester method

        PatientRecord.resetCounter();
        PriorityCareAdmissions queue = new PriorityCareAdmissions(3);
        PatientRecord patient1 = new PatientRecord('M', 37, TriageLevel.RED);
        queue.addPatient(patient1);

        String expected = "23702: 37M (RED) - not seen\n";
        String actual = queue.toString();

        if(!expected.equals(actual)){
            return false;
        }





        return true; // default return statement added to resolve compiler errors
    }


    /**
     * Runs all the tester methods defined in this class.
     *
     * @return true if no bugs are detected.
     */
    public static boolean runAllTests() {

        return testPatientRecordCompareToDifferentTriage()
                && testPatientRecordCompareToSameTriageDifferentArrival()
                && testPatientRecordCompareToSameTriageSameArrival() && testPeekEmpty()
                && testPeekNonEmpty() && testAddPatientEmpty() && testAddPatientNonEmpty()
                && testAddPatientFull() && testAddPatientNull() && testRemoveBestRecordNonEmpty()
                && testRemoveBestRecordEmpty() && testRemoveBestRecordSizeOne() && testClear()
                && testToString();
    }

    /**
     * Main method to run this tester class.
     *
     * @param args list of input arguments if any
     */
    public static void main(String[] args) {
        System.out.println("runAllTests: " + (runAllTests() ? "Pass" : "Failed!"));
        System.out.println("testPatientRecordCompareToDifferentTriage: "
                + (testPatientRecordCompareToDifferentTriage() ? "Pass" : "Failed!"));
        System.out.println("testPatientRecordCompareToSameTriageDifferentArrival: "
                + (testPatientRecordCompareToSameTriageDifferentArrival() ?
                "Pass" : "Failed!"));
        System.out.println("testPatientRecordCompareToSameTriageSameArrival: "
                + (testPatientRecordCompareToSameTriageSameArrival() ? "Pass" : "Failed!"));
        System.out.println("testConstructor: " + (testConstructor() ? "Pass" : "Failed!"));
        System.out.println("testPeekEmpty: " + (testPeekEmpty() ? "Pass" : "Failed!"));
        System.out.println("testPeekNonEmpty: " + (testPeekNonEmpty() ? "Pass" : "Failed!"));
        System.out.println("testAddPatientEmpty: " + (testAddPatientEmpty() ? "Pass" : "Failed!"));
        System.out
                .println("testAddPatientNonEmpty: " + (testAddPatientNonEmpty() ?
                        "Pass" : "Failed!"));
        System.out.println("testAddPatientFull: " + (testAddPatientFull() ? "Pass" : "Failed!"));
        System.out.println("testAddPatientNull: " + (testAddPatientNull() ? "Pass" : "Failed!"));
        System.out.println(
                "testRemoveBestRecordNonEmpty: " + (testRemoveBestRecordNonEmpty() ?
                        "Pass" : "Failed!"));
        System.out.println(
                "testRemoveBestRecordEmpty: " + (testRemoveBestRecordEmpty() ? "Pass" : "Failed!"));
        System.out.println(
                "testRemoveBestRecordSizeOne: " + (testRemoveBestRecordSizeOne() ?
                        "Pass" : "Failed!"));
        System.out.println("testClear: " + (testClear() ? "Pass" : "Failed!"));
        System.out.println("testToString: " + (testToString() ? "Pass" : "Failed!"));
    }

}
