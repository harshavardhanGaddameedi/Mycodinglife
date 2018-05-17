$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Login.feature");
formatter.feature({
  "line": 1,
  "name": "Login into iDempiere Application",
  "description": "",
  "id": "login-into-idempiere-application",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Login to iDempiere Application",
  "description": "",
  "id": "login-into-idempiere-application;login-to-idempiere-application",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I am in login Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "enter the user details \"\u003cuser\u003e\", \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I click Login",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I should be in the home page",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "login-into-idempiere-application;login-to-idempiere-application;",
  "rows": [
    {
      "cells": [
        "user",
        "password"
      ],
      "line": 11,
      "id": "login-into-idempiere-application;login-to-idempiere-application;;1"
    },
    {
      "cells": [
        "ErpAdmin",
        "ErpAdmin"
      ],
      "line": 12,
      "id": "login-into-idempiere-application;login-to-idempiere-application;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 57975331612,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Login to iDempiere Application",
  "description": "",
  "id": "login-into-idempiere-application;login-to-idempiere-application;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I am in login Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "enter the user details \"ErpAdmin\", \"ErpAdmin\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I click Login",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I should be in the home page",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 4342953736,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 15,
  "name": "Login into iDempiere With different Roles",
  "description": "",
  "id": "login-into-idempiere-application;login-into-idempiere-with-different-roles",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 16,
  "name": "I am in login Page",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "enter the user details \"\u003cuser\u003e\", \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "Select Role and click Login",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I Select Role and Org \"\u003crole\u003e\", \"\u003corg\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I click login in Role page",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "I should be in the home page",
  "keyword": "Then "
});
formatter.examples({
  "line": 23,
  "name": "",
  "description": "",
  "id": "login-into-idempiere-application;login-into-idempiere-with-different-roles;",
  "rows": [
    {
      "cells": [
        "user",
        "password",
        "role",
        "org"
      ],
      "line": 24,
      "id": "login-into-idempiere-application;login-into-idempiere-with-different-roles;;1"
    },
    {
      "cells": [
        "ErpAdmin",
        "ErpAdmin",
        "HR Business Partner",
        "ErpPractice"
      ],
      "line": 25,
      "id": "login-into-idempiere-application;login-into-idempiere-with-different-roles;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 81563288489,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "Login into iDempiere With different Roles",
  "description": "",
  "id": "login-into-idempiere-application;login-into-idempiere-with-different-roles;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 16,
  "name": "I am in login Page",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "enter the user details \"ErpAdmin\", \"ErpAdmin\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "Select Role and click Login",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I Select Role and Org \"HR Business Partner\", \"ErpPractice\"",
  "matchedColumns": [
    2,
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I click login in Role page",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "I should be in the home page",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.embedding("image/png", "embedded1.png");
formatter.after({
  "duration": 3866149526,
  "status": "passed"
});
});