// Definição de classe AppTestes
class AppTestes
{

    // Definição da função Construtora (Constructor)
    AppTestes()
    {
        // variaveis atomicas
        double numeroRealDouble = 3.229292993939293939;
        float numeroRealFloat = 4.23f;
        char letra = 'a';
        boolean resposta = true;
        
        // variaveis não atomicas
        String mensagem = "Fabio";

        feriasAgosto();
        System.out.println(returnPreco() + " " + numeroRealDouble + " " + numeroRealFloat + " " + letra + " " + resposta + " " + mensagem);
    }
    
    void feriasAgosto()
    {
        System.out.println("Estou à espera das férias de Agosto");
    }
    
    int returnPreco()
    {
        return 12;
    }
}