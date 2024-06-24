package ru.grigan.tests.otus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.grigan.pages.otus.CoursePage;
import ru.grigan.pages.otus.OtusCatalogPage;
import ru.grigan.tests.BaseTest;

public class OtusTest extends BaseTest {

  private final static String BASE_URL = "https://otus.ru/catalog/courses";

  @Test
  void searchCourseTest() {
    OtusCatalogPage otusCatalogPage = new OtusCatalogPage();
    otusCatalogPage.open(BASE_URL);
    CoursePage coursePage = otusCatalogPage.searchCourseByName("Java");
    Assertions.assertTrue(coursePage.getHeaderName().contains("Java"));
  }

  @Test
  void searchCoursePythonTest() {
    OtusCatalogPage otusCatalogPage = new OtusCatalogPage();
    otusCatalogPage.open(BASE_URL);
    CoursePage coursePage = otusCatalogPage.searchCourseByName("Python");
    Assertions.assertTrue(coursePage.getHeaderName().contains("Python"));
  }
}
