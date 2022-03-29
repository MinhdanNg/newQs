package com.example.demo;

import java.io.IOException;
import java.util.Random;

import com.google.common.io.Resources;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
public class PickRandomTests {

    @Test
    public void pickOneIDATTStudent() throws Exception {
        String[] students = readFile("idatt1002.txt").split("\n");
        int winner = new Random().nextInt(students.length);
        System.out.println(students[winner]);
    }

    @Test
    public void pickOneDSCTStudent() throws Exception{
        String[] students = readFile("dcst1008.txt").split("\n");
        int winner = new Random().nextInt(students.length);
        System.out.println(students[winner]);
    }

    protected String readFile (final String filename) throws IOException {
        return new String(Resources.toByteArray(Resources.getResource(filename)));
    }

}
