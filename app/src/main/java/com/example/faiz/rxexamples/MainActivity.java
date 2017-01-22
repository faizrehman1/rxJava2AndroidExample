package com.example.faiz.rxexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Observabless";
    ArrayList<String> arrayList;
    ArrayList<Integer> integers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<>();
        integers = new ArrayList<>();


        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);

        Connectable();



    }

    public void Connectable(){
        ConnectableObservable<Integer> in = ConnectableObservable.fromIterable(integers).publish();
               in.map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        return integer+2;
                    }
                })
        .subscribe(integer -> Log.i(TAG, "Connectable: "+integer));


        in.filter(integer -> integer%2==0).subscribe(integer -> Log.i(TAG, "Connectable: Filter "+integer));
        in.connect();
    }

    public void ExampleAmb(){

//        Observable.amb(
//                Observable.timer(100, TimeUnit.MILLISECONDS).map(i -> "First"),
//                Observable.timer(50, TimeUnit.MILLISECONDS).map(i -> "Second"))
//                .subscribe(System.out::println);
    }

    public void transformationRx(){
        arrayList.add("ImranKhan");
        arrayList.add("FaizKhan");
        arrayList.add("MoosaBaloch");
        arrayList.add("SamiUllah");
        arrayList.add("QasimShah");
        arrayList.add("BabaGiyani");
        arrayList.add("Bilalaaaa");

        integers.add(1);
        integers.add(13);
        integers.add(2);
        integers.add(12);
        integers.add(32);
        integers.add(30);
        integers.add(3);
        integers.add(5);



        System.out.println("Answer1================================");

        Observable.empty()
                .defaultIfEmpty("Hello World")
                .subscribe(o -> {
                    System.out.println(o);
                });

        System.out.println("Answer2================================");
        Observable.fromIterable(arrayList)
                .defaultIfEmpty("Hello World")
                .first("Helo")
                .subscribe(s -> {
                    System.out.println(s);
                });
        System.out.println();
        System.out.println("Answer3================================");
        Observable.fromIterable(arrayList)
                .skipWhile(s -> {
                    return s.length()<10;
                })
                .subscribe(s -> System.out.println(s));
        System.out.println("Answer4===============================");

        Observable.fromIterable(arrayList)
                .takeWhile(s -> {
                    return s.length()<9;
                })
                .subscribe(s -> System.out.println(s));

        System.out.println("Answer5================================");


        Observable.fromIterable(integers)
                .defaultIfEmpty(0)
                .first(00)
                .subscribe(integer -> System.out.println(integer));
        System.out.println("Answer5================================");

        System.out.println();
        Observable.fromIterable(integers)
                .skipWhile(integer -> {
                    return integer<9;
                }).subscribe(integer -> System.out.println(integer));
        System.out.println("Answer5================================");

        System.out.println();
        Observable.fromIterable(integers)
                .takeWhile(integer -> {
                    return integer<8;
                }).subscribe(integer -> System.out.println(integer));
        System.out.println("Answer5================================");

        System.out.println();

    }

}
