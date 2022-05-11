package academy.kata.test_task;

import java.util.Scanner;

public class calc {
    public static void main(String[] args) throws Exception {
        System.out.println(calc(new Scanner(System.in).nextLine()));
    }

    public static String calc(String input) throws Exception {
        String result = "";

        //Нормирование регистров
        input = input.toUpperCase();


        //Ввод данных в формате "A znak B"
        String[] tokens = input.split(" ");

        //Проверка на трех переменных
        if ((tokens.length != 3) || (tokens[1].length() > 1)) {
            throw new Exception("Неверное выражение " + input + ": Введите в формате A znak B");
        }

        var A = tokens[0];
        var B = tokens[2];
        var znak = tokens[1].charAt(0);

        // Проверка на правильность ввода A и B
        var LatNumbers = "0123456789";
        var RimNumbers = "IVX";

        // Проверка на правильность A
        var NumberCheckA = false;
        var RimNumberCheckA = false;
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < 10; j++) {
                if (A.charAt(i) == LatNumbers.charAt(j)) {
                    NumberCheckA = true;
                }
            }
            for (int j = 0; j < 3; j++) {
                if (A.charAt(i) == RimNumbers.charAt(j)) {
                    RimNumberCheckA = true;
                }
            }
            if (((NumberCheckA == false) & (RimNumberCheckA == false)) || ((NumberCheckA == true) & (RimNumberCheckA == true))) {
                throw new Exception("Неверное выражение A = " + A + ": Введите A и B только десятичными числами или только римскими числами");
            }
        }

        // Проверка на правильность B
        var NumberCheckB = false;
        var RimNumberCheckB = false;
        for (int i = 0; i < B.length(); i++) {
            for (int j = 0; j < 10; j++) {
                if (B.charAt(i) == LatNumbers.charAt(j)) {
                    NumberCheckB = true;
                }
            }
            for (int j = 0; j < 3; j++) {
                if (B.charAt(i) == RimNumbers.charAt(j)) {
                    RimNumberCheckB = true;
                }
            }
            if (((NumberCheckB == false) & (RimNumberCheckB == false)) || ((NumberCheckB == true) & (RimNumberCheckB == true))) {
                throw new Exception("Неверное выражение B = " + B + ": Введите A и B только десятичными числами или только римскими числами");
            }
        }

        //Проверка на разные исчисления
        if (((NumberCheckA == true) & (RimNumberCheckB == true)) || ((NumberCheckB == true) & (RimNumberCheckA == true))) {
            throw new Exception("Неверное выражение " + input + ": A и B не должны быть в разных системах исчисления");
        }

        //Проверка знака
        if ((znak != '+') & (znak != '-') & (znak != '*') & (znak != '/')) {
            throw new Exception("Неверный знак в выражении: " + znak + " не является + - * /");
        }

        //Преобразование выражения в int
        int a = 0;
        int b = 0;

        if (NumberCheckA == true) {
            a = Integer.parseInt(A);
            b = Integer.parseInt(B);
            if ((a < 1) || (a > 10) || (b < 1) || (b > 10)) {
                throw new Exception("Прости братан, числа на вход могут быть только от 1 до 10");
            }
        } else {
            //Преобразование римских чисел A и B
            switch (A) {
                case "I":
                    a = 1;
                    break;
                case "II":
                    a = 2;
                    break;
                case "III":
                    a = 3;
                    break;
                case "IV":
                    a = 4;
                    break;
                case "V":
                    a = 5;
                    break;
                case "VI":
                    a = 6;
                    break;
                case "VII":
                    a = 7;
                    break;
                case "VIII":
                    a = 8;
                    break;
                case "IX":
                    a = 9;
                    break;
                case "X":
                    a = 10;
                    break;
                default:
                    throw new Exception("Прости братан, числа на вход могут быть только от I до X" + a);
            }

            switch (B) {
                case "I":
                    b = 1;
                    break;
                case "II":
                    b = 2;
                    break;
                case "III":
                    b = 3;
                    break;
                case "IV":
                    b = 4;
                    break;
                case "V":
                    b = 5;
                    break;
                case "VI":
                    b = 6;
                    break;
                case "VII":
                    b = 7;
                    break;
                case "VIII":
                    b = 8;
                    break;
                case "IX":
                    b = 9;
                    break;
                case "X":
                    b = 10;
                    break;
                default:
                    throw new Exception("Прости братан, числа на вход могут быть только от I до X" + a);
            }
        }

        //Результат в int
        switch (znak) {
            case '+':
                result = String.valueOf(a + b);
                break;
            case '-':
                result = String.valueOf(a - b);
                break;
            case '*':
                result = String.valueOf(a * b);
                break;
            case '/':
                result = String.valueOf(a / b);
                break;
        }

        //Переобразование ответа в римский
        if (RimNumberCheckA == true) {
            var BufferResult = Integer.parseInt(result);
            result = "";
            if (BufferResult < 1) {
                throw new Exception("Прости братан, в римском нету чисел < 1, а так ответ: " + BufferResult);
            }
            if ((BufferResult - 100) >= 0) {
                result = result + "C";
                BufferResult = BufferResult - 100;
            }
            if ((BufferResult - 90) >= 0) {
                result = result + "XC";
                BufferResult = BufferResult - 90;
            }
            if ((BufferResult - 80) >= 0) {
                result = result + "LXXX";
                BufferResult = BufferResult - 80;
            }
            if ((BufferResult - 70) >= 0) {
                result = result + "LXX";
                BufferResult = BufferResult - 70;
            }
            if ((BufferResult - 60) >= 0) {
                result = result + "LX";
                BufferResult = BufferResult - 60;
            }
            if ((BufferResult - 50) >= 0) {
                result = result + "L";
                BufferResult = BufferResult - 50;
            }
            if ((BufferResult - 40) >= 0) {
                result = result + "XL";
                BufferResult = BufferResult - 40;
            }
            if ((BufferResult - 30) >= 0) {
                result = result + "XXX";
                BufferResult = BufferResult - 30;
            }
            if ((BufferResult - 20) >= 0) {
                result = result + "XX";
                BufferResult = BufferResult - 20;
            }
            if ((BufferResult - 10) >= 0) {
                result = result + "X";
                BufferResult = BufferResult - 10;
            }
            if ((BufferResult - 9) >= 0) {
                result = result + "IX";
                BufferResult = BufferResult - 9;
            }
            if ((BufferResult - 8) >= 0) {
                result = result + "VIII";
                BufferResult = BufferResult - 8;
            }
            if ((BufferResult - 7) >= 0) {
                result = result + "VII";
                BufferResult = BufferResult - 7;
            }
            if ((BufferResult - 6) >= 0) {
                result = result + "VI";
                BufferResult = BufferResult - 6;
            }
            if ((BufferResult - 5) >= 0) {
                result = result + "V";
                BufferResult = BufferResult - 5;
            }
            if ((BufferResult - 4) >= 0) {
                result = result + "IV";
                BufferResult = BufferResult - 4;
            }
            if ((BufferResult - 3) >= 0) {
                result = result + "III";
                BufferResult = BufferResult - 3;
            }
            if ((BufferResult - 2) >= 0) {
                result = result + "II";
                BufferResult = BufferResult - 2;
            }
            if ((BufferResult - 1) >= 0) {
                result = result + "I";
                BufferResult = BufferResult - 1;
            }
        }
        return result;

    }
}





