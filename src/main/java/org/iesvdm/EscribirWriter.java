package org.iesvdm;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class EscribirWriter {
    public static void main(String[] args) {
		
        String data = "Estas líneas de texto\n irán al fichero Ďœ᨟\nĎœ᨟";

	        try {
	            // Crea el FileWriter
	            FileWriter file = new FileWriter("/home/manuel/CICLO/DWEServidor/Visual Studio Code/lambdas-streams/output.txt");

	            // Se envuelve (wrap) en un stream con bufer, con tamaño 8196 bytes por defecto.
	            BufferedWriter output = new BufferedWriter(file);

	            // Se escribe los datos al flujo de salida.
	            output.write(data);
	            // Nunca olvidar que se debe cerrar el flujo.
	            output.close();
	        }

	        catch (Exception e) {
	            e.getStackTrace();
	        }
		}
}