package de.interhyp.cashbook.model;

import java.util.Date;

/**
 * Created by odyssefs on 25.02.17.
 */
public class MonthSheet {
  private Date month;
  private BookingRecord record;
  private double carryoverAmount;

  public MonthSheet(Date month, BookingRecord record, double carryoverAmount) {
    this.month = month;
    this.record = record;
    this.carryoverAmount = carryoverAmount;
  }

  public MonthSheet (){
  }

  public BookingRecord getRecord() {

    return record;
  }

  public void setRecord(BookingRecord record) {
    this.record = record;
  }

  public double getCarryoverAmount() {
    return carryoverAmount;
  }

  public void setCarryoverAmount(double carryoverAmount) {
    this.carryoverAmount = carryoverAmount;
  }

  public Date getMonth() {

    return month;
  }

  public void setMonth(Date month) {
    this.month = month;
  }

  public String toHTML() {
    return null;
  }
}
