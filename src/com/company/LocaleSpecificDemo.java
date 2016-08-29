package com.company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

/**
 * Created by yonglinx on 8/29/16.
 */
@WebServlet(name = "LocaleSpecificDemo")
public class LocaleSpecificDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        long number = 5000000L;

        NumberFormat numberFormatDefault = NumberFormat.getNumberInstance();
        out.println(numberFormatDefault.format(number));//5,000,000

        NumberFormat numberFormatLocale = NumberFormat.getNumberInstance(Locale.FRENCH);
        out.println(numberFormatLocale.format(number));//5 000 000

        NumberFormat numberFormatDefaultCurrency = NumberFormat.getCurrencyInstance();
        out.println(numberFormatDefaultCurrency.format(number));//$5,000,000.00

        NumberFormat numberFormatLocaleCurrency = NumberFormat.getCurrencyInstance(Locale.UK);
        out.println(numberFormatLocaleCurrency.format(number));//£5,000,000.00

        Currency currency = Currency.getInstance(Locale.JAPAN);
        out.println(currency.getDisplayName() + " " + currency.getCurrencyCode());//Japanese Yen JPY

        Date currentDate = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.FRENCH);
        out.println(dateFormat.format(currentDate));//lundi 29 août 2016
    }
}
