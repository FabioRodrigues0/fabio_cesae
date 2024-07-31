import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListaAleatorios {
    ListaAleatorios(){
        Random rand = new Random();
        List<Integer> listNum = new ArrayList<>();
        for (int i = 0; i < 74; i++) {
            listNum.add(i, rand.nextInt(101));
        }
        Collections.sort(listNum);
        System.out.println(listNum);
    }

    public static void main(String[] args) {

        ListaAleatorios la = new ListaAleatorios();
    }
}
