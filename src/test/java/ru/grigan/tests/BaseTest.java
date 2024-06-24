package ru.grigan.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

  public void setup() {
    WebDriverManager.chromiumdriver().setup();
    Configuration.pageLoadTimeout = 60000;
    Configuration.browser = "chrome";
    Configuration.driverManagerEnabled = true;
    Configuration.browserSize = "1920x1080";
    Configuration.headless = false;
  }

  @BeforeEach
  public void init() {
    setup();
  }

  @AfterEach
  public void tearDown() {
    Selenide.closeWebDriver();
  }
}
