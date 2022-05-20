package com.dongyin.offer;

import org.hamcrest.internal.ArrayIterator;
import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author dystart
 * @create 2022-03-15 23:12
 */
public class CollectionTest {
    public StringBuffer buffer;
    public BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
    public BlockingQueue linkedBlockingQueue = new LinkedBlockingDeque(3);

    public CopyOnWriteArrayList copyOnWriteArrayList;


    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        HashSet<Integer> integers = new HashSet<>();
        Iterator<Integer> iterator2 = integers.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }


        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        hashMap.put(3, null);
        hashMap.put(1, 2);
        hashMap.put(null, null);
        int array[] = {1, 2, 3};
        Iterator iterator = new ArrayIterator(array);

        Iterator hashIterator = new ArrayIterator(list.toArray());
        Iterator<Object> iterator1 = list.iterator();
        while (hashIterator.hasNext()) {
            System.out.println(hashIterator.next());
        }


        System.out.println(hashMap.get(null));
        System.out.println(hashMap.get(1));
    }

    @Test
    public void extracted() {
        ArrayList<Integer> integers1 = new ArrayList<>();
        integers1.add(5);
        ListIterator<Integer> integerListIterator = integers1.listIterator();
        while (integerListIterator.hasNext()) {
            integerListIterator.add(1);
            integerListIterator.add(2);
            integerListIterator.add(4);
            integerListIterator.add(3);
            System.out.println(integerListIterator.next());
        }
    }

    @Test
    public void test() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(12);
        list.add(3);
        copyOnWriteArrayList = new CopyOnWriteArrayList(list);
        ArrayIterator arrayIterator = new ArrayIterator(copyOnWriteArrayList.stream().toArray());
        while (arrayIterator.hasNext()) {
            System.out.println(arrayIterator.next());
        }
    }

    @Test
    public void testList() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(2);
        Object o = list.get(0);
        System.out.println(o);
    }

    @Test
    public void testSet() {
        HashSet<Object> objects = new HashSet<>();
        objects.add(2);
        objects.add(1);
        objects.add(3);
        Iterator<Object> iterator = objects.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testQueue() {
        BlockingQueue<Object> objects = new LinkedBlockingQueue<>(1);
        objects.add(1);
        System.out.println(objects.poll());
        objects.add(2);


    }

    @Test
    public void testSort() {
        ArrayList<Integer> integers = new ArrayList<>();
//        TreeSet<Integer> integers = new TreeSet<>();
        integers.add(25);
        integers.add(24);
        integers.add(4);
        integers.add(3);
        for (Integer integer : integers) {
            System.out.println(integer);
        }

        Collections.sort(integers, (o1, o2) -> o1 - o2);
        Collections.sort(integers, (Integer o1, Integer o2) -> {
            return o2 - o1;
        });

        Collections.sort(integers, new Comparator<Integer>() {
            /**
             * @param o1
             * @param o2
             * @return
             */
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        for (Integer integer : integers) {
            System.out.println(integer);
        }


    }

    @Test
    public void testFunction() {
        new Runnable() {
            @Override
            public void run() {
                System.out.println("我睡觉哦");
            }
        }.run();
        System.out.println("我睡觉哦");


        System.out.println(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer.equals(0);
            }
        }.test(0));

        System.out.println(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 1;
            }
        }.apply(8));

        System.out.println(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 6;
            }
        });

        new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        }.accept(5);


    }


    @Test
    public void testStream() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(3);
        integers.add(4);
        integers.add(1);
        integers.add(2);
        integers.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 2;
            }
        }).sorted((o1, o2) -> o1-o2)
                .map(new Function<Integer, String >() {
                    @Override
                    public String apply(Integer integer) {
                        return integer.toString();
                    }
                })
                .forEach(integer -> System.out.println(integer));

    }

    @Test
    public void testDate(){
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);
        Instant instant = clock.instant();
        Date from = Date.from(instant);
        System.out.println(from);

    }
}
