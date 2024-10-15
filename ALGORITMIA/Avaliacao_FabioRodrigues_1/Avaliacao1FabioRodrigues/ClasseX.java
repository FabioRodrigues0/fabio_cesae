
/**
 * Escreva uma descrição da classe ClasseX aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ClasseX
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    int x;
    int y;

    /**
     * Construtor para objetos da classe ClasseX
     */
    public ClasseX()
    {
        // inicializa variáveis de instância
        x = 1;
        y = 4;
        int z = metodo1(y);
        metodo2(3);
        System.out.println(z);
        metodo2(1);
    }

    int metodo1(int a)
    {
        x += a;
        int resultado = x + y - a;
        return resultado;
    }
    
    void metodo2(int param)
    {
        x++;
        param = param + x;
        System.out.println(param);
    }
}
