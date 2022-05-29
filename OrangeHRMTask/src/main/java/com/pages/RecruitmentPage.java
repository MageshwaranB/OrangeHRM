package com.pages;

import com.base.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RecruitmentPage extends TestBase
{
    @FindBy(id ="menu_recruitment_viewRecruitmentModule")
    WebElement recruitmenBtn;

    @FindBy(xpath = "//ul[@id='mainMenuFirstLevelUnorderedList']/li[5]/ul")
    List<WebElement> recruitmentOptions;

    @FindBy(id = "btnAdd")
    WebElement addCandidateBtn;

    @FindBy(id = "addCandidate_firstName")
    WebElement firstName;
    @FindBy(id = "addCandidate_lastName")
    WebElement lastName;
    @FindBy(id = "addCandidate_email")
    WebElement email;
    @FindBy(id = "addCandidate_contactNo")
    WebElement contactNo;
    @FindBy(id = "addCandidate_vacancy")
    WebElement jobVacancyList;
    @FindBy(id = "addCandidate_consentToKeepData")
    WebElement consentCheckBox;
    @FindBy(id = "btnSave")
    WebElement saveCandidateBtn;

    @FindBy(className = "status")
    WebElement applicationStatus;

    public RecruitmentPage() {
        PageFactory.initElements(driver,this);
    }

    public void clickOnRecruitmentButton(){
        recruitmenBtn.click();
    }

    public void clickOnRecruitmentOptions(){
        recruitmentOptions.forEach(option-> System.out.println(option.getText()));
        recruitmentOptions.get(0).click();
    }

    public void clickOnAddCandidate(){
        addCandidateBtn.click();
    }

    public void selectTheJobRole(String jobRole){
        Select selectJob=new Select(jobVacancyList);
        selectJob.selectByVisibleText(jobRole);
    }

    Faker fakeData=new Faker();

    public String addingACandidate(String jobRole){
        firstName.sendKeys(fakeData.name().firstName());
        lastName.sendKeys(fakeData.name().lastName());
        email.sendKeys(fakeData.internet().emailAddress());
        contactNo.sendKeys(String.valueOf(fakeData.number().randomNumber(10,true)));
        selectTheJobRole(jobRole);
        consentCheckBox.click();
        saveTheCandidate();
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(applicationStatus));
        return applicationStatus.getText();
    }

    public void saveTheCandidate(){
        saveCandidateBtn.click();
    }
}
