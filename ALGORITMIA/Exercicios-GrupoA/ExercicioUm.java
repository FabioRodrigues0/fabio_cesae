import java.util.Scanner;
/**
 * Escreva uma descrição da classe ExercicioUm aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ExercicioUm
{
    Scanner read = new Scanner(System.in);
    /**
     * Construtor para objetos da classe ExercicioUm
     */
    public ExercicioUm()
    {
         System.out.println("Bem vindo ao Exercicio 1");
         menu();
    }
    void menu()
    {        
        System.out.println("Indique um determinado numero de dias para serem convertidos em minutos");
        int days = read.nextInt();
        int minutes = convertDays(days);
        System.out.print("Os " + days + " convertidos em minutos são " + minutes);
        System.out.print("Deseja Continuar?");
        String option = read.nextLine();
    }
    int convertDays(int days)
    {
        int minutes = 0;
        if (days > 0)
        {
            int minutes_per_day = (1 * 60) * 24;
            minutes = minutes_per_day * days;
        }else
        {
            System.out.println("Indique numeros Inteiros");    
        }
        return minutes;
    }
}
