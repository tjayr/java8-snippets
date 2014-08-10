package com.clearprecision.java8.collections;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsExamples {

    public void countOccurrencesInInFile(String fileName, String searchString) {
        try {
            Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
            Stream<String> textStream = Files.lines(path, Charset.defaultCharset());
            Long total = textStream.filter(word -> word.contains("the")).collect(Collectors.counting());
            System.out.println("Found "+total+" instances of the string \""+searchString+"\" in the file "+fileName );            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    

    public void filter(List<Integer> data) {
        Stream<Integer> result = data.stream().filter(i -> i < 5);
        result.forEach(System.out::println);
    }

    public void map(List<Integer> data) {        
        List<Integer> newList = data.stream()
                .map(i -> i * 10)
                .collect(Collectors.toList());
        System.out.println(newList);        
    }

    public void flatMap() {
        List<List<Integer>> data = Arrays
                .asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
        
        data.stream().flatMap( list -> list.stream() ).forEach(System.out::println);        

    }

    public static void main(String[] args) {
        CollectionsExamples ex = new CollectionsExamples();
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("---- Filter ----");
        ex.filter(data);

        System.out.println("---- File Stream ----");
        ex.countOccurrencesInInFile("stream.txt", "the");
        
        System.out.println("---- Mapping ----");
        System.out.println("i -> i * 10  mapping");
        ex.map(data);
        
        System.out.println("---- Flat Map ----");        
        ex.flatMap();
    }

}
