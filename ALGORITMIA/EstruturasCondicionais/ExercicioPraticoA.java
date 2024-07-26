import java.util.Random;

public class ExercicioPraticoA {
    ExercicioPraticoA() {
        Random rand = new Random();
        int temperatura = rand.nextInt(41);
        if (temperatura <= 10) {
            System.out.println("Muito Frio");
        } else if (temperatura <= 20) {
            System.out.println("Temperatura Moderada!");
        } else if (temperatura <= 30) {
            System.out.println("Está quente!");
        } else if (temperatura <= 40) {
            System.out.println("Que calor dos diabos!");
        }
    }

    public static void main(String[] args) {
        ExercicioPraticoA ex = new ExercicioPraticoA();
    }
}
