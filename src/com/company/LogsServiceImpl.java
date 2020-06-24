/**
 *
 *
 * @classname Main
 *
 * @version 1.0
 *
 * @author Skryp Andrii
 *
 *
 *              Home Task: Multi-threading.
 *
 *   1. Use the file from the previous task  - logs.txt.
 *   2. Create a class that manages logs in this file.
 *   3. Create a method that finds all the ERROR logs
 *    for a specific date and write them into a
 *    specific file (name = ERROR  + Date  + .log).
 *   4. In your main class develop a functionality
 *    to create  5 such a files for 5 different days.
 *    Launch them in consistent way (one after another).
 *   5. Repeat the above  task in parallel way. Multi-threading.
 *   6. Compare the results.
 *
 * */

package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;


 /*
  *  2. Create a class that manages logs in this file.
  */

/*
 *   LogsServiceImpl - class for managing loggs
 */

public class LogsServiceImpl {


    // Parameters

    private String dateTime;

    // Constructors

    public LogsServiceImpl() {
    }

    public LogsServiceImpl(String dateTime) {
        this.dateTime = dateTime;
    }


    // Getters & setters

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /*
     *    3. Create a method that finds all the ERROR logs
     *    for a specific date and write them into a
     *    specific file (name = ERROR  + Date  + .log).
     */

    /*
     * @param getLogsByDate - method that finds all the ERROR logs.
     *
     * @return - ERROR logs a specific date.
     */

    public int getLogsByDate(String str) throws IOException {
        LocalDateTime start = LocalDateTime.now();
        System.out.println(str + " search is started at - " + start);



        /*
         *  1. Use the file from the previous task  - logs.txt.
         */

        int count = (int) Files.lines(Paths
                .get("C:\\Users\\Intel\\Desktop\\logs.txt"))
                .filter(line -> line.contains(str))
                .filter(line -> line.contains("ERROR"))
                .count();

        LocalDateTime finish = LocalDateTime.now();



        // souting searching duration and amount of lines

        long duration = ChronoUnit.MILLIS.between(start, finish);

        System.out.println(str + " search is OVER at - "
                + LocalDateTime.now() + ". duration - "+ duration);
        System.out.println("lines amount - " + count);

        return count;
    }

    private void toFile(List<String> list
            , String fileAndPath) throws IOException {

        String stringToFile = "";

        for (String line:list){
            stringToFile += line + System.lineSeparator();
        }
        Files.write(Paths.get(fileAndPath), stringToFile.getBytes());
    }
}