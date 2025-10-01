package edu.miu.cs.cs489appsd.lab2b;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class PAMSApp {
    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-M-d");

        List<Patient> patients = new ArrayList<>(Arrays.asList(
                new Patient(1, "Daniel", "Agar", "(641) 123-0009", "dagar@m.as", "1 N Street",
                        LocalDate.parse("1987-1-19", fmt)),
                new Patient(2, "Ana", "Smith", null, "amsith@te.edu", null,
                        LocalDate.parse("1948-12-5", fmt)),
                new Patient(3, "Marcus", "Garvey", "(123) 292-0018", null, "4 East Ave",
                        LocalDate.parse("2001-9-18", fmt)),
                new Patient(4, "Jeff", "Goldbloom", "(999) 165-1192", "jgold@es.co.za", null,
                        LocalDate.parse("1995-2-28", fmt)),
                new Patient(5, "Mary", "Washington", null, null, "30 W Burlington",
                        LocalDate.parse("1932-5-31", fmt))));

        // Sort by age descending (oldest first)
        patients.sort(Comparator.comparingInt(Patient::getAge).reversed());

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        File out = new File("patients.json");
        try {
            mapper.writeValue(out, patients);
            System.out.println("Wrote " + patients.size() + " patients to: " + out.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to write patients.json: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

