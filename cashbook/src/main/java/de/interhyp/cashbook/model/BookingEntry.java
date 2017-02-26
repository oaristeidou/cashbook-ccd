package de.interhyp.cashbook.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by odyssefs on 25.02.17.
 */
public class BookingEntry {
  @Id
  private String id;

  private Date date;
  private String name;
  private double amount;

  public BookingEntry(Date date, String name, double amount) {
    this.date = date;
    this.name = name;
    this.amount = amount;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    BookingEntry that = (BookingEntry) o;

    if (Double.compare(that.amount, amount) != 0) return false;
    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (date != null ? !date.equals(that.date) : that.date != null) return false;
    return name != null ? name.equals(that.name) : that.name == null;

  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = id != null ? id.hashCode() : 0;
    result = 31 * result + (date != null ? date.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    temp = Double.doubleToLongBits(amount);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }
}
