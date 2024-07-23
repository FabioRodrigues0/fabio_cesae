import java.util.Scanner;
/**
 * Escreva uma descrição da classe ExercicioDois aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ExercicioDois
{
    Scanner read = new Scanner(System.in);
    /**
     * Construtor para objetos da classe ExercicioUm
     */
    public ExercicioDois()
    {
         System.out.println("Bem vindo ao Exercicio 2");
         menu();
    }
    void menu()
    {        
        System.out.println("Indique a sua idade");
        int idade = read.nextInt();
        String confirmacao = comfirmacaoIdade(idade);
        System.out.print(confirmacao);
    }
    String comfirmacaoIdade(int idade)
    {
        String confirmacao;
        if (idade >= 18)
        {
            confirmacao = "Permitida a Entrada!";
        }else
        {
            confirmacao = "Proibido Entrar!"; 
        }
        return confirmacao;
    }
}
