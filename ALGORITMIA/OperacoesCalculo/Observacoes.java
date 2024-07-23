import java.util.Scanner;

public class Observacoes {
    public Observacoes() {
        Scanner read = new Scanner(System.in);
        int valorX = 6;
        int valorY = 3;

        int valorZ = 3 + valorY - 1 + valorX;

        float valorReal = 8f;
        float teste = read.nextFloat();

        int contador = 0;
        contador++; // ou contador += 1
        contador += 7;
        contador += 4;

        System.out.println(contador);


    }
}
