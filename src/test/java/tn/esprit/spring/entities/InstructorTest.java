package tn.esprit.spring.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructorTest {

    private Instructor instructor ;
    @BeforeEach
    void setUp () {
        instructor= new Instructor();

    }


    @Test
    void getFirstName() {
        instructor.setFirstName("hou");
        assertEquals("hou" , instructor.getFirstName());
    }

    @Test
    void getLastName() {
        instructor.setLastName("gou");
        assertEquals("gou" , instructor.getLastName());
    }
}