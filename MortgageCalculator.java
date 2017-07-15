import java.awt.*;

import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.BevelBorder;


public class MortgageCalculator extends JFrame

{
		
	private JLabel homeValueJLabel, loanAmountJLabel, termJLabel, insuranceJLabel, propertyTaxJLabel,
	interestRateJLabel, monthlyPaymentJLabel,creditsJLabel,titleJLabel;
	private JButton CalculateJButton, ClearJButton, backJButton;
	private JTextField homeValueJTextField, loanAmountJTextField, termJTextField, insuranceJTextField,
	propertyTaxJTextField, interestRateJTextField, monthlyPaymentJTextField;
	//declare a scroll pane
	private JScrollPane sideJScrollPane;
	
	//declare a test are
	private JTextArea areaJTextArea;
	
	 private Container contentPane;
	
	 private int onlyPrintOnceB4Clear = 0;
	 
	 
	 
	
	 private double interest;
	 private double principal;
	 
	private double erazor;
	
	private double homeValue = 0;
	 
	 
	 
	public MortgageCalculator()
	
	{
		
		createUserInterface();
		
	}
		
	
	private void createUserInterface()
	
	{
		
		contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.GRAY);
		
		//Label
		setUpLabels();
		setUpTextFields();
		
	
		
		//Button
		CalculateJButton = new JButton();
		CalculateJButton.setText("Calculate");
		CalculateJButton.setFont(new Font ("Times New Roman",Font.BOLD,30));
		CalculateJButton.setForeground(Color.GRAY);
		CalculateJButton.setBounds(350,475,250,88);
		contentPane.add(CalculateJButton);
		
