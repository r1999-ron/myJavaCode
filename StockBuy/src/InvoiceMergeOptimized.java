package com.ronak.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Invoices {
	private String invoiceNumber;
	private Double openAmount;

	public Invoices(String invoiceNumber, Double openAmount) {
		this.invoiceNumber = invoiceNumber;
		this.openAmount = openAmount;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public Double getOpenAmount() {
		return openAmount;
	}

	public String setInvoiceNumber(String invoiceNumber) {
		return this.invoiceNumber = invoiceNumber;
	}

	public Double setOpenAmount(Double openAmount) {
		return this.openAmount = openAmount;
	}

	@Override
	public String toString() {
		return "Invoice Number: " + invoiceNumber + ", Open amount: " + openAmount;
	}

}

class InvoiceMerger {
	private Map<String, Double> invoiceMap;

	public InvoiceMerger() {
		this.invoiceMap = new HashMap<>();
	}

	public void mergeInvoices(List<Invoices> invoices) {
		for (Invoices invoice : invoices) {
			String invoiceNumber = invoice.getInvoiceNumber();
			Double openAmount = invoice.getOpenAmount();
			// invoiceMap.put(invoiceNumber, invoiceMap.getOrDefault(invoiceNumber, 0.0) +
			// openAmount);
			if (invoiceMap.containsKey(invoiceNumber)) {
				invoiceMap.put(invoiceNumber, invoiceMap.get(invoiceNumber) + invoice.getOpenAmount());
			} else {
				invoiceMap.put(invoice.getInvoiceNumber(), invoice.getOpenAmount());
			}

		}
		Set<String> invoiceNumbers = invoiceMap.keySet();
		for (String invoiceNumber1 : invoiceNumbers) {
			System.out
					.println("Invoice Number: " + invoiceNumber1 + ", Open amount: " + invoiceMap.get(invoiceNumber1));
			Invoices invoice = new Invoices("I1", 100.0);
			invoice.setInvoiceNumber(invoiceNumber1);
			invoice.setOpenAmount(invoiceMap.get(invoiceNumber1));

			System.out.println("The object data: " + invoice);

		}

	}

	public Map<String, Double> getInvoiceMap() {
		return invoiceMap;
	}
}

public class InvoiceMergeOptimized {
	public static void main(String[] args) {
		List<Invoices> invoices = new ArrayList<>();
		invoices.add(new Invoices("I1", 100.0));
		invoices.add(new Invoices("I2", 200.0));
		invoices.add(new Invoices("I1", 50.0));
		invoices.add(new Invoices("I3", 50.0));

		System.out.println("The invoices List : " + invoices);

		InvoiceMerger invoiceMerger = new InvoiceMerger();
		invoiceMerger.mergeInvoices(invoices);

		/*
		 * Map<String, Double> invoiceMap = invoiceMerger.getInvoiceMap(); for
		 * (Map.Entry<String, Double> entry : invoiceMap.entrySet()) {
		 * System.out.println("Invoice number: " + entry.getKey() + " Open amount: " +
		 * entry.getValue()); Invoices invoice = null;
		 * invoice.setInvoiceNumber(entry.getKey());
		 * invoice.setOpenAmount(entry.getValue());
		 * System.out.println("Modified invoice: " + invoice);
		 * 
		 * }
		 */
	}
}
