package de.interhyp.cashbook.model;

import java.util.Date;

/**
 * Created by odyssefs on 25.02.17.
 */
public class BookingRecord {
  private Date date;
  private String name;
  private double amount;
  private double status;

  public BookingRecord(Date date, String name, double amount, double status) {
    this.date = date;
    this.name = name;
    this.amount = amount;
    this.status = status;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public double getStatus() {
    return status;
  }

  public void setStatus(double status) {
    this.status = status;
  }
}
