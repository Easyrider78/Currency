package Curren;

import java.io.IOException;

public class Start {

    public static void main(String[] args) throws IOException {
        String date = args[0];
        String baseCurrency = args[1];
        String targetCurrency = args[2];

        Curren curren = new Curren();
        String ourCurr = curren.getCurr(date, baseCurrency, targetCurrency);

        System.out.println(ourCurr);


    }


}



