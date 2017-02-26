package de.interhyp.cashbook.rest.controller;

import de.interhyp.cashbook.model.BookingEntry;
import de.interhyp.cashbook.model.MonthSheet;
import de.interhyp.cashbook.repository.IMensagemRepository;
import de.interhyp.cashbook.service.BookingImpl;
import de.interhyp.cashbook.service.IBooking;
import de.interhyp.cashbook.service.IMonatSheet;
import de.interhyp.cashbook.service.MonatSheetImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by odyssefs on 25.02.17.
 */
@RestController
public class CashbookApi {

  private IBooking booking = new BookingImpl();
  private IMonatSheet monatSheet = new MonatSheetImpl();

  @Autowired
  private IMensagemRepository mensagemRepository;

  @RequestMapping(value = "/book", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.OK)
  public void buchungVornehmen (@RequestBody BookingEntry bookingEntry){
    mensagemRepository.save(bookingEntry);
  }

  @RequestMapping(value = "/monthsReportCalc", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<BookingEntry> monatsBlattBrechnen ()
  {
  return mensagemRepository.findAll();
  }
}
