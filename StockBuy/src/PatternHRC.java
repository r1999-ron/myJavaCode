package com.ronak.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternHRC {

	public static void main(String[] args) {

		String regexForCustNum = "(?<=Account# |Account#|Customer |Customer|Act No. |Act No.|Customer # |Customer #|Acct # |Acct #|Acct# |Acct#|Cust# |Cust#|Account |Account|Acct No. |Acct No.|account details, |account details,|Accounts |Accounts|Customer# |Customer#|Acct |Acct|Customer no |Customer no|Account#:, accts |Account#:, accts|WESCO: |WESCO:|[(]WESCO |[(]WESCO|\\.)[0-9^\\-]{9,}+";

		ArrayList<String> emailMetaDataList = new ArrayList<>();
		emailMetaDataList.add("RE: 3444768 Ozarks Edureka Acct# 678889423 test Account# 456789012");
		emailMetaDataList.add("RE: Customer # 610439769-00 Johnson Crusher  Reque");
		emailMetaDataList.add("RE: Documentation Needed: Acct #");
		emailMetaDataList.add("RE: Acct No. MCCARTHY/INNOVATION PAYAP 753951625");
		emailMetaDataList.add("RE: 781524779 WESCO Dist. Acct # ECM/CYS17");
		emailMetaDataList.add("RE: AR Invoice - Account# (3375-79265)");

		emailMetaDataList.add("RE: AR Invoice - Customer# [753951628]");
		emailMetaDataList.add("RE: AR Invoice Acct No. ");

		Map<String, Integer> linkMap = new HashMap<>();
		Map<String, Integer> customerNumberMap = new HashMap<>();

		customerNumberMap.put("678889423", 1);
		customerNumberMap.put("456789012", 2);
		customerNumberMap.put("753951628", 3);
		customerNumberMap.put("781524779", 4);
		customerNumberMap.put("337579265", 5);
		customerNumberMap.put("583758740", 6);
		// customerNumberMap.put("098564738", 7);
		customerNumberMap.put("79265", 5);

		final HashMap<String, Integer> customerNumberMapAnonymous = new HashMap<>();

		if (!customerNumberMap.isEmpty()) {
			customerNumberMapAnonymous.putAll(customerNumberMap);
			System.out.println("Customer Number Map: -" + customerNumberMap);
		}
		emailMetaDataList.stream().forEach(emd -> {
			System.out.println(
					" ***********************************Email Processing*****************************************");
			System.out.println("Extracting emails from the email list :::: " + emd);

			String emailSubject = emd;

			try {

				Pattern pattern = Pattern.compile(regexForCustNum);
				if (!emailSubject.isBlank()) {

					emailSubject = emailSubject.replace("-", "");

					Matcher m = pattern.matcher(emailSubject);
					ArrayList<String> customerNumberList = new ArrayList<>();
					while (m.find()) {
						System.out.println("Customer Number: " + emailSubject.substring(m.start(), m.end()));
						String custNumber = emailSubject.substring(m.start(), m.end());
						customerNumberList.add(custNumber);
						System.out.println("The cust is " + customerNumberList);

					}
					if (!customerNumberList.isEmpty()) {
						for (String custNumber : customerNumberList) {
							System.out.println("default case customer number is : " + custNumber);
							if (customerNumberMapAnonymous.containsKey(custNumber)) {
								linkMap.put(emd, customerNumberMapAnonymous.get(custNumber));
								System.out.println("Linking map of customer Number :::  " + custNumber
										+ " from the customerNumberList" + customerNumberList + " is" + linkMap);

							} else {
								System.out.println("Linking not possible as " + custNumber
										+ " does not belong in the customer number map -> "
										+ customerNumberMapAnonymous);

							}
						}
					} else {
						System.out.println("No customer identified");
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		});

	}

}
