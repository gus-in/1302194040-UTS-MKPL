package lib;

public class TaxFunction {
	
	private static final int incomeTaxRate = 0.05;
	private static final int deductiblesUnmarriedAndChildless = 54000000;
	private static final int maxNumberOfChildrenBonus = 3;
	
	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
		
		int tax = 0;
		int bonusDeductiblesMarried = 4500000;
		int bonusDeductiblesHaveChild = 1500000;
		
		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
		
		if (numberOfChildren > maxNumberOfChildrenBonus) {
			numberOfChildren = maxNumberOfChildrenBonus;
		}
		
		if (isMarried) {
			tax = (int) Math.round(incomeTaxRate * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - (deductiblesUnmarriedAndChildless + bonusDeductiblesMarried + (numberOfChildren * bonusDeductiblesHaveChild))));
		}else {
			tax = (int) Math.round(incomeTaxRate * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - deductiblesUnmarriedAndChildless));
		}
		
		if (tax < 0) {
			return 0;
		}else {
			return tax;
		}
			 
	}
	
}
