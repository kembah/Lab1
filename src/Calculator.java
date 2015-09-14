import java.util.Scanner;
import org.apache.poi.ss.formula.functions.FinanceLib;
public class Calculator {

	public static void main(String[] args){
		
		// Takes input from user
		Scanner input = new Scanner(System.in);
		System.out.println("Enter years to work:");
		int years = input.nextInt();
		System.out.println("Enter annual return saving");
		float annual_return_s = input.nextFloat();
		System.out.println("Enter years retired:");
		int retired_years = input.nextInt();
		//The money that would be taken once retirement starts
		System.out.println("Enter annual return drawing:");
		float annual_return_d = input.nextFloat();
		System.out.println("Enter required income:");
		float required_income = input.nextFloat();
		System.out.println("Enter monthly SSI:");
		float monthly_SSI = input.nextFloat();
		
		//Variable equated to function with respected parameters 
		float monthlyNeededSavings = calculateNeededSavings(annual_return_d,retired_years, monthly_SSI, required_income);
		float monthlySaving = calculateMonthlySaving(years,annual_return_s,monthlyNeededSavings);
		System.out.println("Here is your Needed Savings:" + monthlyNeededSavings);
		System.out.println("Here is your Monthly Savings:" + monthlySaving);
		
	}
	
	public static float calculateNeededSavings(float annual_return_d,int retired_years, float monthly_SSI, float required_income){
		return (float) FinanceLib.pv(annual_return_d/12, retired_years*12,(required_income- monthly_SSI), 0, false)* -1;
		
	}
	public static float calculateMonthlySaving(int years, float annual_return_s, float monthlyNeededSavings){
		return (float) FinanceLib.pmt(annual_return_s/12,years*12,0, monthlyNeededSavings,false)*-1;
	}
}
