import java.util.Scanner;
import java.util.*;
import java.util.Arrays;
/**
 * Escreva uma descrição da classe ClasseA aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ClasseA
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    Scanner read = new Scanner(System.in);
    int[] listNums = new int[]{ 1,2,3,4,5,6,7,8,9,10 };

    /**
     * Construtor para objetos da classe ClasseA
     */
    public ClasseA()
    {
        // inicializa variáveis de instância
        int total = Arrays.stream(listNums).sum();
        System.out.println(total);
        System.out.println("Indique a sua idade:");
        int idade = read.nextInt();
        printCarta(idade);
    }

    void printCarta(int y)
    {
        if(y >= 18){
            System.out.println("Já pode tirar a carta de Condução");
        }else{
            if((18 - y) > 1){
                System.out.println("Faltam " + (18 - y) + " anos para tirar a carta de condução");
            }else {
                System.out.println("Faltam " + (18 - y) + " ano para tirar a carta de condução"); 
            }
        }
    }
}
