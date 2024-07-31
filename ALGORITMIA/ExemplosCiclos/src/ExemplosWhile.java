import java.util.Scanner;

public class ExemplosWhile {
    Scanner read = new Scanner(System.in);
    public ExemplosWhile() {
        System.out.println("Forneça um numero entre 30 e 40:");
        int valorUser = read.nextInt();
        while (!(valorUser <= 40 && valorUser >= 30)){
            System.out.println("Numero Invalido");
            System.out.println("Forneça um novo numero entre 30 e 40:");
            valorUser = read.nextInt();
        }
    }

    public static void main(String[] args) {
        ExemplosWhile ew = new ExemplosWhile();
    }
}