		CalculateJButton.addActionListener(
				
				new ActionListener() //object //new is constructor
				
				{
					
					public void actionPerformed(ActionEvent event) 
					
					{
						
						//try and catch
						
						
						
						
						try
						
						{
							
							
						
							
							erazor = 1;
							
							
							
							
							
							homeValue = 
							Integer.parseInt(homeValueJTextField.getText()); //turns a string into a int
									
							double loanAmount = 
							Integer.parseInt(loanAmountJTextField.getText());
							

							int term =
							Integer.parseInt(termJTextField.getText());
									
							int insuranceRate =
							Integer.parseInt(insuranceJTextField.getText());
									
							int propertyTax =
							Integer.parseInt(propertyTaxJTextField.getText());
									
							double interestRate =
							Double.parseDouble(interestRateJTextField.getText());
									
							// int M = P(i(1+i)^n)/((1+i)^n-1) 
					
							//(1+i)^n) is the exponent variable
						    double i = interestRate/1200;
						    double n = term * 12;
						    double exponent = Math.pow(1+i,n); 
									 
							//i*(1+i)^n) is the numerator
							double numerator = i * exponent;
									 
							//((1+i)^n-1) is the denominator
							double denominator = exponent-1;
									 
							//P is the loan amount
							double P = loanAmount;
									 
							//Now find M
							double monthlyPayment = P* numerator / denominator;
							
							double totalPayment = monthlyPayment * n;
							
							double totalInterest = totalPayment-loanAmount;
							
							double currentTotalInterest = interest;
							
							double loanBalance = loanAmount;
							
							double newLoanAmount = loanAmount;
							
							double newLoanBalance = loanBalance;
									 
									 
							System.out.println(monthlyPayment);
									 
							DecimalFormat dollars = new DecimalFormat("$0.00");
							
							
							//AMORTIZATIONS CACULATATION
							
							
							
							
							
							
									 
							
                          if(homeValue < 0 || loanAmount < 0 || term < 0 || insuranceRate <0 || propertyTax <0 || interestRate <0)
								
							{
								
								System.out.println("ERROR");
								
								JOptionPane.showMessageDialog(null,
										"Please check the highlighted text boxes for negative numbers",
										"ERROR (No Negative Numbers)",
										JOptionPane.ERROR_MESSAGE);
								onlyPrintOnceB4Clear =0;
								
							
								if(homeValue < 0)
								
								{
									
									emergencyClear();
									homeValueJTextField.setBackground(Color.ORANGE);
									
								}
								
								if(loanAmount < 0)
									
								{
									
									emergencyClear();
									loanAmountJTextField.setBackground(Color.ORANGE);
									
								}
								
								if(term < 0)
									
								{
									
									emergencyClear();
									termJTextField.setBackground(Color.ORANGE);
									
								}
								
								if(insuranceRate < 0)
									
								{
									
									emergencyClear();
									insuranceJTextField.setBackground(Color.ORANGE);
									
								}
								
								if(propertyTax < 0)
									
								{
									
									emergencyClear();
									propertyTaxJTextField.setBackground(Color.ORANGE);
									
								}
								
								if(interestRate < 0)
									
								{
									
									emergencyClear();
									interestRateJTextField.setBackground(Color.ORANGE);
									
								}
								
								
								
								//ORANGE GOES WITH MY COLOR SCHEME AND IT IS A WORNING COLOR
								
								
									
							//String.valueOF(M); - this turn a number into a string:MID TERM QUESTION
							
						}
                          
                          else
                        	  
                          {
                         
                        	  if (homeValue <= loanAmount)
									
								{
									
									System.out.println("ERROR");
									
									JOptionPane.showMessageDialog(null,
											"                                                                                                    Sorry, but there seems to be an error \n "
											+ "Please check the highlighted Home Value box to make sure that the Home Value is more than the Loan Amount or that the loan Amount is less than or equal to the Home Value",
											"ERROR (Home Value less than Home Amount or Loan Amount greater than Home Value)",
											JOptionPane.ERROR_MESSAGE);
									onlyPrintOnceB4Clear =0;
									homeValueJTextField.setBackground(Color.ORANGE);
									loanAmountJTextField.setBackground(Color.ORANGE);
									
									areaJTextArea.setText("\t                               Mortgage Summary");							
																		
								}
                          
                        	  else
                        		  
                        	  {
                        		  
                        	  
							
                        		  if (term >1200)
  									
  								{
  									
  									System.out.println("ERROR");
  									
  									JOptionPane.showMessageDialog(null,
  											"                                                                                                    Sorry, but there seems to be an error \n "
  											+ "You can't possibly be alive that long",
  											"ERROR (Term to long)",
  											JOptionPane.ERROR_MESSAGE);
  									onlyPrintOnceB4Clear =0;
  									homeValueJTextField.setBackground(Color.ORANGE);
  									loanAmountJTextField.setBackground(Color.ORANGE);
  									
  									areaJTextArea.setText("\t                               Mortgage Summary");							
  																		
  								}
                        		  
                        		  else
                        			  
                        		  {
                          
                        	  
                        	 
							if(onlyPrintOnceB4Clear == 0)
								
							{
								
								
								
								onlyPrintOnceB4Clear = 1;
								
								
							}
								
								
							if(onlyPrintOnceB4Clear == 1 )
								
							{
							
							if(homeValue > loanAmount)
								
							{
								
							if(homeValue > 0 && loanAmount > 0 && term > 0 && insuranceRate > 0 && propertyTax > 0 && interestRate > 0)
								
							{
							 	
							 	
								
							
							
							//OKAY THIS STARTS AMORTIZATION PRINTING
							
							areaJTextArea.append("\n\n\nMonth" );// <--- Kind of important
							areaJTextArea.setForeground(Color.darkGray);
							areaJTextArea.setFont(new Font("Times New Roman",Font.BOLD,20));
							
							
							areaJTextArea.append("     Total Payment");// <--- Kind of important
							areaJTextArea.setForeground(Color.darkGray);
							areaJTextArea.setFont(new Font("Times New Roman",Font.BOLD,20));
							
							
							areaJTextArea.append("    Principal");// <--- Kind of important
							areaJTextArea.setForeground(Color.darkGray);
							areaJTextArea.setFont(new Font("Times New Roman",Font.BOLD,20));
							
							
							areaJTextArea.append("      Interest");// <--- Kind of important
							areaJTextArea.setForeground(Color.darkGray);
							areaJTextArea.setFont(new Font("Times New Roman",Font.BOLD,20));
							
							areaJTextArea.append("      Total Interest");// <--- Kind of important
							areaJTextArea.setForeground(Color.darkGray);
							areaJTextArea.setFont(new Font("Times New Roman",Font.BOLD,20));
							
							areaJTextArea.append("      Loan Balance");// <--- Kind of important
							areaJTextArea.setForeground(Color.darkGray);
							areaJTextArea.setFont(new Font("Times New Roman",Font.BOLD,20));	
							
							
							
							
							for(int month = 1;  month < term * 12 +1 ; month++)
								
							{
								

								System.out.println(newLoanAmount);
								
								interest = newLoanAmount *interestRate/1200;
								
								principal = monthlyPayment - interest;
								
								newLoanAmount = newLoanAmount - principal;
							
								currentTotalInterest = currentTotalInterest + interest;
								
								newLoanBalance = newLoanBalance - principal;
								
								
								
							areaJTextArea.append( "\n\n    " + String.valueOf(month) + ":");// <--- Kind of important
							areaJTextArea.setForeground(Color.darkGray);
							areaJTextArea.setFont(new Font("Times New Roman",Font.BOLD,20));	
							
							areaJTextArea.append( "            " + dollars.format(monthlyPayment));// <--- Kind of important
							areaJTextArea.setForeground(Color.darkGray);
							areaJTextArea.setFont(new Font("Times New Roman",Font.BOLD,20));
							
							areaJTextArea.append( "               " + dollars.format(principal));// <--- Kind of important
							areaJTextArea.setForeground(Color.darkGray);
							areaJTextArea.setFont(new Font("Times New Roman",Font.BOLD,20));
							
							areaJTextArea.append( "            " + dollars.format(interest));// <--- Kind of important
							areaJTextArea.setForeground(Color.darkGray);
							areaJTextArea.setFont(new Font("Times New Roman",Font.BOLD,20));
							
							areaJTextArea.append( "              " + dollars.format(currentTotalInterest));// <--- Kind of important
							areaJTextArea.setForeground(Color.darkGray);
							areaJTextArea.setFont(new Font("Times New Roman",Font.BOLD,20));
							
							areaJTextArea.append( "                   " + dollars.format(newLoanBalance));// <--- Kind of important
							areaJTextArea.setForeground(Color.darkGray);
							areaJTextArea.setFont(new Font("Times New Roman",Font.BOLD,20));
							
						
							}
							
							homeValueJTextField.setBackground(Color.white);
							loanAmountJTextField.setBackground(Color.white);
							termJTextField.setBackground(Color.white);
							insuranceJTextField.setBackground(Color.white);
							propertyTaxJTextField.setBackground(Color.white);
							interestRateJTextField.setBackground(Color.white);
							
							monthlyPaymentJTextField.setText(dollars.format(monthlyPayment));
								
							

							//areaJTextArea.append(dollars.format(homeValue));
							
							areaJTextArea.append("\n\n\n\n\tLoan Amount:");// <--- Kind of important
							areaJTextArea.append("\t\t");
							areaJTextArea.append(dollars.format(loanAmount));
							
							areaJTextArea.append("\n\n\tTerm:");// <--- Kind of important
							areaJTextArea.append("\t\t");
							areaJTextArea.append(String.valueOf(term + " years"));
							
							areaJTextArea.append("\n\n\tInsurance:");// <--- Kind of important
							areaJTextArea.append("\t\t");
							areaJTextArea.append(dollars.format(insuranceRate));
							
							areaJTextArea.append("\n\n\tProperty Tax:");// <--- Kind of important
							areaJTextArea.append("\t\t");
							areaJTextArea.append(dollars.format(propertyTax));
							
							areaJTextArea.append("\n\n\tInterest Rate:");// <--- Kind of important
							areaJTextArea.append("\t\t");
							areaJTextArea.append(String.valueOf(interestRate + " %"));
							
							areaJTextArea.append("\n\n\tMonthly Payment:");// <--- Kind of important
							areaJTextArea.append("\t");
							areaJTextArea.append(dollars.format(monthlyPayment));
							
							areaJTextArea.append("\n\n\tTotal Payment:");// <--- Kind of important
							areaJTextArea.append("\t\t");
							areaJTextArea.append(dollars.format(totalPayment));
							
							areaJTextArea.append("\n\n\tTotal Interest:");// <--- Kind of important
							areaJTextArea.setForeground(Color.darkGray);
							areaJTextArea.setFont(new Font("Times New Roman",Font.BOLD,20));
							areaJTextArea.append("\t\t");
							areaJTextArea.append(dollars.format(totalInterest) + "\n\n");
							
							
								// fancy visibility aND BOUNDS stuff
						
							
							
							
							
								
								
							}
							
							
							//CALCUMALATIONS
							
							
						
							}
							
						
							
							}
							
							
							backJButton.setVisible(true);
							CalculateJButton.setVisible(false);
							ClearJButton.setVisible(false);
							homeValueJLabel.setVisible(false);
							loanAmountJLabel.setVisible(false);
							termJLabel.setVisible(false);
							insuranceJLabel.setVisible(false);
							propertyTaxJLabel.setVisible(false);
							interestRateJLabel.setVisible(false);
							monthlyPaymentJLabel.setVisible(false);
							creditsJLabel.setVisible(false);
							titleJLabel.setVisible(false);
							CalculateJButton.setVisible(false);
							homeValueJTextField.setVisible(false);
							loanAmountJTextField.setVisible(false);
							termJTextField.setVisible(false);
							insuranceJTextField.setVisible(false);
							propertyTaxJTextField.setVisible(false);
							interestRateJTextField.setVisible(false);
							monthlyPaymentJTextField.setVisible(false);
							
							
							
							sideJScrollPane.setBounds(400,10,1000,830);
							
							
							
							
							System.out.println(onlyPrintOnceB4Clear);
							
							
				
							
							
                          }
                        	  
                        	  
							
						
								
								}
                        	  
                          }
                          
						}
                          
						
						
						
							
						
						
					
				
							
							
						
						
						
						catch(Exception ex)
						
						{
							
							System.out.println("ERROR");
							
							
							JOptionPane.showMessageDialog(null,
									"Error Please Fill in all text boxes with NUMBERS",
									"ERROR",
									JOptionPane.ERROR_MESSAGE);
							
							onlyPrintOnceB4Clear =0	;
						}
							
				}
					
				}
					
				);
		
		
		
