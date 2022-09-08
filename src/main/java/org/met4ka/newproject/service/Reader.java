package org.met4ka.newproject.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service

public class Reader {
    @Scheduled(fixedDelay = 10000)
    public void test() {
        System.out.println("Start of reader and searcher:");
        List<File> lst = Arrays.asList((new File("Files")).listFiles());
        System.out.println("Files name: " + lst.toString());

        String max_max_line = "";// Значение максимальной строки в папке
        String max_max_filename = "";
        String word = "Moto";
        for (File file : lst){
            System.out.println("Searching in file: "+file.getName());
            String[] arr_line = new String[0];
            try (BufferedReader br = new BufferedReader(new FileReader(file)))
            {
                String line;
                String max_line="";
                int count=0;
                int count_line=0;
                String sword;

                while ((line = br.readLine()) != null) {
                    System.out.println("Searching...");
                    System.out.println(word);
                    if (word==line){
                        System.out.println(line);
                        count++;
                        System.out.println("In file "+file.getName()+" match found.");
                    }
                    System.out.println("Founds:"+count);
                    System.out.println("__________________________________________________________________");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Нашли max_max_line в файле "+max_max_filename+" = "+max_max_line);
        System.out.println("Закрыли test");
    }
}
