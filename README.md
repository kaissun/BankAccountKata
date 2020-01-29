# Bank Account Kata

Think of your personal bank account experience. When in doubt, go for the simplest solution

## Requirements

Deposit and Withdrawal:

- Account statement (date, amount, balance)

- Statement printing

The expected result is a service API, and its underlying implementation, that meets the expressed needs.
Nothing more, especially no UI, no persistence.

## User Stories

##### US 1:
In order to save money
As a bank client
I want to make a deposit in my account

##### US 2:
In order to retrieve some or all of my savings
As a bank client
I want to make a withdrawal from my account

##### US 3:
In order to check my operations
As a bank client
I want to see the history (operation, date, amount, balance) of my operations


## Demonstration 

The program is introduced using java 8. And the project has been built initially with Maven. 

So first, you need to be sure that maven is already installed and fully configured (with java 8 as java home). I used as apache-maven-3.6.2 in this project and jdk1.8.0_171 and JDK.
Second, using command line, execute the following :

`mvn package`

A new folder of maven called target will be generated after this command. To check the tests please follow this folder : surefire-reports, it contains all the results of testing for each junit class created. This result is also shown when executing in the command line previously. You could also execute the following command after executing the previous one: 

`mvn test`

in the same newly created folder, you will find the assembly for our program: BankAccountKata1.0-0.0.1-SNAPSHOT.jar
To run the program, please run the following command. It will be without any parameters

`java -jar BankAccountKata1.0-0.0.1-SNAPSHOT.jar`
