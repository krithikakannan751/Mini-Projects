package parentSignup;

public class FullDay extends Account
{

		// Instance fields specific to an account made for a student attending school for fullDay
		private int fullParentPin;
		private int fullStudentID;
		
		/**
		 * Constructor to initialize parent account
		 * @param size the number of elements in the set
		 */ 
		public FullDay(String parentName, String studentName, String phoneNumber) 
		{
			super(parentName, studentName, phoneNumber);
			accountNumber = "2" + accountNumber;
			setAccount();
		}

		/**
		 * setFee method sets fee equal to the amount a parent has to pay for halfDay for 10 months
		 * @param no parameters for this method
		 */
		@Override
		public void setFee()
		{
			fee = getFee() * 10;
		}
		
		//Methods specific to parent account for one year
		/**
		 * setAccountMethod sets the parent pin and the student ID
		 * @param there is no parameters for this method
		 */
		private void setAccount()
		{
			fullParentPin = (int) (Math.random() * Math.pow(10, 5));
			fullStudentID = ((int) (Math.random() * Math.pow(10, 4)) *10);
		}
		
		/**
		 * showInfo method prints the parent pin and the student ID
		 * @param there is no parameter for this method
		 */
		public void showInfo() 
		{
			super.showInfo();
			System.out.println(
			" FullDay Account Features" +
			"\n Parent Entry Pin: " + fullParentPin +
			"\n Student School ID: " + fullStudentID
			);
		}
		

}
