import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class ExercioUm
{
    Random rand = new Random();
    ArrayList<String> diasSemana = new ArrayList<String>();
    ArrayList<String> horas = new ArrayList<String>();
    
    public ExercioUm()
    {
        // inicializa variáveis de instância
        diasSemana.addAll(List.of(new String[]{"Segunda-Feira", "Terça-Feria", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sabado"}));
        horas.addAll(List.of(new String[]{"09:00", "10:00", "11:00", "14:00", "15:00", "16:00"})); 
        System.out.println("Bem vindo ao Exercio Pratico 1");
        Scanner read = new Scanner(System.in);
        System.out.println("Pretende Incluir Sábado?");
        String opcao = read.nextLine().toLowerCase();
        horario(opcao.equals("sim"));
    }
    
    void horario(boolean op){
        String dia;
        String hora;
        if (op){
            dia = diasSemana.get(rand.nextInt(diasSemana.size()));
            hora = horas.get(rand.nextInt(horas.size()));
        } else {
            dia = diasSemana.get(rand.nextInt(diasSemana.size()-1));
            hora = horas.get(rand.nextInt(horas.size()));
        }
        System.out.println("Dia da semena: " + dia);
        System.out.println("Hora: " + hora);
    }
}
