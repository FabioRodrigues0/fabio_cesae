package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Test {
    ArrayList<Integer> listAlunos = new ArrayList<>();

    /*System.out.println(ordemAleatoria);
    for (int numero : ordemAleatoria){
        System.out.println(listAlunos.get(numero));
    }*/

    public Test() {
        listAlunos.add(5);
        listAlunos.add(1);
        listAlunos.add(10);
        int size =  listAlunos.size();

        Set<Integer> ordemAleatoria = new Random()
                                            .ints(0, size)
                                            .distinct()
                                            .limit(listAlunos.size())
                                            .boxed()
                                            .collect(Collectors.toSet());
        System.out.println(ordemAleatoria);
        for (int numero : ordemAleatoria) {
            System.out.println(listAlunos.get(numero));
        }
    }

    public static void main(String[] args) {
        new Test();
    }
}