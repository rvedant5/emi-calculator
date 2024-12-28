package Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EMIController {

	@GetMapping("/calculateEMI")
	public String calculateEMI(
	        @RequestParam(defaultValue = "0") double loanAmount,
	        @RequestParam(defaultValue = "0") double interestRate,
	        @RequestParam(defaultValue = "0") int tenureYears) {

	    if (loanAmount <= 0 || interestRate <= 0 || tenureYears <= 0) {
	        return "Invalid input values. Please ensure all parameters are positive.";
	    }

	    double monthlyRate = interestRate / 12 / 100;
	    int tenureMonths = tenureYears * 12;

	    double emi = (loanAmount * monthlyRate * Math.pow(1 + monthlyRate, tenureMonths)) /
	                 (Math.pow(1 + monthlyRate, tenureMonths) - 1);

	    double totalInterest = (emi * tenureMonths) - loanAmount;

	    return String.format("EMI: %.2f, Total Interest: %.2f", emi, totalInterest);
	}

    
    @GetMapping("/test")
    public String test() {
        return "Test endpoint working!";
    }
}

