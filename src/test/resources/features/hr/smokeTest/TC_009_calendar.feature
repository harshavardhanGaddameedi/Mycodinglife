#Author: Aditi Seth
#Created date:30-05-2018
#Last Updated date:30-05-2018

Feature: Calendar bookings and Interviews
Scenario: to book and approve the calendar bookings

Given the Panel Members have been selected for the Inetrview of applicants 
When the Interviewer logs in and books the interviwer slots
And the Manager Pre Assigns those slots 
Then the Applicants also log in
And book their time
And the Manager would confirm the finalised slots for the interview 
When the User Selects Ranking Interview from the Menu to mark the rank
Then the Ranking interview page opens up 
And in the applicant tab the user changes the outcome of the onterview for that applicant as "Successful"
And hits Save 
And goes to RR page and changes the status to "72_UnderOffer"
Then a message would be displayed "Onboarding RR hs been created and sent ot HR admin for approval"
And click OK on the pop up 
  
 