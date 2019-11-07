package miniprj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



public class Payment implements Serializable{
	
	private ArrayList<PaymentEntry> payment = new ArrayList<PaymentEntry>();
	
	public Payment() {
		
	}
	
	public PaymentEntry createPayment(String paymentId, double price, PaymentType paymentType) {
		Date date = Calendar.getInstance().getTime();
		payment.add(new PaymentEntry(paymentId, price, date, paymentType));
		return payment.get(payment.size()-1);
	}
	
	public ArrayList<PaymentEntry> removePayment(String paymentId){
		for(PaymentEntry i : payment) {
			if(i.getPaymentId().equals(paymentId)) {
				payment.remove(i);
				return payment;
			}
		}
		return payment;
	}

	
	
	/*public void removePayment(PaymentEntry paymentEntry) {
		paymentlist.remove(paymentEntry);
	}
	
	public PaymentEntry getPaymentEntry(String paymentid) {
		for (PaymentEntry i : paymentlist) {
			if(i.getPaymentId().equals(paymentid)) {
				return i;
			}
		}
	}
	public List<PaymentEntry> getPaymentEntry(){
		return paymentlist;
	}
	
}


	
	public interface TransactionDAO {
	public void createTransaction(Transaction transaction);
	public void updateTransaction(Transaction transaction);
	public void deleteTransaction(Transaction transaction);
		
	public Transaction getTransaction(String tid);
	public List<Transaction> getTransactions();*/
}
