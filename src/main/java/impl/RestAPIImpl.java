package impl;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.sql.*;
import java.time.Duration;
import java.util.*;
import java.util.List;
import static Driver.TestBase.driver;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestAPIImpl {

    public void yo(){
        POJO pojo = new POJO();
        pojo.setHello("Hero");
        pojo.setHi("I am");
    }

    public void yoyo(){
//        System.out.println(.getAll());
    }

    public void authenticationAPI(){
//        AUTHENTICATE USER
//        String url = "https://xmppserver.egather.live/api";
//        RestAssured.baseURI=url;
//        RequestSpecification request = RestAssured.given();
//        String body = "{\n" +
//                "      \"user\": \"anil\",\n" +
//                "      \"host\": \"xmppserver.egather.live\"\n" +
//                "}";
//        Response response = request
//                .auth()
//                .preemptive()
//                .basic("admin@xmppserver.egather.live", "ebiz1234")
//                .contentType(ContentType.JSON)
//                .body(body)
//                .post("/check_account");
//        System.out.print("The response is "+response.getStatusCode());

//         CREATED USER
        String url = "https://xmppserver.egather.live/api";
        RestAssured.baseURI=url;
        RequestSpecification request = given();
        String body = "{\n" +
                "      \"user\": \"test23390\",\n" +
                "      \"host\": \"xmppserver.egather.live\",\n" +
                "      \"password\": \"ebiz1234\"\n" +
                "}";
        Response response = request
                .auth()
                .preemptive()
                .basic("admin@xmppserver.egather.live", "ebiz1234")
                .contentType(ContentType.JSON)
                .body(body)
                .post("/register");
        System.out.print("The response is "+response.getStatusCode());
//
////        GET DATA
//        String url = "https://xmppserver.egather.live/api";
//        RestAssured.baseURI=url;
//        RequestSpecification request = RestAssured.given();
//        String body = "{\n" +
//                "    \"host\": \"xmppserver.egather.live\"\n" +
//                "}";
//        Response response = request
//                .auth()
//                .preemptive()
//                .basic("admin@xmppserver.egather.live", "ebiz1234")
//                .contentType(ContentType.JSON)
//                .body(body)
//                .post("/registered_users");
//        System.out.print("The response is "+response.getStatusCode());
//        Assert.assertTrue(response.asString().contains("test2333"),"test2333 is not present");
//
////        JSON PATH DATA RECEIVED
//        String url = "https://corona-virus-stats.herokuapp.com/api/v1/cases/general-stats";
//        RestAssured.baseURI=url;
//        RequestSpecification request = RestAssured.given();
//        Response response = request.get();
//        System.out.print("The response is "+response.getStatusCode());
//        System.out.println(response.jsonPath().get("data.total_cases").toString());

    }

    public void registration() {

        String username = "admin";
        String password = "password";

        //language=JSON
        String jsonBody = "{\n" +
                "  \"name\": \"Foo\"\n" +
                "}";

        given().auth().preemptive().basic(username, password)
                .body(jsonBody)
                .contentType(ContentType.JSON)
                .when()
                .post("http://localhost:8080/secured/hello")
                .then()
                .log().all()
                .log().ifError()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("data", equalTo("hello Foo"))
                .body("heuu",hasItems("hyy","juu","fghj"))
                .extract().response().getCookies();






        String userID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
        String userName = "TOOLSQA-Test";
//        String password = "Test@@123";
        String baseUrl = "https://bookstore.toolsqa.com";

        RestAssured.baseURI=baseUrl;
        RequestSpecification request = given();

//        JSONObject requestParams = new JSONObject();
//        requestParams.put("username","password");
//        requestParams.put("password","password");
//
//        request.body(requestParams.toJSONString());
//
//        Response response = request.request(Method.PUT,"/register");
//        response.jsonPath().get("isin");
//        response.getBody().asString().contains("book");
//        response.getStatusCode();
//        response.asString();

//        request.auth().oauth2(token);

        Hello hey = new Hello(1,2,2,4,new Data
                (4,"","","",""), Arrays.asList("", ""));

        HashMap<String,Object> yo = new HashMap<String,Object>();
        yo.put("","");


        //Step - 1
        //Test will start from generating Token for Authorization
        request.header("Content-Type", "application/json");

        Response response = request.body("{ \"userName\":\"" + userName + "\", \"password\":\"" + password + "\"}")
                .post("/Account/v1/GenerateToken");

        Assert.assertEquals(response.getStatusCode(), 200);

        String jsonString = response.asString();
        Assert.assertTrue(jsonString.contains("token"));

        //This token will be used in later requests
        String token = JsonPath.from(jsonString).get("token");

        System.out.println(token);

        //Step - 2
        // Get Books - No Auth is required for this.
        response = request.get("/BookStore/v1/Books");

        Assert.assertEquals(response.getStatusCode(), 200);

        jsonString = response.asString();
        List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
        Assert.assertTrue(books.size() > 0);

        //This bookId will be used in later requests, to add the book with respective isbn
        String bookId = books.get(0).get("isbn");

        System.out.println(bookId);

        //Step - 3
        // Add a book - with Auth
        //The token we had saved in the variable before from response in Step 1,
        //we will be passing in the headers for each of the succeeding request
//        request.header("Authorization", "Bearer " + token)
//                .header("Content-Type", "application/json");

        request.auth().oauth2(token).when().post("/BookStore/v1/Books").then().statusCode(201);

        System.out.println(token);


        response = request.body("{ \"userId\": \"" + userID + "\", " +
                "\"collectionOfIsbns\": [ { \"isbn\": \"" + bookId + "\" } ]}")
                .post("/BookStore/v1/Books");

        System.out.println(response.getStatusCode());

        Assert.assertEquals( 201, response.getStatusCode());
        //Step - 4
        // Delete a book - with Auth
        request.header("accept: ", "application/json")
                .header("Authorization: ", token);

        response = request.body("{ \"isbn\": \"" + bookId + "\", \"userId\": \"" + userID + "\"}")
                .delete("/BookStore/v1/Book");

        Assert.assertEquals(204, response.getStatusCode());


        //Step - 5
        // Get User
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.get("/Account/v1/User/" + userID);
        Assert.assertEquals(200, response.getStatusCode());

        jsonString = response.asString();
        List<Map<String, String>> booksOfUser = JsonPath.from(jsonString).get("books");
        Assert.assertEquals(0, booksOfUser.size());

    }

    public void stringreverese(){
        String string = "Hey my name is Akhil";
        String[] parts = string.split(" ");
        for(int i=parts.length-1;i>=0;i--){
            System.out.print(parts[i]+" ");
        }
    }

    public void selectCheckboxes() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElement(By.id("checkboxes")).findElements(By.tagName("input"));
        if(checkboxes.get(0).isSelected()){}else
        {
            checkboxes.get(0).click();
        }
        Thread.sleep(2000);
    }

    public void addAtStart() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/entry_ad");
        Wait wait = new WebDriverWait(driver,10);
        driver.findElement(By.xpath("//div[@class='modal']")).click();
        String mainwindow = driver.getWindowHandle();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal']")));
        Set<String> windowhandles = driver.getWindowHandles();
        Iterator<String> windowhandle = windowhandles.iterator();
        while(windowhandle.hasNext())
        {
            System.out.print("The no of windows are "+windowhandles.size());
            String ChildWindow=windowhandle.next();
            System.out.print(mainwindow+ "     "+ChildWindow);
            if(!mainwindow.equalsIgnoreCase(ChildWindow))
            {
                // Switching to Child window
                driver.switchTo().window(ChildWindow);
                driver.findElement(By.xpath("//p[contains(.,'Close')]")).click();
                // Closing the Child Window.
                driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(mainwindow);

//        driver.findElement(By.xpath("//p[contains(.,'Close')]")).click(); //Close Ad
        Thread.sleep(10000);
    }

    public void draganddrop() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        WebElement src = driver.findElement(By.id("column-a"));
        WebElement dest = driver.findElement(By.id("column-b"));
        Actions action = new Actions(driver);
        action.dragAndDrop(src,dest).doubleClick().build().perform();

        final String java_script =
                "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
                        "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
                        "ction(format,data){this.items[format]=data;this.types.append(for" +
                        "mat);},getData:function(format){return this.items[format];},clea" +
                        "rData:function(format){}};var emit=function(event,target){var ev" +
                        "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
                        "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
                        "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
                        "'drop',tgt);emit('dragend',src);";
        ((JavascriptExecutor)driver).executeScript(java_script, src, dest);

        Thread.sleep(3000);


    }

    public void alertContextmenu() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        WebElement elt = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver);
        action.contextClick(elt).perform();
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }

    public void digestAuthentication() throws InterruptedException {
        driver.get("http://admin:admin@the-internet.herokuapp.com/digest_auth");
        Thread.sleep(3000);
    }

    public void uploadFile() throws InterruptedException, AWTException {
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys("C://Users//akhbabu//Downloads//AkhilBabu_Passport.pdf");
    driver.findElement(By.id("file-submit")).click();
    Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=’uploadfile_0′]")).click();
        StringSelection ss = new StringSelection("C://Users//Prakash//Desktop//Desktop//TOSCA tutorial.pptx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


        //        AutoItX x = new AutoItX();
//        x.winActivate("Print");
//        x.winWaitActive("Print");
//        x.controlClick("Print", "", "1058");
//        x.ControlSetText("Print", "", "1153", "50");
//        Thread.sleep(3000); //This was added just so you could see that the values did change.
//        x.controlClick("Print", "", "2");
    }


    public void stringrevwithoutfunction() throws AWTException {

//        input
        String str;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your String");
        str = in.nextLine();

//        stringReverseUsingStringBuilder
        String string = "Automation";
        StringBuilder reverseString = new StringBuilder(string);
        reverseString.reverse();
        System.out.print(reverseString);

//        string reverse without uding any string function
        for(int i = string.length()-1;i>=0;i--){
            System.out.print(string.charAt(i));
        }

    }

    public void swap2numbersusing3rdvariable(){
        int a = 10;
        int b= 30;

        a=a+b;
        b=a-b;
        a=a-b;
        System.out.print("Value of a and b is " +a +" and "+b);

        int c =a+b;
        b =c-b;
        a=c-a;
        System.out.print("Value of a and b is " +a +" and "+b);
    }

    public void getSheetData() throws IOException, InvalidFormatException {
        FileInputStream file = new FileInputStream("datasheet");
        Workbook book = WorkbookFactory.create(file);
        Sheet sheet = book.getSheet("sheetname");
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        sheet.getRow(0).getLastCellNum();
        sheet.getRow(0).getCell(1);

//        File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(srcfile,destinationfile);
    }

    public void ArraySort(){
        String[] inputList = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
                "aug", "Sep", "Oct", "nov", "Dec" };
        // Display input un-sorted list.
        System.out.println("-------Input List-------");
        showList(inputList);

        Arrays.sort(inputList);

        System.out.println("-----------sort input list is");
        showList(inputList);

    }

    public void showList(String[]data){
        for(int i=0;i< data.length;i++)
        {
            System.out.print(data[i]+" ");
        }
    }

    public void numberofwordsinstringhashmap(){
        // TODO Auto-generated method stub
        String str = "This this is is done by Akhil Akhil";
        String[] split = str.split(" ");

        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for (int i=0; i<split.length; i++) {
            if (map.containsKey(split[i])) {
                int count = map.get(split[i]);
                map.put(split[i], count+1);
            }
            else {
                map.put(split[i], 1);
            }
        }
        System.out.println(map);

//        removing space from string
        String str1 = "Saket Saurav        is an Autom ation Engi ne      er";
        System.out.print(str1.replaceAll("\\s",""));

        String hey ="helllooooooooo";
        StringBuffer reverse = new StringBuffer(hey);
        System.out.println(reverse.reverse());

        char[] chars = str1.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++)
        {
            if( (chars[i] != ' ') && (chars[i] != '\t') )
            {
                sb.append(chars[i]);
            }
        }
        System.out.println(sb);           //Output : CoreJavajspservletsjdbcstrutshibernatespring
    }

    public void dbrelated() throws ClassNotFoundException, SQLException {
        //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
        String dbUrl = "jdbc:mysql://localhost:3036/emp";

        //Database Username
        String username = "root";

        //Database Password
        String password = "guru99";

        //Query to Execute
        String query = "select *  from employee;";

        //Load mysql jdbc driver
        Class.forName("com.mysql.jdbc.Driver");

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl,username,password);

        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        // While Loop to iterate through all data and print results
        while (rs.next()){
            String myName = rs.getString(1);
            String myAge = rs.getString(2);
            System. out.println(myName+"  "+myAge);
        }
        // closing DB Connection
        con.close();
    }

    public void JSONParsing() throws FileNotFoundException {

        JSONObject jo = new JSONObject();

        // putting data to JSONObject
        jo.put("firstName", "John");
        jo.put("lastName", "Smith");
        jo.put("age", 25);

        // for address data, first create LinkedHashMap
        Map m = new LinkedHashMap(4);
        m.put("streetAddress", "21 2nd Street");
        m.put("city", "New York");
        m.put("state", "NY");
        m.put("postalCode", 10021);

        // putting address to JSONObject
        jo.put("address", m);

        // for phone numbers, first create JSONArray
        JSONArray ja = new JSONArray();

        m = new LinkedHashMap(2);
        m.put("type", "home");
        m.put("number", "212 555-1234");

        // adding map to list
        ja.add(m);

        m = new LinkedHashMap(2);
        m.put("type", "fax");
        m.put("number", "212 555-1234");

        // adding map to list
        ja.add(m);

        // putting phoneNumbers to JSONObject
        jo.put("phoneNumbers", ja);

        // writing JSON to file:"JSONExample.json" in cwd
//        PrintWriter pw = new PrintWriter("JSONExample.json");
//        pw.write(jo.toJSONString());
//
//        pw.flush();
//        pw.close();

        System.out.print(jo.toJSONString());
    }

}