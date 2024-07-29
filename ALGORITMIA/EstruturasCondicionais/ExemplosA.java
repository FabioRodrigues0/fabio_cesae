
/**
 * Escreva uma descrição da classe ExemplosA aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ExemplosA
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    String username = new String("abc");
    String password = new String("xyz");
    

    /**
     * Construtor para objetos da classe ExemplosA
     */
    public ExemplosA()
    {
        // inicializa variáveis de instância
        if(username.equals("abv") && password.equals("xyz")){
            System.out.println("Username e Password Correctas!");            
        }else{
            System.out.println("Alguma coisa falhou!");
        }
        // 6 > 9 || 4 == 3 && 9 <= 0 || 3 >= 1  true
        if((6 > 9 || 4 == 3 && 9 <= 0 ) || 3 >= 1){
            System.out.println("Aprendizagem sobre precedência do &&!");
        }
    }
}
