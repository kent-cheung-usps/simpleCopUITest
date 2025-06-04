# simpleCopUITest
My Quick Regression Smoke Test


### Install playwright document
```
https://playwright.dev/docs/intro#installing-playwright
```
### Install playwright
```
mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install"
```
### Compile and Execute Recoring
```
mvn compile exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen cop-cat.usps.com"
```
