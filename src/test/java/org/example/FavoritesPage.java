package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Страница с избранными объявлениями
 */

public class FavoritesPage {
    private final String FAVORITES_URL = "https://www.avito.ru/favorites";

    // Конструктор класса, инициализирующий поля
    public WebDriver driver;
    public FavoritesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // Определение локатора кнопки удаления из Избранного на странице избранных объявлений
    @FindBy(xpath = "//div[contains(@class,'withFavorites')]")
    private WebElement favoritesHeart;

    public String getURL() {
        return FAVORITES_URL;
    }

    // Метод для осуществления нажатия кнопки "удалить из избранного"
    public void removeFromFavorites() {
        favoritesHeart.click();
    }
}
