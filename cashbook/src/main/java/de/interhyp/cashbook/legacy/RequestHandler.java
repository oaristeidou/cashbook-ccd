package de.interhyp.cashbook.legacy;

import de.interhyp.cashbook.model.BookingStatus;
import de.interhyp.cashbook.model.MonthSheet;

import java.util.Date;
import java.util.function.Consumer;

/**
 * Created by odyssefs on 25.02.17.
 */
public class RequestHandler {
  Consumer<BookingStatus> buchungStatus;
  Consumer<MonthSheet> monatBlatDisplay;

  void buchungVornehmen (final double betrag, final String art, final Date datum) {
    // TODO create Booking
    buchungStatus.accept(BookingStatus.OK);
  }

  void monatsBlattBrechnen(final Date datum) {
    // TODO find the bookings of the month
    monatBlatDisplay.accept(new MonthSheet());
  }
}
