Feature: User Registeration
				i want to ceheck the user can register 
				
		Scenario Outline: user Registeration
		Given the user in homepage
		When i click on register link
		And i "<firstname>" , "<lastname>" , "<email>" , "<password>"
		Then the registeration page displayed succssfully
		
		Examples:
		| firstname | lastname | email | password |
		| ahmed | rofa | rofa5@test.com | 12345678 |
		| ahmed | rofa | rofa6@test.com | 12345678 |
		| ahmed | rofa | rofa7@test.com | 12345678 |