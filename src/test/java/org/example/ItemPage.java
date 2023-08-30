package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Страница нашего объявления
 */

public class ItemPage {
    private final String ITEM_URL = "https://www.avito.ru/nikel/knigi_i_zhurnaly/domain-driven_design_distilled_vaughn_vernon_2639542363";
    private final String TITLE = "Domain-Driven Design Distilled Vaughn Vernon";
    public WebDriver driver;

    // Конструктор класса, инициализирующий поля
    public ItemPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // Определение локатора кнопки добавления в Избранное
    @FindBy(xpath = "//div[contains(@class,'add-favorite')]//button")
    private WebElement favoritesButton;

    public String getTITLE() {
        return TITLE;
    }
    public String getITEM_URL() {
        return ITEM_URL;
    }

    // Метод для перехода на страницу с объявлением
    public void openItemPage() {
        driver.get(getITEM_URL());
    }

    // Метод для осуществления нажатия кнопки "Добавить в избранное"
    public void clickFavoritesButton() {
        favoritesButton.click();
    }

    // Метод для перехода на страницу "Избранное"
    public void openFavorites(String url) {
        driver.get(url);
    }
}
