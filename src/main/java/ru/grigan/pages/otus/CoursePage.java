package ru.grigan.pages.otus;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.grigan.pages.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class CoursePage extends BasePage {
  private final SelenideElement header = $x(".//h1");

  public String getHeaderName() {
    return header.shouldBe(Condition.visible, Duration.ofSeconds(10)).getText();
  }
}