		backJButton = new JButton();
		backJButton.setText("Back");
		backJButton.setFont(new Font ("Times New Roman",Font.BOLD,30));
		backJButton.setForeground(Color.GRAY);
		backJButton.setBounds(50,475,300,88);
		backJButton.setVisible(false);
		contentPane.add(backJButton);
		
		backJButton.addActionListener(
				
				new ActionListener()
				
				{
					
					public void actionPerformed(ActionEvent event)
					
					{
						
						backJButton.setVisible(false);
						CalculateJButton.setVisible(true);
						ClearJButton.setVisible(true);
						homeValueJLabel.setVisible(true);
						loanAmountJLabel.setVisible(true);
						termJLabel.setVisible(true);
						insuranceJLabel.setVisible(true);
						propertyTaxJLabel.setVisible(true);
						interestRateJLabel.setVisible(true);
						monthlyPaymentJLabel.setVisible(true);
						creditsJLabel.setVisible(true);
						titleJLabel.setVisible(true);
						CalculateJButton.setVisible(true);
						homeValueJTextField.setVisible(true);
						loanAmountJTextField.setVisible(true);
						termJTextField.setVisible(true);
						insuranceJTextField.setVisible(true);
						propertyTaxJTextField.setVisible(true);
						interestRateJTextField.setVisible(true);
						monthlyPaymentJTextField.setVisible(true);
						
						onlyPrintOnceB4Clear = 2;//LITTLE THINGY
						
						System.out.print(onlyPrintOnceB4Clear);
						
						
						
						sideJScrollPane.setBounds(650,10,750,830);
							
					}
					
				}
				
				
				);
		
		
		ClearJButton = new JButton();
		ClearJButton.setText("Clear");
		ClearJButton.setFont(new Font ("Times New Roman",Font.BOLD,30));
		ClearJButton.setForeground(Color.GRAY);
		ClearJButton.setBounds(50,475,250,88);
		contentPane.add(ClearJButton);
		
