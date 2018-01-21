package ru.spbstu.telematics.java;
import java.util.*;
import org.junit.Test;
import ru.spbstu.telematics.java.TreeSet;

public class TreeSetTest {

    @Test
    public void Test1(){

        TreeSet<Integer> states = new TreeSet<Integer>();

        states.add(states.root,2);
        states.add(states.root,3);
        states.add(states.root,4);
        states.add(states.root,1);
        System.out.printf("В дереве %d элементов после добавления ", states.getSize());

        states.remove(2);
        System.out.printf("\nВ дереве %d элементов после удаления ", states.getSize());

        for(int k=3;k<6;k++) {
            states.i=0;
            if (states.contains(k) == 1) System.out.printf("\nДерево содержит %d", k);
            else System.out.printf("\nДерево не содержит %d\n", k);
        }
    }


    @Test
    public void Test2(){

        TreeSet<String> states = new TreeSet<String>();

        states.add(states.root,"Германия");
        states.add(states.root,"Франция");
        states.add(states.root,"Италия");
        states.add(states.root,"Великобритания");
        System.out.printf("\n\nВ дереве %d элементов после добавления ", states.size);

        states.remove("Германия");
        System.out.printf("\nВ дереве %d элементов после удаления ", states.getSize());

        String str = "Италия"; states.i =0;
        if (states.contains(str) == 1) System.out.printf("\nДерево содержит %s", str);
        else System.out.printf("\nДерево не содержит %s\n", str);

        str = "Испания"; states.i =0;
        if (states.contains(str) == 1) System.out.printf("\nДерево содержит %s", str);
        else System.out.printf("\nДерево не содержит %s\n", str);
    }
}
