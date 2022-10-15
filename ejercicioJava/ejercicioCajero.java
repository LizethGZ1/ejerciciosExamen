
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
 
public class ejercicioCajero{
 
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int nip = 1235; // contraseña
        boolean flag = true; // declara una variable booleana
        double saldo1 = 1000;// balance
        double saldo = 1000;// balance
        int retirar;
        double acum=0;
        int cont=0;
        double[] num = new double[100];
        double[] sal = new double[100];
        String fecha[] = new String[100];
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy/MMMM/dd HH:mm:ss");
        String x = dtf3.format(LocalDateTime.now());
        // interfaz
        System.out.println("--------- Bienvenido al cajero automático de Minsait ---------");

        // Limita el número de inicios de sesión
        for (int i = 1; i <= 3; i++) {
            System.out.println("Por favor ingrese su contraseña:");
            int inputNip = s.nextInt();

            // verificar cuenta y contraseña
            if (inputNip == nip) {
                flag = true;
                break;
            } else {
                if (i <= 2) {
                    System.out.println("Lo siento, la contraseña es incorrecta, aún tienes " + (3 - i) + " Intentos");
                } else {
                    System.out.println("Lo siento, por seguridad se ha bloqueado tu tarjeta");
                    break;
                }
                flag = false;
            }
        }

        // Seleccione la función después de un inicio de sesión exitoso
        if (flag) {
            char answer = 's';
            while (answer == 's') {
                System.out.println("Bienvenid@, Lizeth Gonzalez Zaragoza \n Selecciona una opción: \n 1. Consultar Saldo \n 2. Retirar saldo \n 3. Histórico de movimiento \n 4.Salir");
                int choice = s.nextInt();
                switch (choice) {
                        case 1:
                        System.out.println("---> CONSULTAR SALDO");
                        System.out.println("SALDO : "+saldo);
                        break;
        
                        case 2:
                        System.out.println("---> RETIRAR");
                        
                        System.out.print("\nIngresa la cantidad a retirar:");
                        retirar = s.nextInt();
                        
                        if (retirar<=0) {
                            System.out.println("\n No puedes ingresar numeros negativos");
                        }else if(saldo >= retirar)
                        {
                            saldo = saldo - retirar;
                            acum=acum+retirar;
                            cont=cont+1;
                            num[cont] = retirar;
                            sal[cont] = saldo;
                            fecha[cont]=x;
                            
                            System.out.println("\nDINERO RETIRADO EXITOSAMENTE");
                        }
                        else
                        {
                            System.out.println("\nFONDOS INSUFICIENTES");
                        }
        
                        System.out.println("");
                        
                        break;
        
                        case 3:
                        System.out.println("---> HISTÓRICO DE MOVIMIENTOS");
                        
                            if (acum==0) {
                                System.out.println("Saldo actual: "+ saldo);
                                System.out.println("Sin movimientos recientes");
                            }else{
                                System.out.println("Saldo anterior: "+saldo1);
                                for (int j = 1; j < cont+1; j++) {
                                    System.out.println("Fecha de retiro: "+fecha[j]+" La cantidad de: "+ num[j]);
                                    System.out.println("Saldo actual: "+ sal[j]);
                            }
                        }
                        
        
                        break;
        
                        case 4:
                        System.out.println("GRACIAS POR USAR EL CAJERO AUTOMATICO");
                        System.exit(0);
                }
                System.out.println("¿Continuar? s / n");
                answer = s.next().charAt(0);
            }
        }
    }
}