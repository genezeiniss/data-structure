package com.genezeiniss.data_structure;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DataStructureApplication {

    public static void main(String[] args) {

        //SpringApplication.run(DataStructureApplication.class, args);

        List<Integer> arr = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1);
        duplicateZeros(arr);
    }

    public static void duplicateZeros(List<Integer> array) {

    }
}