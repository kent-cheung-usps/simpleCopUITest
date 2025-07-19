# simpleCopUITest
My Quick Regression Smoke Test

### Jump Start
```
git clone https://github.com/kent-cheung-usps/simpleCopUITest.git
```
```
git checkout demo
```
```
mvn clean install
```
---
### Playwright Installation Document
```
https://playwright.dev/docs/intro#installing-playwright
```
### Install playwright
```
mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install"
```
### Compile and Execute Recording
```
mvn compile exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen cop-cat.usps.com"
```
### Clone the sample
```
git clone https://github.com/kent-cheung-usps/simpleCopUITest.git
```
### Run test
```
mvn clean install
```
