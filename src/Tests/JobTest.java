package Tests;
import netscape.javascript.JSObject;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import javax.naming.Name;

import static org.junit.Assert.*;

public class JobTest {
    Job test_job;
    Job test_job2;
    Job test_job_all_fields;
    Job test_job_all_fields2;
    Job test_job_empty_fields;
    Job test_job_all_empty_fields;

    @Before
    public void createJobObjects() {
        test_job = new Job();
        test_job2 = new Job();
        test_job_all_fields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        test_job_all_fields2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        test_job_empty_fields = new Job("Doug", new Employer(""), new Location("St. Louis"), new PositionType("Entry Level"), new CoreCompetency("First Aid"));
        test_job_all_empty_fields = new Job(" ", new Employer(""), new Location(" "), new PositionType(""), new CoreCompetency(" "));
    }

    @Test
    public void testSettingJobId() {
        assertTrue(test_job2.getId() - test_job.getId() == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals("Product tester", test_job_all_fields.getName());
        assertTrue(test_job_all_fields.getEmployer() instanceof Employer);
        assertEquals("ACME", test_job_all_fields.getEmployer().getValue());
        assertTrue((test_job_all_fields.getLocation() instanceof Location));
        assertEquals("Desert", test_job_all_fields.getLocation().getValue());
        assertTrue(test_job_all_fields.getPositionType() instanceof PositionType);
        assertEquals("Quality Control", test_job_all_fields.getPositionType().getValue());
        assertTrue(test_job_all_fields.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", test_job_all_fields.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(test_job_all_fields.equals(test_job_all_fields2));
    }

    @Test
    public void testToStringContainsBlankLine() {
        assertTrue(test_job_all_fields.toString().startsWith("\n",0));
        assertTrue(test_job_all_fields.toString().endsWith("\n"));
    }

    @Test
    public void testToStringRequiredBehavior() {
        assertEquals("\n" + "ID: " + test_job_all_fields.getId() +
                "\n" + "Name: " + test_job_all_fields.getName() +
                "\n" + "Employer: " + test_job_all_fields.getEmployer() +
                "\n" + "Location: " + test_job_all_fields.getLocation() +
                "\n" + "Position Type: " + test_job_all_fields.getPositionType() +
                "\n" + "Core Competency: " + test_job_all_fields.getCoreCompetency() + "\n",
               test_job_all_fields.toString());
    }

    @Test
    public void testForNoBlankInformation() {
        assertEquals(test_job_empty_fields.toString(), "\n" +
                "ID: 5" + "\n" +
                "Name: Doug" + "\n" +
                "Employer: Data not available!" + "\n" +
                "Location: St. Louis" + "\n" +
                "Position Type: Entry Level" + "\n" +
                "Core Competency: First Aid" + "\n");
        System.out.println(test_job_empty_fields.toString());
    }

    @Test
    public void testForAllEmptyFields() {
        assertEquals("\n"+"This job does not seem to exist!"+"\n", test_job_all_empty_fields.toString());
    }
}
