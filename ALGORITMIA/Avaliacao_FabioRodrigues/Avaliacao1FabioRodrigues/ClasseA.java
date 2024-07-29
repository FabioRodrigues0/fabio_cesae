import java.util.Scanner;
/**
 * Escreva uma descrição da classe ClasseA aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ClasseA
{
    Scanner read = new Scanner(System.in);
    /**
     * Construtor para objetos da classe ExercicioUm
     */
    public ClasseA()
    {
         System.out.println("Bem vindo ao Teste de Avaliação Exercicio Class A");
         convertEmMilhas();
    }
    
    float convertEmMilhas()
    {   
        System.out.println("Indique um determinado numero de Kilometros");
        float km = read.nextFloat();
        float milhas = 0;
        
        if (km > 0)
        {
            milhas = 0.62f * km;
            System.out.print("O resultado da conversão para milhas é: " + milhas);
        }else
        {
            System.out.println("Indique um numeros Real Inteiro");
            convertEmMilhas();
        }
        return milhas;
    }
}
