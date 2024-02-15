import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return !s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeLeftEnd() {
    List<String> left = Arrays.asList("a", "d");
    List<String> right = Arrays.asList("a", "b", "c");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeRightEmpty() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList();
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "b", "c");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeLeftEmpty() {
    List<String> left = Arrays.asList();
    List<String> right = Arrays.asList("a", "b", "c");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "b", "c");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeBothEmpty() {
    List<String> left = Arrays.asList();
    List<String> right = Arrays.asList();
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList();
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testFilterAllTrue() {
    List<String> list = Arrays.asList("Mercury", "Venus", "Earth",
        "Mars","Jupiter", "Saturn", "Uranus", "Neptune");
    assertEquals(list, ListExamples.filter(list, new IsMoon()));
  }

  @Test(timeout = 500)
  public void testFilterSomeTrue() {
    List<String> list = Arrays.asList("Mercury", "Venus", "Moon", "Earth",
        "Mars","Jupiter", "Saturn", "Moon", "Uranus", "Neptune");
    List<String> expected = Arrays.asList("Mercury", "Venus", "Earth",
        "Mars","Jupiter", "Saturn", "Uranus", "Neptune");
    assertEquals(expected, ListExamples.filter(list, new IsMoon()));
  }

  @Test(timeout = 500)
  public void testFilterAllFalse() {
    List<String> list = Arrays.asList("Moon", "Moon", "Moon");
    List<String> expected = Arrays.asList();
    assertEquals(expected, ListExamples.filter(list, new IsMoon()));
  }
}
