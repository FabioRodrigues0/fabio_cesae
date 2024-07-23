import java.util.Random;
/**
 * Escreva uma descrição da classe Dado aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Dado
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    Tipo_dado tipo_dado;

    /**
     * Construtor para objetos da classe Dado
     */
    public Dado(int num_lados)
    {
        switch(num_lados)
        {
            case 4: //code to be executed
                tipo_dado = Tipo_dado.DADO_4;
                break;
            case 6: //code to be executed
                tipo_dado = Tipo_dado.DADO_6;
                break; //optional
            case 8: //code to be executed
                tipo_dado = Tipo_dado.DADO_8;
                break; //optional
            case 20: //code to be executed
                tipo_dado = Tipo_dado.DADO_20;
                break; //optional
            case 100: //code to be executed
                tipo_dado = Tipo_dado.DADO_100;
                break; //optional

            default: //code to be executed if all cases are not matched
                tipo_dado = Tipo_dado.DADO_ERRO;
        }
    }

    public void lancar()
    {
        String mensagem;
        Random rand = new Random();
        int roll;
        switch(tipo_dado)
        {
            case DADO_4: //code to be executed
                roll = rand.nextInt(4) + 1;
                System.out.println("Numero sorteado: " + roll);
                break; //optional
            case DADO_6: //code to be executed
                roll = rand.nextInt(6) + 1;
                System.out.println("Numero sorteado: " + roll);
                break; //optional
            case DADO_8: //code to be executed
                roll = rand.nextInt(8) + 1;
                System.out.println("Numero sorteado: " + roll);
                break; //optional
            case DADO_20: //code to be executed
                roll = rand.nextInt(20) + 1;
                System.out.println("Numero sorteado: " + roll);
                break; //optional
            case DADO_100: //code to be executed
                roll = rand.nextInt(100) + 1;
                System.out.println("Numero sorteado: " + roll);
                break; //optional
    
            default: //code to be executed if all cases are not matched
        }
    }
}
