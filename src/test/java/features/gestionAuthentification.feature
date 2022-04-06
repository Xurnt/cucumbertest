@AuthentificationTest
Feature: Vérifier Authentification

Background:

Given je suis sur la page login

Scenario Outline: Test connection

When je saisi username: "<username>" And je saisi password: "<password>" And je clique sur Login
Then "<result>"

Examples:
| username | password | result |
| admin | admina    | Connexion et redirection vers le dashboard |
| admina | admina | Msg Erreur |
| admin | adminaaa | Msg Erreur |