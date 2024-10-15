import java.util.Scanner;
/**
 * Escreva uma descrição da classe ClasseA aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ClasseB
{
    Scanner read = new Scanner(System.in);
    /**
     * Construtor para objetos da classe ExercicioUm
     */
    public ClasseB()
    {
         System.out.println("Bem vindo ao Teste de Avaliação Exercicio Class B");
         calc();
    }
    
    void calc()
    {
        System.out.println("Que operação pertende realizar, indique o numero associado ou a operação:");
        System.out.println("1 - Soma\n2 - Subtração");
        String opcao = read.nextLine();
        System.out.println("Primeiro numero a calcular:");
        int num1 = read.nextInt();
        System.out.println("Segundo numero a calcular:");
        int num2 = read.nextInt();
        if (opcao.equalsIgnoreCase("soma") || opcao.equalsIgnoreCase("1") )
        {
            int resultado = calc_soma(num1, num2);
            System.out.println("O resultado da soma: " + resultado);
            
        }
        if (opcao.equalsIgnoreCase("subtração") || opcao.equalsIgnoreCase("subtracao")|| opcao.equalsIgnoreCase("2"))
        {
            int resultado = calc_subtrair(num1, num2);
            System.out.println("O resultado da subtração: " + resultado);
        }
        if(!((opcao.equalsIgnoreCase("soma") || opcao.equalsIgnoreCase("1")) || (opcao.equalsIgnoreCase("subtração") || opcao.equalsIgnoreCase("subtracao")|| opcao.equalsIgnoreCase("2")))){
            mesagemError();
        }
    }
    void mesagemError(){
        System.out.println("Indique uma opção valida");
        calc();
    }
    
    int calc_subtrair(int num1, int num2){
       return num1 - num2; 
    }
    int calc_soma(int num1, int num2){
        return num1 + num2;
    }
}
