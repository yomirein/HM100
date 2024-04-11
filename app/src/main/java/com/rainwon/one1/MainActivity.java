package com.rainwon.one1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // поля
    private EditText input;
    private Button button;
    private TextView output;
    private int listSize; // длина списков
    private List<Integer> arrayList = new ArrayList<>(); // список ArrayList
    private List<Integer> linkedList = new LinkedList<>(); // список LinkedList

    private long timeOne, timeTwo, timeThree; // отсчёты времени

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // привязка полей к разметке
        input = findViewById(R.id.input);
        button = findViewById(R.id.button);
        output = findViewById(R.id.output);

        // обработка нажатия кнопки
//        button.setOnClickListener(listener);
        button.setOnClickListener(listenerHomework);
    }

    // создание слушателя кнопки
    private View.OnClickListener listenerHomework = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            // считывание длины списков
            try {
                listSize = Integer.parseInt(input.getText().toString());
            } catch (NumberFormatException numberFormatException) {
                Toast.makeText(MainActivity.this, "Необходимо ввести размер списков в виде числа", Toast.LENGTH_SHORT).show();
            }

            // инициализация списков
            timeOne = SystemClock.uptimeMillis(); // колличество миллисекунд с момента загрузки
            arrayList = addListHomework(arrayList);
            timeTwo = SystemClock.uptimeMillis(); // колличество миллисекунд с момента загрузки
            linkedList = addListHomework(linkedList);
            timeThree = SystemClock.uptimeMillis(); // колличество миллисекунд с момента загрузки

            // вывод результатов
            output.setText("Время заполнения ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВремя заполнения LinkedList " + (timeThree - timeTwo) + " мс");

            // поиск элемента в начале списка
            timeOne = SystemClock.uptimeMillis(); // колличество миллисекунд с момента загрузки
            arrayList.contains(0);
            timeTwo = SystemClock.uptimeMillis(); // колличество миллисекунд с момента загрузки
            arrayList.contains(0);
            timeThree = SystemClock.uptimeMillis(); // колличество миллисекунд с момента загрузки

            // вывод результатов
            output.append("\n\nВремя поиска элементов:\nВ начале ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ начале  LinkedList " + (timeThree - timeTwo) + " мс");

            // поиск элемента в середине списка
            timeOne = SystemClock.uptimeMillis(); // колличество миллисекунд с момента загрузки
            arrayList.contains(listSize/2);
            timeTwo = SystemClock.uptimeMillis(); // колличество миллисекунд с момента загрузки
            linkedList.contains(listSize/2);
            timeThree = SystemClock.uptimeMillis(); // колличество миллисекунд с момента загрузки

            // вывод результатов
            output.append("\nВ середине ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ середине  LinkedList " + (timeThree - timeTwo) + " мс");

            // поиск элемента в конце списка
            timeOne = SystemClock.uptimeMillis(); // колличество миллисекунд с момента загрузки
            arrayList.contains(listSize);
            timeTwo = SystemClock.uptimeMillis(); // колличество миллисекунд с момента загрузки
            linkedList.contains(listSize);
            timeThree = SystemClock.uptimeMillis(); // колличество миллисекунд с момента загрузки

            // вывод результатов
            output.append("\nВ конце ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ конце  LinkedList " + (timeThree - timeTwo) + " мс");
        }
    };

    // создание слушателя кнопки
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            // считывание длины списков
            try {
                listSize = Integer.parseInt(input.getText().toString());
            } catch (NumberFormatException numberFormatException) {
                Toast.makeText(MainActivity.this, "Необходимо ввести размер списков в виде числа", Toast.LENGTH_SHORT).show();
            }

            // инициализация списков
            timeOne = SystemClock.uptimeMillis(); // колличество миллисекунд с момента загрузки
            arrayList = addList(arrayList);
            timeTwo = SystemClock.uptimeMillis(); // колличество миллисекунд с момента загрузки
            linkedList = addList(linkedList);
            timeThree = SystemClock.uptimeMillis(); // колличество миллисекунд с момента загрузки

            // вывод результатов
            output.setText("Время заполнения ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВремя заполнения LinkedList " + (timeThree - timeTwo) + " мс");

            // добавление элемента в начало списка
            timeOne = SystemClock.uptimeMillis(); // колличество миллисекунд с момента загрузки
            arrayList.add(1, 10);
            timeTwo = SystemClock.uptimeMillis(); // колличество миллисекунд с момента загрузки
            linkedList.add(1, 10);
            timeThree = SystemClock.uptimeMillis(); // колличество миллисекунд с момента загрузки

            // вывод результатов
            output.append("\n\nВремя добавления элементов:\nВ начало ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ начало  LinkedList " + (timeThree - timeTwo) + " мс");

            // добавление элемента в середину списка
            timeOne = SystemClock.uptimeMillis(); // колличество миллисекунд с момента загрузки
            arrayList.add(listSize/2, 10);
            timeTwo = SystemClock.uptimeMillis(); // колличество миллисекунд с момента загрузки
            linkedList.add(listSize/2, 10);
            timeThree = SystemClock.uptimeMillis(); // колличество миллисекунд с момента загрузки

            // вывод результатов
            output.append("\nВ середину ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ середину  LinkedList " + (timeThree - timeTwo) + " мс");

            // добавление элемента в конец списка
            timeOne = SystemClock.uptimeMillis();
            arrayList.add(listSize+1, 10);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.add(listSize+1, 10);
            timeThree = SystemClock.uptimeMillis();

            // вывод результатов
            output.append("\nВ конец ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ конец  LinkedList " + (timeThree - timeTwo) + " мс");

            // замена элемента из начале списка
            timeOne = SystemClock.uptimeMillis();
            arrayList.set(1, 1000);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.set(1, 1000);
            timeThree = SystemClock.uptimeMillis();

            // вывод результатов
            output.append("\n\nВремя замены элементов:\nВ начале ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ начале  LinkedList " + (timeThree - timeTwo) + " мс");

            // замена элемента из середины списка
            timeOne = SystemClock.uptimeMillis();
            arrayList.set(listSize/2, 1000);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.set(listSize/2, 1000);
            timeThree = SystemClock.uptimeMillis();
            // вывод результатов
            output.append("\nВ середине ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ середине  LinkedList " + (timeThree - timeTwo) + " мс");

            // замена элемента из конца списка
            timeOne = SystemClock.uptimeMillis();
            arrayList.set(listSize, 1000);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.set(listSize, 1000);
            timeThree = SystemClock.uptimeMillis();

            // вывод результатов
            output.append("\nВ конце ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ конце  LinkedList " + (timeThree - timeTwo) + " мс");


            timeOne = SystemClock.uptimeMillis();
            arrayList.remove(1);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.remove(1);
            timeThree = SystemClock.uptimeMillis();

            // вывод результатов
            output.append("\n\nВремя удаления элементов:\nВ начале ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ начале  LinkedList " + (timeThree - timeTwo) + " мс");

            // удаление элемента из середины списка
            timeOne = SystemClock.uptimeMillis();
            arrayList.remove(listSize/2);
            timeTwo = SystemClock.uptimeMillis();
            timeThree = SystemClock.uptimeMillis();

            // вывод результатов
            output.append("\nВ середине ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ середине  LinkedList " + (timeThree - timeTwo) + " мс");

            // удаление элемента из конца списка
            timeOne = SystemClock.uptimeMillis();
            arrayList.remove(listSize);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.remove(listSize);
            timeThree = SystemClock.uptimeMillis();

            // вывод результатов
            output.append("\nВ конце ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ конце  LinkedList " + (timeThree - timeTwo) + " мс");
        }
    };

    private List<Integer> addList(List<Integer> list) {
        int integerBefore = 0;
        int integerAfter = 1;
        int integer;
        list.add(integerBefore);
        list.add(integerAfter);
        for (int i = 3; i <= listSize; i++) {
            integer = integerBefore + integerAfter;
            list.add(integer);
            integerBefore = integerAfter;
            integerAfter = integer;
        }
        return list;
    }

    private List<Integer> addListHomework(List<Integer> list) {
        int integer = 0;
        list.add(integer);
        for (int i = 1; i < listSize; i++) {
            integer += 10;
            list.add(integer);
        }
        return list;
    }
}