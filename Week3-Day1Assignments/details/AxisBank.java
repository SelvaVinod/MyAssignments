package bank.details;

public class AxisBank extends BankInfo {
	
	public void deposit() {
		System.out.println("AxisBank Deposit Information");
	}

	public static void main(String[] args) {
		AxisBank test = new AxisBank();
		test.saving();
		test.fixed();
		test.deposit();


	}

}
