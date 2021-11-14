package com.easycode.calculatorr;

import java.io.Serializable;

public class Computation implements Serializable {
    private Double number1;
    private Double number2;
    private Double answer;
    private char sign;
    private String text = "";


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }


    public void computation (String text) {
        if (number1 == null) {
            number1 = Double.parseDouble(text);
        } else {
            number2 = Double.parseDouble(text);
        }
    }

    public Double solution () {
         switch (sign) {
             case '+':
                 answer = number1 + number2;
                 nullNumber();
                 return answer;
             case '−':
                 answer = number1 - number2;
                 nullNumber();
                 return answer;
             case '÷':
                 answer = number1 / number2;
                 nullNumber();
                 return answer;
             case '×':
                 answer = number1 * number2;
                 nullNumber();
                 return answer;
         }
        return null;
    }

    private  void  nullNumber () {
        number1 = null;
        number2 = null;
    }

}
