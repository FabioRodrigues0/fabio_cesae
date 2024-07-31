import java.util.Scanner;

public class Tabuada {
    public Tabuada() {
        Scanner read = new Scanner(System.in);
        System.out.println("Indique um numero para mostrar a sua tabuada");
        int numero = read.nextInt();
        for (int i = 1; i < 11; i++) {
            System.out.println(numero + " X " + i + " = " + (numero*i));
        }
    }

    public static void main(String[] args) {
        Tabuada t = new Tabuada();
    }
}
