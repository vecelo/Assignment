# Assignment
 
## 1. Overview
This is my assignment for Automation Challenge.
I just use Maven + TestNG + Extend Report + Selenium Webdrive and Java programming to build and basic framework.

## 2. Goals
* Provide the ONE XPath to return the requests which are submitted and approved in 2019 (Request Status = Approved && Date Submitted = 2019)

**//td[@class='td-request-approved uppercase']/following-sibling::td/div[contains(text(),'2019')]/ancestor::tr**

* Write the automation script to verify for Verify filter Student Access Request with INACTIVE
* Write the automation script to verify for Verify sorting of First Name column 
* Write the automation script to verify for API - GET https://my-json-server.typicode.com/typicode/demo/posts/1 (using POSTMAN instead)


## 2. Prerequisite

Software name|Version|Note
:--- | --- | ---
IntelliJ IDEA ||||
Java JDK ||||
Maven | | |
Git (cmd console) ||||
Notepad++ ||||
| | | |

## 3. Setup variable enviroment for MAVEN, JAVA JDK

## 4. Manual Testcases
Karros_Testcase.xlsx

## 5. Import Project from Version Control with Github link
<https://github.com/hungmt/Assignment.git>

## 6. Additional resources   
If you are using Chrome version 83, download ChromeDriver here and stored in <Your folder>\Assignment\src\main\resources\

    <https://chromedriver.storage.googleapis.com/83.0.4103.39/chromedriver_win32.zip>

## 7. Report and screenshot
The Test Report and Screenshot is stored in <Your folder>\Assignment\reports
 
## 8. API Testing by Postman
- Verify the status response is 200 (successful)
- Verify the Header/Content-Type is present
- Verify the JSON response "id" = 1 and "title" = Post 1
}

```javascript
const responseJson = pm.response.json();

    pm.test("Status code is 200", function () {
        pm.response.to.have.status(200);
    });

    pm.test("Verify the Content-Type is present", function(){
        pm.response.to.have.header("Content-Type");
    });

    pm.test("Verify value of id", function () {
        pm.expect(responseJson.id).to.eql(1);
        pm.expect(responseJson.title).to.eql("Post 1");
    });

    pm.test("Verify value of title", function () {
        pm.expect(responseJson.title).to.eql("Post 1");
    });
```
