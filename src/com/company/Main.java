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
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {


    static class MyFirstThread extends Thread {

        @Override
        public void run() {
            LogsServiceImpl service1 = new LogsServiceImpl();
            try {
                service1.getLogsByDate("2019-10-14");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThread extends Thread {

        // Parameters

        private String date;

        // Constructor

        MyThread(String date){
            this.date = date;
        }

        @Override
        public void run() {
            LogsServiceImpl service = new LogsServiceImpl();
            try {
                service.getLogsByDate(date);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {

        LogsServiceImpl service1 = new LogsServiceImpl();


        /*  4. In your main class develop a functionality
        *    to create  5 such a files for 5 different days.
        *    Launch them in consistent way (one after another). */

        // starting time

        LocalDateTime start5logs = LocalDateTime.now();
        start5logs = LocalDateTime.now();


        service1.getLogsByDate("2019-10-14");
        service1.getLogsByDate("2019-10-16");
        service1.getLogsByDate("2019-10-17");
        service1.getLogsByDate("2019-10-18");
        service1.getLogsByDate("2019-10-19");


        // finishing time

        LocalDateTime finish5logs = LocalDateTime.now();
        finish5logs = LocalDateTime.now();


        // souting total time in standart way

        System.out.println("Total duration in standart way is: "
                + ChronoUnit.MILLIS.between(start5logs, finish5logs)
                + " milliseconds" + "\n");


        /*
         *
         * 5. Repeat the above  task in parallel way. Multi-threading.
         *
         */


        // starting time

        LocalDateTime start2threads = LocalDateTime.now();
        start2threads = LocalDateTime.now();



        // finding error logs of that date

        new MyFirstThread().start();
        new MyThread("2019-10-16").start();
        new MyThread("2019-10-17").start();
        new MyThread("2019-10-18").start();
        new MyThread("2019-10-19").start();


        // finishing time

        LocalDateTime finish2threads = LocalDateTime.now();
        finish2threads = LocalDateTime.now();


        // souting total duration of threads

        System.out.println("Total duration of threads is " + ChronoUnit.MILLIS.between(start2threads, finish2threads) + " milliseconds" + "\n");


        /*
         * 6. Compare the results.
         */


        // if-else condition for checking whats faster

        if ((ChronoUnit.MILLIS.between(start5logs, finish5logs) < ChronoUnit.MILLIS.between(start2threads, finish2threads))) {
            System.out.println("Standart way is faster for " + ((ChronoUnit.MILLIS.between(start2threads, finish2threads) - ChronoUnit.MILLIS.between(start5logs, finish5logs))) + " milliseconds" + "\n");
        } else if ((ChronoUnit.MILLIS.between(start5logs, finish5logs) > ChronoUnit.MILLIS.between(start2threads, finish2threads))) {
            System.out.println("Multi-threading is faster for " + ((ChronoUnit.MILLIS.between(start5logs, finish5logs) - ChronoUnit.MILLIS.between(start2threads, finish2threads))) + " milliseconds" +"\n");
        } else {
            System.out.println("Equal speed!" + "\n");
        }
    }
}