import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Reto {

    /**
     * @param args
     */
    public static void main(String[] args) {
            leerArchivo("data.csv");
    }
    /**
     * Imprime el reporte final con el balance, id de la transacción con el mayor monto, monto mayor, conteo de creditos y debitos
     * @param balance valor de la suma de los debitos y creditos
     * @param idMaxTransaccion id con el monto mayor
     * @param montoMaxTransaccion monto mayor
     * @param conteoCredito cantidad de creditos
     * @param conteoDebito cantidad de debitos
     */
    public static void imprimir(double balance, String idMaxTransaccion, double montoMaxTransaccion, int conteoCredito, int conteoDebito) {
        // Imprimir el reporte final
        System.out.println("Reporte de Transacciones");
        System.out.println("---------------------------------------------");
        System.out.printf("Balance Final: %.2f%n", balance);
        System.out.printf("Transacción de Mayor Monto: ID %s - %.2f%n", idMaxTransaccion, montoMaxTransaccion);
        System.out.printf("Conteo de Transacciones: Crédito: %d Débito: %d%n", conteoCredito, conteoDebito);
    }
    /**
     * Lee un archivo que se pasa como argumento y procesa las transacciones
     * @param archivo nombre del archivo a leer
     */
    public static void leerArchivo(String archivo) {
        // Variables para almacenar los resultados
        double balance = 0.0; // balance total para la suma del debito y credito
        String idMaxTransaccion = ""; // ID de la transacción con el mayor monto
        double montoMaxTransaccion = 0.0; // valor menor posible para el monto con que comparar
        int conteoCredito = 0; // Contador de transacciones de crédito
        int conteoDebito = 0;// Contador de transacciones de débito
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), "UTF-8"))) { //Leer el archivo si pasa algun error se cierra
            String linea;
            br.readLine(); // Saltar linea de cabecera

            // Procesamos cada línea del archivo
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");// separa los valores por comas
                String id = partes[0];//id de la transacción
                String tipo = partes[1];//debito o credito
                double monto = Double.parseDouble(partes[2]); // Monto de la transacción

                // Actualizar balance y conteos según el tipo de transacción
                if ("Crédito".equals(tipo)) {
                    balance += monto; //se suma el monto al balance si es credito
                    conteoCredito++; // se suma al conteo de creditos
                } else if ("Débito".equals(tipo)) {
                    balance -= monto; //se resta el monto al balance si es debito
                    conteoDebito++; // se suma al conteo de debitos
                }

                // Encontrar la transacción con el mayor monto
                if (monto > montoMaxTransaccion) {//se compara el monto de la transacción con el mayor monto
                    montoMaxTransaccion = monto; //se asigna el nuevo monto mayor
                    idMaxTransaccion = id; //se asigna el id de la transacción con el mayor monto
                }
            }
            imprimir(balance, idMaxTransaccion, montoMaxTransaccion, conteoCredito, conteoDebito);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}