		ClearJButton.addActionListener(
				
				new ActionListener()
				
				{
					
					public void actionPerformed(ActionEvent event)
					
					{
						
						homeValueJTextField.setText("");
						loanAmountJTextField.setText("");
						termJTextField.setText("");
						insuranceJTextField.setText("");
						propertyTaxJTextField.setText("");
						interestRateJTextField.setText("");
						monthlyPaymentJTextField.setText("");
						areaJTextArea.setText("\t                               Mortgage Summary");							
						onlyPrintOnceB4Clear = 0;
							
					}
					
				}
				
				
				);
		
				
				
		
		//text fields
		
		
		
		//Border
		BevelBorder b = new
		BevelBorder(BevelBorder.LOWERED);
		monthlyPaymentJTextField.setBorder(b);
		monthlyPaymentJTextField.setEditable(false);
		contentPane.add(monthlyPaymentJTextField);
		
		//set up text area and scroll pane
		
		areaJTextArea = new JTextArea();
		areaJTextArea.append("\t                               Mortgage Summary");		
		areaJTextArea.setFont(new Font ("Times New Roman",Font.BOLD,20));
		sideJScrollPane = new JScrollPane(areaJTextArea);
		sideJScrollPane.setBounds(630,10,780,830);
		areaJTextArea.setEditable(false);
		contentPane.add(sideJScrollPane);
				
