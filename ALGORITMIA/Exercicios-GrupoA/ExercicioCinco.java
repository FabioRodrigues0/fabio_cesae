import java.util.Scanner;

public class ExercicioCinco
{
    Scanner read = new Scanner(System.in);
    /**
     * Construtor para objetos da classe ExercicioUm
     */
    public ExercicioCinco()
    {
         System.out.println("Bem vindo ao Exercicio 5");
         menu();
    }
    void menu()
    {        
        System.out.println("Indique a sua altura: ");
        float altura = read.nextFloat();
        System.out.println("Indique o seu Peso: ");
        int peso = read.nextInt();
        String resposta = calcImc(altura, peso);
        System.out.print(resposta);
    }
    String calcImc(float altura, int peso)
    {
        String resposta = "";
        float imc = 0f;
        if (altura > 0 && peso > 0)
        {
            imc = peso / (altura * altura);
            resposta = "O seu imc é " + imc;
        }else
        {
            System.out.println("Indique valores Inteiros");    
        }
        return resposta;
    }
}
