//Calculation Project
//Damodien Johnson
//Completion date 1/25/2025
//Description: A program that does calculations based on a user choice.
//Features include: Monthly Budget Calculator, BMI Calculator, Grades Calculator,
//                  Loan Interest Calculator, Random Number Analyzer


import java.util.*;
import java.text.NumberFormat;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Creates an array of calculation choices, this will serve as a menu as well.

        String[] methods = {"Monthly Budget Calculator", "BMI Calculator", "Grades Calculator",
                "Loan Interest Calculator", "Random Number Analyzer"};
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
        }

        while (true) {
            System.out.println("\nWhich calculator would you like to use? Please choose the number associated with each calculation: \n" +
                    " (1) Monthly Budget Calculator \n (2) BMI Calculator \n (3) Grades Calculator \n (4) Loan Interest Calculator" +
                    "\n (5) Random Number Analyzer");
            int choice = scanner.nextInt();
            scanner.nextLine();

            //I combine the while loop with try catch to loop both invalid integer numbers and non-integer numbers. You will see this throughout the entire source file.

            try {
                if (choice < 1 || choice > 5) {
                    System.out.println("Please choose the numbers given in the options below (1 through 5).");
                } else if (choice == 1) {           //Monthly Budget Calculator
                    double monthlyIncome = 0;
                    double expenses = 0;

                    System.out.println("Monthly Budget Calculator");
                    while (true) {

                        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

                        try {
                            System.out.println("Please enter your monthly income:");
                            monthlyIncome = scanner.nextDouble();
                            if (monthlyIncome < 0) {
                                System.out.println("Please choose a positive number.");
                            }
                            if (monthlyIncome > 0) {
                                String formattedAmount = formatter.format(monthlyIncome);
                                System.out.println("Your monthly income is " + formattedAmount);
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number dollar amount");
                            scanner.nextLine();
                        }
                    }
                    while (true) {
                        try {
                            System.out.println("\nEnter your monthly expenses (total):");
                            expenses = scanner.nextDouble();
                            if (expenses < 0) {
                                System.out.println("Please use a positive number");
                            }
                            System.out.println("Your monthly expenses are " + expenses);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number dollar amount");
                            scanner.nextLine();
                        }
                    }
                    System.out.println("Your monthly budget is " + (monthlyIncome - expenses));
                    if ((monthlyIncome - expenses) < 0) {
                        System.out.println("NOTE: you are currently in a " + Math.abs((monthlyIncome - expenses)) + " deficit. lowering unnecessary expenses " +
                                "(take out food, monthly subscriptions etc.) will help towards a healthy budget! ");
                        break;
                    }
                } else if (choice == 2) {                                                                                         // BMI Calculator
                    int heightFeet = 0;
                    int heightInches = 0;
                    int weight = 0;
                    System.out.println("BMI Calculator");
                    while (true) {
                        try {
                            System.out.println("Please type in your height");
                            System.out.println("How many feet tall are you?:");
                            heightFeet = scanner.nextInt();
                            if (heightFeet > 7) {
                                System.out.println("You are not that tall...\n");
                                continue;
                            } else if (heightFeet < 0) {
                                System.out.println("Please type a positive number\n");
                                continue;
                            }
                            while (true) {
                                try {
                                    System.out.println("Remaining inches?");
                                    heightInches = scanner.nextInt();
                                    if (heightInches > 0 && heightInches < 12) {
                                        break;
                                    } else
                                        System.out.println("Please input a value 0 through 11.\n");
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter an integer.\n");
                                    scanner.nextLine();
                                }
                            }
                            System.out.println("You are " + heightFeet + " feet " + heightInches + " inches tall.");
                            int totalHeight = (heightFeet * 12) + heightInches;

                            while (true) {
                                System.out.println("please type your weight (In Lbs)");
                                weight = scanner.nextInt();
                                if (weight < 0) {
                                    System.out.println("Please type a positive number");
                                } else
                                    break;
                            }
                            System.out.println("Your weight is " + weight);
                            double bmi = (weight * 703) / Math.pow(totalHeight, 2);
                            System.out.printf("\nYour BMI is:  %.2f%n", bmi);
                            if (bmi < 18.5) {
                                System.out.println("You are Underweight");
                            } else if (bmi >= 18.5 && bmi < 24.9) {
                                System.out.println("You are Normal Weight");
                            } else if (bmi >= 25 && bmi < 29.9) {
                                System.out.println("You are Overweight");
                            } else {
                                System.out.println("You are Obese");
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter an integer.\n");
                            scanner.nextLine();
                        }
                    }
                } else if (choice == 3) {                                                                                  //Grades Calculator
                    System.out.println("Grades Calculator\nPlease assign grades to each assessment. ");
                    System.out.println("Weight Distribution: 4 Assignments-40%, 2 Midterm Exams-30%, 1 Final Exam-30%");
                    double assignment1 = 0;
                    double assignment2 = 0;
                    double assignment3 = 0;
                    double assignment4 = 0;
                    double midterm1 = 0;
                    double midterm2 = 0;
                    double finalExam = 0;

                    while (true) {
                        try {
                            System.out.print("Assignment #1: ");
                            assignment1 = scanner.nextDouble();
                            if (assignment1 < 0 || assignment1 > 100) {
                                System.out.println("Please enter an number between 0 and 100.\n");
                            } else
                                break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter an number between 0 and 100.\n");
                            scanner.nextLine();
                        }
                    }
                    while (true) {
                        try {
                            System.out.print("Assignment #2: ");
                            assignment2 = scanner.nextDouble();
                            if (assignment2 < 0 || assignment2 > 100) {
                                System.out.println("Please enter an number between 0 and 100.\n");
                            } else
                                break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter an number between 0 and 100.\n");
                            scanner.nextLine();
                        }
                    }
                    while (true) {
                        try {
                            System.out.print("Midterm Exam #1: ");
                            midterm1 = scanner.nextDouble();
                            if (midterm1 < 0 || midterm1 > 100) {
                                System.out.println("Please enter an number between 0 and 100.\n");
                            } else
                                break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter an number between 0 and 100.\n");
                            scanner.nextLine();
                        }
                    }
                    while (true) {
                        try {
                            System.out.print("Assignment #3: ");
                            assignment3 = scanner.nextDouble();
                            if (assignment3 < 0 || assignment3 > 100) {
                                System.out.println("Please enter an number between 0 and 100.\n");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter an number between 0 and 100.\n");
                            scanner.nextLine();
                        }
                    }
                    while (true) {
                        try {
                            System.out.print("Assignment #4: ");
                            assignment4 = scanner.nextDouble();
                            if (assignment4 < 0 || assignment4 > 100) {
                                System.out.println("Please enter an number between 0 and 100.\n");
                            } else
                                break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter an number between 0 and 100.\n");
                            scanner.nextLine();
                        }
                    }
                    while (true) {
                        try {
                            System.out.print("Midterm #2: ");
                            midterm2 = scanner.nextDouble();
                            if (midterm2 < 0 || midterm2 > 100) {
                                System.out.println("Please enter an number between 0 and 100.\n");
                            } else
                                break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter an number between 0 and 100.\n");
                            scanner.nextLine();
                        }
                    }
                    while (true) {
                        try {
                            System.out.print("Final exam: ");
                            finalExam = scanner.nextDouble();
                            if (finalExam < 0 || finalExam > 100) {
                                System.out.println("Please enter an number between 0 and 100.\n");
                            } else
                                break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter an number between 0 and 100.\n");
                            scanner.nextLine();
                        }
                    }
                    double totalWeightedGrade = (assignment1 * .10) + (assignment2 * .10) + (assignment3 * .10)
                            + (assignment4 * .10) + (midterm1 * .15) + (midterm2 * .15) + (finalExam * .30);
                    System.out.printf("Final Weighted Grade: %.2f%n", totalWeightedGrade);
                } else if (choice == 4) {                                                                                      //Loan Interest Calculator
                    System.out.println("Loan Interest Calculator");
                    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
                    double principal = 0;
                    double interest = 0;
                    int years = 0;

                    while (true) {
                        try {
                            System.out.println("Please type your total loan amount borrowed (Principal amount):");
                            principal = scanner.nextDouble();
                            if (principal < 0) {
                                System.out.println("Please type a positive number\n");
                            } else {
                                System.out.println("Your principal amount is: " + formatter.format(principal));
                                break;
                            }


                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number between 1 and 5.");
                            scanner.nextLine();
                        }
                    }
                    while (true) {
                        try {
                            System.out.println("Type your annual interest rate: ");
                            interest = scanner.nextDouble();

                            if (interest < 0 || interest > 100) {
                                System.out.println("Please give a number between 0 and 100.\n");
                            } else {
                                System.out.println("Your interest rate is : " + interest + "%");
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number between 0 and 100.");
                            scanner.nextLine();
                        }
                    }
                    while (true) {
                        try {
                            System.out.println("Please type how many years you are paying off the loan (30 year max): ");
                            years = scanner.nextInt();
                            if (years < 1 || years > 30) {
                                System.out.println("Please type a term between 1 and 30.");
                            } else {
                                System.out.println("Your term is for " + years + " years.");
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter an integer between 1 and 30.");
                            scanner.nextLine();
                        }
                    }
                    double monthlyInterest = interest / 12 / 100;
                    int numberOfPayments = years * 12;
                    double monthlyPayment = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                            / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
                    double totalPayment = monthlyPayment * numberOfPayments;
                    double totalInterest = totalPayment - principal;

                    System.out.println("Your Monthly Payment: " + formatter.format(monthlyPayment));
                    System.out.println("Total Payment: " + formatter.format(totalPayment));
                    System.out.println("Total Interest Paid: " + formatter.format(totalInterest));
                }

                int analyzerChoice = 0;
                if (choice == 5) {                                                                      //Random Number Analyzer
                    System.out.println("Random Number Analyzer");
                    System.out.println("Here are your given random numbers:");
                    Random random = new Random();
                    int[] randomNumbers = new int[5];
                    for (int i = 0; i < randomNumbers.length; i++) {
                        randomNumbers[i] = random.nextInt(500) + 1;
                    }
                    while (true) {
                        for (int num : randomNumbers) {
                            System.out.println(num);
                        }
                        System.out.println("What would you like to do with these numbers? Type (1) for the Sum, (2) for the Average, (3) to print all Prime Numbers, " +
                                "or (4) for Standard Deviation");
                        try {
                            analyzerChoice = scanner.nextInt();
                            if (analyzerChoice < 1 || analyzerChoice > 4) {
                                System.out.println("Please choose a number associated with each option\n");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number between 1 and 4.");
                            scanner.nextLine();
                        }
                    }
                    if (analyzerChoice == 1) {
                        int sum = 0;
                        for (int numChoice1 : randomNumbers) {
                            sum += numChoice1;
                        }
                        System.out.println("The sum is: " + sum);
                    } else if (analyzerChoice == 2) {
                        double sum = 0;
                        for (double numChoice2 : randomNumbers) {
                            sum += numChoice2;
                        }
                        double average = sum / randomNumbers.length;
                        System.out.println("The average is " + average);
                    } else if (analyzerChoice == 3) {
                        System.out.println("The prime number(s) are:");
                        boolean foundPrime = false;

                        for (int numChoice3 : randomNumbers) {
                            boolean isPrime = true;
                            if (numChoice3 <= 1) {
                                isPrime = false;
                            } else {
                                for (int i = 2; i <= Math.sqrt(numChoice3); i++) {
                                    if (numChoice3 % i == 0) {
                                        isPrime = false;
                                        break;
                                    }
                                }
                            }
                            if (isPrime) {
                                System.out.println(numChoice3);
                                foundPrime = true;
                            }
                        }
                        if (!foundPrime) {
                            System.out.println("NO PRIME NUMBERS WERE FOUND.");
                        }
                    } else {
                        double sum = 0;
                        for (int numChoice4 : randomNumbers) {
                            sum += numChoice4;
                        }
                        double mean = sum / randomNumbers.length;

                        double varianceSum = 0;
                        for (int numChoice4 : randomNumbers) {
                            varianceSum += Math.pow(numChoice4 - mean, 2);
                        }
                        double variance = varianceSum / randomNumbers.length;
                        double standardDev = Math.sqrt(variance);

                        System.out.println("The standard deviation is: " + standardDev);
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine();
            }
            System.out.println("End of Calculations. Please type (1) to go back to the main menu, or (2) to exit the program.");
            int endCalculatorChoice = 0;
            while (true) {
                try {
                    endCalculatorChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (endCalculatorChoice < 1 || endCalculatorChoice > 2) {
                        System.out.println("Please choose between 1 or 2");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter 1 or 2.");
                    scanner.nextLine();
                }
            }
            if (endCalculatorChoice == 2) {
                System.out.println("Exiting program...");
                break;
            }
        }
        scanner.close();
    }
}