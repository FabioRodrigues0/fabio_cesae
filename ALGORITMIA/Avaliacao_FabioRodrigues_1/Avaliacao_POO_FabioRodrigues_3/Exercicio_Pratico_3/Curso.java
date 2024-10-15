import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Curso
{
    ArrayList<Aluno> listAlunos = new ArrayList<>();
    Scanner read = new Scanner(System.in);
    public Curso()
    {
        System.out.println("Bem-vindo/a à Aplicação de operações sobre o curso!");
        menu();
    }
    
    void menu(){
        while(true){
            printMenu();
            int opcao = read.nextInt();
            if (opcao == 0){
                System.out.println("Obrigado volte sempre");
                break;
            } else if (opcao == 1){
                inserirAluno();
            } else if (opcao == 2){
                ordenacaoAleatoriaDeAlunos();
            } else if (opcao == 3){
                mediaNotasDaTurma();
            } else {
                System.out.print("Opção errada tente outra vez");
            }
        }
    }
    void printMenu(){
        System.out.println("O que deseja fazer?");
        System.out.println("1 -> Inserir um Aluno");
        System.out.println("2 -> Ordenar os Alunos(Aleatoriamente)");
        System.out.println("3 -> Apresentar media da turma");
        System.out.println("0 -> Sair");
    }

    void inserirAluno(){
        System.out.println("---- Novo Aluno ----");
        System.out.println("Nome: ");
        String temp_nome = read.next();
        System.out.println("Nota: ");
        float temp_nota = read.nextFloat();
        listAlunos.add(new Aluno(temp_nome, temp_nota));
    }
    
    void ordenacaoAleatoriaDeAlunos(){
        if (listAlunos.size() <= 0){
            System.out.print("Turma sem Alunos para poder ordenar");
        } else {
            ArrayList<Integer> ordemAleatoria = new ArrayList<>();
            Random rand = new Random();
            
            for (int i = 0; i < listAlunos.size(); i++){
                 ordemAleatoria.add(i);
            }
            for (int i = 0; i < listAlunos.size(); i++){
                int num = rand.nextInt(ordemAleatoria.size());
                System.out.println(listAlunos.get(ordemAleatoria.get(num)).nome);
                ordemAleatoria.remove(num);
            } 
        }
    }
    
    void mediaNotasDaTurma(){
        float total = 0;
        if (listAlunos.size() <= 0){
            System.out.print("Turma sem Alunos para efetuar media");
        } else{
            for (Aluno aluno : listAlunos){
                total += aluno.nota;
            }
        System.out.println("A media da Turma é: " + total/listAlunos.size());
        }
    }
}
