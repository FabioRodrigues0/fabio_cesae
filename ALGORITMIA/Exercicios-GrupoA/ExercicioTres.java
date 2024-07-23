import java.util.Scanner;
/**
 * Escreva uma descrição da classe ExercicioTres aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ExercicioTres
{
    Scanner read = new Scanner(System.in);
    /**
     * Construtor para objetos da classe ExercicioUm
     */
    public ExercicioTres()
    {
         System.out.println("Bem vindo ao Exercicio 3");
         menu();
    }
    void menu()
    {        
        System.out.println("Indique um determinado numero de dias para serem convertidos em minutos");
        float euros = read.nextFloat();
        float reais = convertEuro(euros);
        System.out.print("Os " + euros + "€ equivalem a " + reais);
    }
    float convertEuro(float euros)
    {
        float reais = 0f;
        if (euros > 0)
        {
            reais = euros * 6.04f;
        }else
        {
            System.out.println("Indique numeros Inteiros");    
        }
        return reais;
    }
}
