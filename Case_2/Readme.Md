## Case 2 Jmeter

```diff
- In our project, the chromedriver.exe file path and the Product.csv file path are dynamically retrieved with the BaseDir() method. 
- Therefore, chromedriver.exe and Products.csv files should be in the same folder as the productScript.jmx file.
```
Path code that takes dynamic file path:
```
${__BeanShell(import org.apache.jmeter.services.FileServer; FileServer.getFileServer().getBaseDir())}
```

---
> **NOTE**

There is one thing to consider when running tests:
When trying to make a large number of incorrect payment transactions from the same IP address as a guest user, the test process of the payment steps will not be completed since n11 automatically activates the <ins>Captcha system for security reasons.</ins> 

---

<b>Version Information</b>

The driver used in the project and included in Case2: <i>97.0.4692.71 chromedriver</i> version.
