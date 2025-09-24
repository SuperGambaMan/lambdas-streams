package org.iesvdm;

import java.io.BufferedReader;
import java.io.FileReader;

public class LecturaReader {
    public static void main(String[] args) {
        try {

            // Crea un FileReader 
            FileReader file = new FileReader("/home/manuel/CICLO/DWEServidor/Visual Studio Code/lambdas-streams/input.txt");

            // Envuelve el FileReader en un BufferedReader
            BufferedReader reader = new BufferedReader(file);

            // Lee la primera línea
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);

                // Lee la siguiente línea
                line = reader.readLine();
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
