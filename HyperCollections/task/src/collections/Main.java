package collections;

public class Main {
  public static void main(String[] args) {
    ImmutableCollection<?> emptyCollection = ImmutableCollection.of();
    System.out.println(emptyCollection.size()); // 0
    System.out.println(emptyCollection.isEmpty()); // true

    Student student1 = new Student(1, "Student 1", "Email 1");

    ImmutableCollection<Student> addresses = ImmutableCollection.of(
            student1,
            new Student(2, "Student 2", "Email 2"),
            new Student(3, "Student 3", "Email 3"),
            new Student(4, "Student 4", "Email 4"),
            new Student(5, "Student 5", "Email 5")
    );

    Student student = new Student(1, "Student 1", "Email 1");
    System.out.println(addresses.contains(student)); // true

    ImmutableCollection<Integer> collection = ImmutableCollection.of(1, 2, 3, 4, 5);
    System.out.println(collection.isEmpty()); // false
    System.out.println(collection.size()); // 5
  }
}