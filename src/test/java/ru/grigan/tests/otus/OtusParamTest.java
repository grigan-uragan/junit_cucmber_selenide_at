package ru.grigan.tests.otus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.grigan.pages.otus.CoursePage;
import ru.grigan.pages.otus.OtusCatalogPage;
import ru.grigan.tests.BaseTest;

import java.util.stream.Stream;

public class OtusParamTest extends BaseTest {

  private final static String BASE_URL = "https://otus.ru/catalog/courses";

  @ParameterizedTest
  @MethodSource("params")
  void searchCourseTest(String param) {
    OtusCatalogPage otusCatalogPage = new OtusCatalogPage();
    otusCatalogPage.open(BASE_URL);
    CoursePage coursePage = otusCatalogPage.searchCourseByName(param);
    Assertions.assertTrue(coursePage.getHeaderName().contains(param));
  }

  static Stream<Arguments>params() {
    return Stream.of(
          Arguments.arguments("Java"),
          Arguments.arguments("Python")
    );
  }
}
