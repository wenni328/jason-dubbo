package com.jason.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: xieyong
 * @date: 2018/8/31 14:26
 * @Description:
 */
public class Java8Test {

    @Test
    public void testList() {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> result = Arrays.asList(atp);
        result.forEach(o -> System.out.println(o));
    }

    @Test
    public void testThread() {
        new Thread(() -> System.out.println("Hello world !")).start();
    }

    @Test
    public void testSort() {
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro"};
        Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(players, sortByName);
        Arrays.asList(players).forEach(o -> System.out.println(o));
    }
    @Test
    public void testStream() {
        List<Person> list = new ArrayList<Person>() {
            {
                add(new Person("a", "man", 23, 6000));
                add(new Person("b", "man", 13, 15742));
                add(new Person("c", "female", 43, 4000));
                add(new Person("d", "man", 12, 2344));
                add(new Person("e", "female", 3, 9000));
                add(new Person("f", "female", 34, 3456));
            }
        };
        list.stream()
                .filter((o) -> (o.getMoney() > 3500))
                .filter((o)->(o.getSex().equals("man")))
                //.limit(2)//输出数量
                .forEach((o) -> System.out.println(o.getName()+"："+o.getMoney()));
    }

    @Test
    public void testA(){
        String waibu = "lambda :";
        List<String> proStrs = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
        List<String> execStrs = proStrs.stream().map(chuandi -> {
            Long zidingyi = System.currentTimeMillis();
            return waibu + chuandi + " -----:" + zidingyi;
        }).collect(Collectors.toList());
        execStrs.forEach(System.out::println);
    }
}
