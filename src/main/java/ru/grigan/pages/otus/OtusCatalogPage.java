package ru.grigan.pages.otus;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.grigan.pages.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница с каталогом курсов
 */

public class OtusCatalogPage extends BasePage {

  private final SelenideElement searchInput = $x(".//label[text()='Поиск']/following-sibling::input");
  private final SelenideElement inputLabel = $x(".//label[text()='Поиск']/..");
  private final ElementsCollection courseList = $$x(".//section/div[.//label[text()='Поиск']]/following-sibling::div/.//a[contains(@href, 'lessons')]");

  public CoursePage searchCourseByName(String courseName) {
    inputLabel.click();
    searchInput.setValue(courseName);
    searchInput.sendKeys(Keys.ENTER);
    courseList.shouldBe(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(10))
          .asDynamicIterable()
          .stream()
          .filter(p -> p.getText().contains(courseName))
          .findFirst().orElseThrow().click();
    return new CoursePage();
  }
}
