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
    int tentativas = 1;
    int numeroSorteado;
    /**
     * Construtor para objetos da classe Classe C
     */
    public ClasseC()
    {
        // inicializa variáveis de instância
        System.out.println("Bem vindo ao Teste de Avaliação Exercicio Class C");
        menu();
    }
    
    void menu(){
        numeroSorteado = generateNum();
        if (numeroSorteado > 8 && numeroSorteado < 2){
            menu();
        }else{
            tentativasUser();
        }
        
    }
    
    void tentativasUser(){
        Scanner read = new Scanner(System.in);
        int numUser;
        System.out.println("Tente advinhar numero sorteado entre 2 e 8:");
        numUser = read.nextInt();
        if (numUser == numeroSorteado){
            System.out.println("Parabéns acertou o numero sorteado com " + tentativas + "tentativas");
        }else{
            if(numUser > numeroSorteado){
                System.out.println("Falhou no numero sorteado mas esta quase, numero sorteado e menor");
                tentativas++;
                tentativasUser();
            }
            if(numUser < numeroSorteado){
                System.out.println("Falhou no numero sorteado mas esta quase, numero sorteado e maior");
                tentativas++;
                tentativasUser();
            }
        }
    }

    public int generateNum()
    {
        Random rand = new Random();
        int numeroSorteado = rand.nextInt(7);
        return numeroSorteado + 1;
    }
}
