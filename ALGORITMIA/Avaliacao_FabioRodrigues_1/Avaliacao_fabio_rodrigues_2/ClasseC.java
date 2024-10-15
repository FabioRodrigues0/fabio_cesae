import java.util.Scanner;
import java.util.Random;
/**
 * Escreva uma descrição da classe ClasseC aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ClasseC
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    Scanner read = new Scanner(System.in);
    Random rand = new Random();

    /**
     * Construtor para objetos da classe ClasseC
     */
    public ClasseC()
    {
        // inicializa variáveis de instância
        System.out.println("Indique um numero de 1 a 7:");
        int numeros = read.nextInt();
        while (!(numeros <= 7 && numeros >= 1)){
            System.out.println("Numero Invalido");
            System.out.println("Forneça um novo numero entre 1 e 7:");
            numeros = read.nextInt();
        }
        sampleMethod(numeros);
    }

    void sampleMethod(int y)
    {
        // escreva seu código aqui
        int resultado = 0;
        System.out.println("Numeros Sorteados:");
        for (int i=1; i <= y; i++){
            int aleatorio = rand.nextInt(20);
            resultado += aleatorio;
            System.out.print(aleatorio + " ");
        }
        System.out.println();
        System.out.println("Soma dos numeros Sorteados: " + resultado);
    }
}
