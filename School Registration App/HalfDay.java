package parentSignup;

public class HalfDay extends Account
{
		// Instance fields specific to an account made for a student attending school for halfDay
		private int halfParentPin;
		private int halfStudentID;
			
		/**
		 * Constructor to initialize parent account
		 * @param size the number of elements in the set
		 */
		public HalfDay(String parentName, String studentName, String phoneNumber) 
		{
			super(parentName, studentName, phoneNumber);
			accountNumber = "1" + accountNumber;
			setAccount();
		}
		
		/**
		 * setFee method sets fee equal to the amount a parent has to pay for halfDay for 10 months
		 * @param no parameters for this method
		 */
		@Override
		public void setFee()
		{
			fee = getFee() * 10 * 0.5;
		}
		
		//Methods specific to a student attending school for halfDay
		/**
		 * setAccountMethod sets the parent pin and the student ID
		 * @param there is no parameters for this method
		 */
		private void setAccount()
		{
			halfParentPin = (int) (Math.random() * Math.pow(10, 5));
			halfStudentID = (int) (Math.random() * Math.pow(10, 4));
		}
			
		/**
		 * showInfo method prints the parent pin and the student ID
		 * @param there is no parameter for this method
		 */
		public void showInfo() 
		{
			super.showInfo();
			System.out.println
			(
			" HalfDay Account Features" +
			"\n Parent Entry Pin: " + halfParentPin +
			"\n Student School ID: " + halfStudentID
		     );
		}


}
