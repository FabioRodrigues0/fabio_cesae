import java.util.Scanner;
import java.util.Random;
/**
 * Escreva uma descrição da classe ClasseB aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ClasseB
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    Scanner read = new Scanner(System.in);
    Random rand = new Random();
    /**
     * Construtor para objetos da classe ClasseB
     */
    public ClasseB()
    {
        // inicializa variáveis de instância
        System.out.println("Indique o clube de futebol que deseja ver os resultados");
        String clube = read.nextLine();
        printTotobola(clube);
    }

    void printTotobola(String y)
    {
        // escreva seu código aqui
        int casa = rand.nextInt(4);
        int fora = rand.nextInt(4);
        System.out.println("Nome do clube: " + casa);
        System.out.println("Adversario: " + fora);
        if (casa > fora){
            System.out.println("O " + y + " ganhou");
        }else if (casa < fora){
            System.out.println("O" + y + " perdeu");
        }else{
            System.out.println("O " + y + " empatou");
        }
    }
}
