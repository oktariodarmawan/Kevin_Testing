package Base;

import PageObject.LoginPage;
import PageObject.SecureAreaPage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class csvTest extends BaseTest{

    @Test(dataProvider="Excel")
    public void loginWithCSVData(String uname, String pwd){
        LoginPage loginPage = homePage.clickLoginPage();
        loginPage.setUsername(uname);
        loginPage.setPassword(pwd);
    }

    @DataProvider(name="Excel")
    public Object [][] testDataFromExcel() throws IOException {
        FileInputStream file = new FileInputStream("resources/data_test.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet loginSheet = workbook.getSheet("Sheet1");
        int numberOfData = loginSheet.getPhysicalNumberOfRows();
        Object [][] testData = new Object[numberOfData][2];

        for(int i= 0; i < numberOfData;i++){
            XSSFRow row = loginSheet.getRow(i);
            XSSFCell username = row.getCell(0);
            XSSFCell password = row.getCell(1);
            testData[i][0] = username.getStringCellValue();
            testData[i][1] = password.getStringCellValue();
        }

        return testData;
    }
}
