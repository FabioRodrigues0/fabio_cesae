public class Aluno
{
    String nome;
    float nota;
    String infoAluno;
    
    public Aluno()
    {
       
    }
    
    public Aluno(String newNome, float newNota)
    {
       nome = newNome;
       nota = newNota;
       infoAluno = "Nome: " + newNome + " Nota: " + newNota;
    }
}
