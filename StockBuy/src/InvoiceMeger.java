package com.ronak.leetcode.problems;

import java.util.HashMap;
import java.util.Set;

public class InvoiceMeger {
	public static void main(String[] args) {
		Invoice[] invoices = { new Invoice("Invoice1", 100.0), new Invoice("Invoice2", 200.0),
				new Invoice("Invoice1", 150.0), new Invoice("Invoice3", 50.0), new Invoice("Invoice2", 50.0),
				new Invoice("", 0), new Invoice("Invoice3", 100.0), new Invoice("Invoice4", 67.0) };

		System.out.println(invoices);

		HashMap<String, Double> map = new HashMap<>();
		for (Invoice invoice : invoices) {
			String invoiceNumber = invoice.getInvoiceNumber();
			if (invoiceNumber != null && !"".equals(invoiceNumber)) {
				if (map.containsKey(invoiceNumber)) {
					map.put(invoiceNumber, map.get(invoiceNumber) + invoice.getOpenAmount());
				} else {
					map.put(invoice.getInvoiceNumber(), invoice.getOpenAmount());
				}
			}
		}

		System.out.println(map);
		Set<String> invoiceNumbers = map.keySet();
		for (String invoiceNumber : invoiceNumbers) {
			System.out.println("Invoice Number: " + invoiceNumber + ", Open amount: " + map.get(invoiceNumber));
		}
	}
}

class Invoice {
	private String invoiceNumber;
	private double openAmount;

	public Invoice(String invoiceNumber, double openAmount) {
		this.invoiceNumber = invoiceNumber;
		this.openAmount = openAmount;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public double getOpenAmount() {
		return openAmount;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public void setOpenAmount(double openAmount) {
		this.openAmount = openAmount;
	}

}
