package de.interhyp.cashbook.legacy;

import de.interhyp.cashbook.model.BookingEntry;
import de.interhyp.cashbook.model.BookingStatus;
import de.interhyp.cashbook.model.MonthSheet;

import java.util.Date;
import java.util.function.Consumer;

/**
 * Created by odyssefs on 25.02.17.
 */
public class UI {
  Consumer<BookingEntry> buchungVornahmeCosumer;
  Consumer<Date> monatBlattConsumer;

  void showBuchungStatus(final BookingStatus status) {
    switch (status) {
      case OK:
        monatBlattConsumer.accept(null);
        break;
      case ERROR:
        System.out.println("--- Error ---");
        break;
    }
  }

  void showMonatsBlatt(final MonthSheet monatBlatt) {
    System.out.println(" MonatsBlatt should be rendered ------ ");
  }


  void run() {
    // while for input eingabe
    BookingEntry eingabe = new BookingEntry("04.09.2016", "Test betrag", 100d);
    buchungVornahmeCosumer.accept(eingabe);

    //monatBlattConsumer.accept(new Date());
  }
}