		this.setTitle("MortgageCalculator");
		this.setVisible(true);
		this.setSize(1440,1000);
		this.setResizable(true);
		
	}
	
	private void emergencyClear()
	
	{
		
		System.out.println("ERROR");
		
		
		areaJTextArea.setText("\t                               Mortgage Summary");							
		
	}
	
	private void setUpLabels()
	
	{
		
		homeValueJLabel = new JLabel();
		homeValueJLabel.setText("Home Value:");
		homeValueJLabel.setFont(new Font ("Times New Roman",Font.BOLD,30));
		homeValueJLabel.setForeground(Color.WHITE);
		homeValueJLabel.setBounds(50,0,550,88);
		contentPane.add(homeValueJLabel);
		
		loanAmountJLabel = new JLabel();
		loanAmountJLabel.setText("Loan Amount:");
		loanAmountJLabel.setFont(new Font ("Times New Roman",Font.BOLD,30));
		loanAmountJLabel.setForeground(Color.WHITE);
		loanAmountJLabel.setBounds(50,75,550,88);
		contentPane.add(loanAmountJLabel);
		
		termJLabel = new JLabel();
		termJLabel.setText("Term (years):");
		termJLabel.setFont(new Font ("Times New Roman",Font.BOLD,30));
		termJLabel.setForeground(Color.WHITE);
		termJLabel.setBounds(50,150,550,88);
		contentPane.add(termJLabel);
		
		insuranceJLabel = new JLabel();
		insuranceJLabel.setText("Insurance (yearly):");
		insuranceJLabel.setFont(new Font ("Times New Roman",Font.BOLD,30));
		insuranceJLabel.setForeground(Color.WHITE);
		insuranceJLabel.setBounds(50,225,550,88);
		contentPane.add(insuranceJLabel);
		
		propertyTaxJLabel = new JLabel();
		propertyTaxJLabel.setText("Property Tax (yearly):");
		propertyTaxJLabel.setFont(new Font ("Times New Roman",Font.BOLD,30));
		propertyTaxJLabel.setForeground(Color.WHITE);
		propertyTaxJLabel.setBounds(50,300,550,88);
		contentPane.add(propertyTaxJLabel);
		
		interestRateJLabel = new JLabel();
		interestRateJLabel.setText("Interest Rate:");
		interestRateJLabel.setFont(new Font ("Times New Roman",Font.BOLD,30));
		interestRateJLabel.setForeground(Color.WHITE);
		interestRateJLabel.setBounds(50,375,550,88);
		contentPane.add(interestRateJLabel);
		
		monthlyPaymentJLabel = new JLabel();
		monthlyPaymentJLabel.setText("Monthly Payment:");
		monthlyPaymentJLabel.setFont(new Font ("Times New Roman",Font.BOLD,30));
		monthlyPaymentJLabel.setForeground(Color.WHITE);
		monthlyPaymentJLabel.setBounds(50,575,550,88);
		contentPane.add(monthlyPaymentJLabel);
		
		creditsJLabel = new JLabel();
		creditsJLabel.setText("By: Emmett Duffy");
		creditsJLabel.setFont(new Font ("Times New Roman",Font.BOLD,30));
		creditsJLabel.setForeground(Color.BLACK);
		creditsJLabel.setBounds(260,750,550,88);
		contentPane.add(creditsJLabel);
		
		titleJLabel = new JLabel();
		titleJLabel.setText("Mortgage Caculator");
		titleJLabel.setFont(new Font ("Times New Roman",Font.BOLD,50));
		titleJLabel.setForeground(Color.BLACK);
		titleJLabel.setBounds(125,690,550,88);
		contentPane.add(titleJLabel);
		
	}
	
	private void setUpTextFields()
	
	{
		
		homeValueJTextField = new JTextField();
		homeValueJTextField.setFont(new Font ("Times New Roman",Font.BOLD,30));
		homeValueJTextField.setForeground(Color.GRAY);
		homeValueJTextField.setHorizontalAlignment(JTextField.CENTER);
		homeValueJTextField.setBounds(350,10,250,50);
		contentPane.add(homeValueJTextField);
		
		homeValueJTextField.addKeyListener(
				
				new KeyAdapter()
				
				{
					
					
					public void keyPressed(KeyEvent event)
					
					{
						
					
	
						if(erazor == 1)
							
						{
							
							areaJTextArea.setText("\t                               Mortgage Summary");							
							onlyPrintOnceB4Clear = 0;
							
						}
							
							
						
					}
					
				}
				
				);
		
		loanAmountJTextField = new JTextField();
		loanAmountJTextField.setFont(new Font ("Times New Roman",Font.BOLD,30));
		loanAmountJTextField.setForeground(Color.GRAY);
		loanAmountJTextField.setHorizontalAlignment(JTextField.CENTER);
		loanAmountJTextField.setBounds(350,90,250,50);
		contentPane.add(loanAmountJTextField);
		
		loanAmountJTextField.addKeyListener(
				
				new KeyAdapter()
				
				{
					
					
					public void keyPressed(KeyEvent event)
					
					{
	
						if(erazor == 1)
							
						{
							
							areaJTextArea.setText("\t                               Mortgage Summary");							
							onlyPrintOnceB4Clear = 0;
							
						}
							
							
						
					}
					
				}
				
				);
		
		termJTextField = new JTextField();
		termJTextField.setFont(new Font ("Times New Roman",Font.BOLD,30));
		termJTextField.setForeground(Color.GRAY);
		termJTextField.setHorizontalAlignment(JTextField.CENTER);
		termJTextField.setBounds(350,165,250,50);
		contentPane.add(termJTextField);
		
		termJTextField.addKeyListener(
				
				new KeyAdapter()
				
				{
					
					
					public void keyPressed(KeyEvent event)
					
					{
	
						if(erazor == 1)
							
						{
							
							areaJTextArea.setText("\t                               Mortgage Summary");							
							onlyPrintOnceB4Clear = 0;
							
						}
							
							
						
					}
					
				}
				
				);
		
		insuranceJTextField = new JTextField();
		insuranceJTextField.setFont(new Font ("Times New Roman",Font.BOLD,30));
		insuranceJTextField.setForeground(Color.GRAY);
		insuranceJTextField.setHorizontalAlignment(JTextField.CENTER);
		insuranceJTextField.setBounds(350,245,250,50);
		contentPane.add(insuranceJTextField);
		
		insuranceJTextField.addKeyListener(
				
				new KeyAdapter()
				
				{
					
					
					public void keyPressed(KeyEvent event)
					
					{
	
						if(erazor == 1)
							
						{
							
							areaJTextArea.setText("\t                               Mortgage Summary");							
							onlyPrintOnceB4Clear = 0;
							
						}
							
							
						
					}
					
				}
				
				);
		
		propertyTaxJTextField = new JTextField();
		propertyTaxJTextField.setFont(new Font ("Times New Roman",Font.BOLD,30));
		propertyTaxJTextField.setForeground(Color.GRAY);
		propertyTaxJTextField.setHorizontalAlignment(JTextField.CENTER);
		propertyTaxJTextField.setBounds(350,320,250,50);
		contentPane.add(propertyTaxJTextField);
		
		propertyTaxJTextField.addKeyListener(
				
				new KeyAdapter()
				
				{
					
					
					public void keyPressed(KeyEvent event)
					
					{
	
						if(erazor == 1)
							
						{
							
							areaJTextArea.setText("\t                               Mortgage Summary");							
							onlyPrintOnceB4Clear = 0;
							
						}
							
							
						
					}
					
				}
				
				);
		
		interestRateJTextField = new JTextField();
		interestRateJTextField.setFont(new Font ("Times New Roman",Font.BOLD,30));
		interestRateJTextField.setForeground(Color.GRAY);
		interestRateJTextField.setHorizontalAlignment(JTextField.CENTER);
		interestRateJTextField.setBounds(350,395,250,50);
		contentPane.add(interestRateJTextField);
		
		interestRateJTextField.addKeyListener(
				
				new KeyAdapter()
				
				{
					
					
					public void keyPressed(KeyEvent event)
					
					{
	
						if(erazor == 1)
							
						{
							
							areaJTextArea.setText("\t                               Mortgage Summary");							
							
							onlyPrintOnceB4Clear = 0;
							
						}
							
							
						
					}
					
				}
				
				);
		
		monthlyPaymentJTextField = new JTextField();
		monthlyPaymentJTextField.setFont(new Font ("Times New Roman",Font.BOLD,30));
		monthlyPaymentJTextField.setForeground(Color.GRAY);
		monthlyPaymentJTextField.setHorizontalAlignment(JTextField.CENTER);
		monthlyPaymentJTextField.setBounds(350,600,250,50);
		
	}
	
	
	
	public static void main(String[] args) 
	
	{
		
		MortgageCalculator app = new MortgageCalculator();
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}

