import java.util.Random;
import java.util.Scanner;
/**
 * Escreva uma descrição da classe AppDados aqui.
 * 
 * @author Fábio Rodrigues
 * @version 1.0.0
 */
public class AppDados
{
    // variavel global a class
    int valor = 6;
    
    
    /**
     * Construtor para objetos da classe AppDados
     */
    public AppDados()
    {
        app();
    }
    /**
     * Método app
     *
     */
    void app()
    {   
        // for (int i = 0; i < 5; i++)
        // {
            // Scanner read = new Scanner(System.in); 
            // System.out.println("Indique o tamanho do dado que deseja lançar");
            // int input = read.nextInt();
            // System.out.println("O numero gerado foi: " + dado(input)); 
        // };
        System.out.println("O numero gerado foi: " + dado(6));
        System.out.println("O numero gerado foi: " + dado(8));
        System.out.println("O numero gerado foi: " + dado(8));
        System.out.println("O numero gerado foi: " + dado(20));
        System.out.println("O numero gerado foi: " + dado(20));
    }
    /**
     * Método dado
     *
     * @param size Um parâmetro inteiro que indica qual tamanho do dado que irá lançar
     * @return O valor de retorno
     */
    int dado(int size)
    {
        Random rand = new Random();
        return rand.nextInt(size) + 1;
    }
}
