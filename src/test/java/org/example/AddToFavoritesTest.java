package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class AddToFavoritesTest {
    public static ItemPage itemPage;
    public static FavoritesPage favoritesPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        // Скачиваем драйвер, определяем путь до него и осуществляем необходимые настройки
        WebDriverManager.chromedriver().setup();
        // Создаем экземпляр драйвера
        driver = new ChromeDriver();
        itemPage = new ItemPage(driver);
        favoritesPage = new FavoritesPage(driver);
        // Открываем страницу браузера на весь экран
        driver.manage().window().maximize();
        // Задаем время ожидания загрузки элементов на странице
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void addToFavoritesTest() {
        // Открываем страницу нужного нам объявления в браузере
        itemPage.openItemPage();
        // Добавляем объявление в "Избранное"
        itemPage.clickFavoritesButton();
        // Переходим на страницу "Избранное"
        itemPage.openFavorites(favoritesPage.getURL());

        // Осуществляем проверку добавления в "Избранное"
        WebElement favoriteItem = driver.findElement(By.linkText(itemPage.getTITLE()));
        if (favoriteItem != null) {
            System.out.println("Объявление было успешно добавлено в \"Избранное\"!");
        } else {
            System.out.println("Error! Объявление не найдено в списке избранных.");
        }
    }

    @AfterClass
    public static void tearDown() {
        // Удаляем из избранных
        favoritesPage.removeFromFavorites();
        // Закрываем браузер
        driver.quit();
    }
}