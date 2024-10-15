import java.util.Scanner;
import java.util.Random;

public class ExercicioDois
{
    public ExercicioDois()
    {
        Random rand = new Random();
        Scanner read = new Scanner(System.in);
        float precoPerfume = rand.nextFloat(1, 20);
        System.out.println("Perfume: " + precoPerfume);
        System.out.println("Quando dinheiro ira dar como pagamento");
        float dinheiroCliente = read.nextFloat();
        while (dinheiroCliente <= precoPerfume){
            System.out.println("Dinheiro dado nao chegou por favor dê mais");
            float tempDinheiro = read.nextFloat();
            dinheiroCliente += tempDinheiro; 
        }
        if (dinheiroCliente > precoPerfume){
            float troco = dinheiroCliente - precoPerfume;
            System.out.println("Perfume foi pago, aqui esta o seu troco " + troco);
        }else {
            System.out.println("Perfume foi pago");            
        }
    }
}
