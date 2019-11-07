package miniprj;

import java.io.Serializable;
import java.util.Date;

public class PaymentEntry implements Serializable{
	
	private String paymentId;
	private double price;
	private Date date;
	private PaymentType paymentType;
	
	
	public PaymentEntry(String paymentId, double price, Date date, PaymentType paymentType ) {
		this.paymentId = paymentId;
		this.price = price;
		this.date = date;
		this.paymentType = paymentType;
	}
	
	public String getPaymentId() {
		return paymentId;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public PaymentType getPaymentType() {
		return paymentType;
	}
	
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
		
		
}