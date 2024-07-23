import java.util.Locale;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

/**
 * Escreva uma descrição da classe App aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class App
{
    List<Integer> options_dado = Arrays.asList(4, 6, 8, 20, 100);
    /**
     * Construtor para objetos da classe App
     */
    public App()
    {
        Menu();
    }

    /**
     * Método Menu
     *
     */
    public void Menu()
    {
        Scanner read = new Scanner(System.in);
        System.out.println("Bem-vindo/a ao Simulador de Lançamentos.");
        while (true){
            System.out.println("Este programa permite lançar(escolha a opção que deseja):");
            System.out.println("* 4 - Dado de 4 lados.");
            System.out.println("* 6 - Dado de 6 lados.");
            System.out.println("* 8 - Dado de 8 lados.");
            System.out.println("* 20 - Dado de 20 lados.");
            System.out.println("* 100 - Dado de 100 lados.");
            System.out.println("* 0 - Sair.");
            int opcao = read.nextInt();
            String opcaoText = read.nextLine();
            // || -> or && -> and !() -> not
            if (opcao == 0 )
            {
                System.out.println("Obrigado Volte Sempre!");
                break;
            }
            if (options_dado.contains(opcao))
            {
                Dado dado = new Dado(opcao);
                dado.lancar();
            }else{
                System.out.println("Opção Errada, Tente Outra vez!");
            }
            System.out.println("----------------------------------------------");
        }
    }
}
