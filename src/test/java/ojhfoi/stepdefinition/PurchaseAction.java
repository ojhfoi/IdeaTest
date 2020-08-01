package ojhfoi.stepdefinition;

import io.cucumber.java.en.And;

import static com.codeborne.selenide.Selenide.$;
import static ojhfoi.tsum.pageObject.PurchasePage.*;

/**
 * Action for purchase page
 */
public class PurchaseAction {

    /**
     * Insert buyer data for accept or decline purchase order
     * @param name - buyer name
     * @param surName - buyer surname
     * @param phone - buyer phone
     * @param email - buyer email
     */
    @And("insert buyer name {word}, surname {word}, phone {string}, email {string}")
    public void InsertPurchaseData(String name, String surName, String phone, String email) throws Exception{
        $(buyerName).sendKeys(name);
        $(buyerSurName).sendKeys(surName);
        $(buyerPhone).sendKeys(phone);
        $(buyerEmail).sendKeys(email);
    }

}
