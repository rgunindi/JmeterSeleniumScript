package Odev1.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class KampanyaPage {
    WebDriver driver;
    public static List<String> csvFileContent;
    public KampanyaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        csvFileContent=new ArrayList<>();
    }
    @FindBy(xpath = "//*[@id=\"myLocation-close-info\"]")
    @CacheLookup
    WebElement disablePopup;
    void disablePopUp(){disablePopup.click();}

    String campaignList="#contentCampaignPromotion > div > div.promotionHolder > div > div.tabPanel > div > section.group.category";//-n > ul
    String cssPath=".campPromTab > li:nth-child";//(n)
    String promotionHolderImgPath="//*[@id=\"contentCampaignPromotion\"]/div/div[2]/div/div[2]/div/section";//[n]/a
    String lastPromotionHelper="section.group:nth-child(11) > ul";
    String lastPromotionHolderImgHelper="/html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/section[10]/a";

    public void handle() {
        disablePopUp();
        for (int i = 2,j=11; i <=10; j++,i++) {
            String css=cssPath+"("+(i=((i==10)?++i:i))+")";
            String holderImgPath=j==19?lastPromotionHolderImgHelper:promotionHolderImgPath+"["+i+"]/a";
            String campaignListCss=j==19?lastPromotionHelper:campaignList+"-"+j+" > ul";
            WebElement el=driver.findElement(By.cssSelector(css));
            el.click();
            waits(2);//Wait element loading
            WebElement largeImg=driver.findElement(By.xpath(holderImgPath));
            csvFileContent.add(el.getText()+" "+ largeImg.getAttribute("href"));//Large Image Add List
            PageFactory.initElements(driver, this);
            List<WebElement> allEl=driver.findElement(By.cssSelector(campaignListCss)).findElements(By.tagName("li"));
            allEl.forEach(links->csvFileContent.add(el.getText()+" "+links.findElements(By.tagName("a")).get(0).getAttribute("href")));
        }

    }
    void waits(int time){
        try{Thread.sleep((time* 1000L));}catch (Exception ignored){}
    }
}
