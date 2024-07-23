import java.util.Scanner;
/**
 * Escreva uma descrição da classe ExercicioQuatro aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ExercicioQuatro
{
    Scanner read = new Scanner(System.in);
    /**
     * Construtor para objetos da classe ExercicioUm
     */
    public ExercicioQuatro()
    {
         System.out.println("Bem vindo ao Exercicio 3");
         menu();
    }
    void menu()
    {        
        System.out.println("Indique para que ponto da rosa dos Ventos pertende ir para lhe contar uma historia");
        String ponto = read.nextLine();
        String historia = escreverHistoria(ponto);
        System.out.print(historia);
    }
    String escreverHistoria(String ponto)
    {
        String historia = "";
        if (ponto.equalsIgnoreCase("norte"))
        {
            historia = "Seguindo para Norte irá notar estar mais frio, e verá a sua frente uma grande montanha";
        }
        if (ponto.equalsIgnoreCase("sul"))
        {
            historia = "Seguindo para Sul irá ver que tem deserto e que será mais quente";
        }
        if (ponto.equalsIgnoreCase("este"))
        {
            historia = "Seguindo para Este irá reparar que a temperatura ira se manter, mas verá uma vestação mais colorida";
        }
        if (ponto.equalsIgnoreCase("oeste"))
        {
            historia = "Seguindo para Oeste irá reparar que está mais humido e a vestação está mais densa";
        }
        return historia;
    }
}
