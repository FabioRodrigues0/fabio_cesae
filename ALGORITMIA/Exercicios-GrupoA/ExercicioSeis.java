import java.util.Scanner;
/**
 * Escreva uma descrição da classe ExercicioSeis aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ExercicioSeis
{
    Scanner read = new Scanner(System.in);
    int contador = 0;
    /**
     * Construtor para objetos da classe ExercicioUm
     */
    public ExercicioSeis()
    {
         System.out.println("Bem vindo ao Exercicio 6");
         menu();
    }
    void menu()
    {        
        verificarUser();
    }
    void verificarUser()
    {
        if(contador < 3)
        {
            System.out.println("Username: ");
            String user = read.nextLine();
            System.out.println("Password: ");
            String pass = read.nextLine();
            if (user.equals("utilizador") && pass.equals("abz"))
            {
                System.out.println("Autenticação Completa");
            }else{
                System.out.println("Autenticação inválida");
                contador++;
                verificarUser();
            }
        }else{
            System.out.println("User Bloqueado!");
            System.out.println("Este computador será autodestruído em 5 segundos!");
        }
    }
}
