package parentSignup;

public abstract class Account implements Fee
{

			//Common properties for savings and checking accounts
			// Instance fields used in both FullDay and HalfDay
			private String parentName;
			private String studentName;
			private String phoneNumber;
			private static int index = 100;
			protected String accountNumber;
			protected double fee;
			
			/**
			 * Constructor to initialize parent account
			 * @param size the number of elements in the set
			 */ 
			public Account(String parentName, String studentName, String phoneNumber) 
			{
				this.parentName = parentName;
				this.studentName = studentName;
				this.phoneNumber = phoneNumber;
						
				// Set Account Number
				index++; 
				this.accountNumber = setAccountNumber();
			    setFee();
			}
			/**
			 * Get method from Fee interface
			 */
			public abstract void setFee();
			
			/**
			 * adds together last 4 digits of phone number, unique ID, and 3 random numbers
			 * @return String of account number
			 */
			private String setAccountNumber() 
			{
				String lastFourOFPhoneNumber = phoneNumber.substring(phoneNumber.length()-4, phoneNumber.length());
				int uniqueID = index;
				int randomNumber = (int) (Math.random() * Math.pow(10, 3));
				return lastFourOFPhoneNumber + uniqueID + randomNumber;
			}
			
			// Common methods - transactions
			/**
			 * prints the account info
			 * @param no parameters for this method
			 */
			public void showInfo()
			{
				System.out.println(
						"NAME: " + parentName+
						"\nSTUDENT: " + studentName + 
						"\nACCOUNT NUMBER: " + accountNumber+
						"\nFEE: " + fee
						);
			}
			
}
