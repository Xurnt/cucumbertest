Feature: Cr�ation Job order

Scenario Outline: Saisie Informations obligatoires

Given je suis connect� And je suis sur la page d'ajout de Job Order 

When je saisi Title: <title> And je saisi Company: <company> And je saisi City: <city> And je saisi State: <state> And je s�lectionne Recruiter: <recruiter> And je s�lectionne Owner: <owner> And je s�lectionne Type: <type> And je saisi Openings: <openings> And je clique sur Login

Then <Result>

Examples:
| title | company | city | state | recruiter | owner | type | openings | result |
| "" | ajc | Paris | France | Administrator, FaimeRecruiter | Administrator, FaimeRecruiter | C (Contract) | 1 | Msg Erreur |
| Testeur | "" | Paris | France | Administrator, FaimeRecruiter | Administrator, FaimeRecruiter | C (Contract) | 1 | Msg Erreur |
| Testeur | ajc | "" | France | Administrator, FaimeRecruiter | Administrator, FaimeRecruiter | C (Contract) | 1 |Msg Erreur |
| Testeur | ajc | Paris | "" | Administrator, FaimeRecruiter | Administrator, FaimeRecruiter | C (Contract) | 1 | Msg Erreur |
| Testeur | ajc | Paris | France | (Select a user) | Administrator, FaimeRecruiter | C (Contract) | 1 | Msg Erreur |
| Testeur | ajc | Paris | France | Administrator, FaimeRecruiter | (Select a user) |C (Contract) | 1 | Msg Erreur |
| Testeur | ajc | Paris | France | Administrator, FaimeRecruiter | Administrator, FaimeRecruiter | (Select a type) | 1 | Msg Erreur |
| Testeur | ajc | Paris | France | Administrator, FaimeRecruiter | Administrator, FaimeRecruiter | C (Contract) | "" | Msg Erreur |
| Testeur | ajc | Paris | France | Administrator, FaimeRecruiter | Administrator, FaimeRecruiter | C (Contract) | 1 | Ajout d'un utilisateur et redirection vers les d�tails |
