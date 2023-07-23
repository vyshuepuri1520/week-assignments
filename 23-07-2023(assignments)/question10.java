import java.util.*;

class Student {
    int id;
    String name;
    double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    int getID() {
        return id;
    }

    String getName() {
        return name;
    }

    double getCGPA() {
        return cgpa;
    }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getCGPA() != s2.getCGPA())
            return Double.compare(s2.getCGPA(), s1.getCGPA());
        if (!s1.getName().equals(s2.getName()))
            return s1.getName().compareTo(s2.getName());
        return Integer.compare(s1.getID(), s2.getID());
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<>(new StudentComparator());

        for (String event : events) {
            String[] parts = event.split(" ");
            if (parts[0].equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                pq.add(new Student(id, name, cgpa));
            } else if (parts[0].equals("SERVED")) {
                pq.poll();
            }
        }

        List<Student> remainingStudents = new ArrayList<>(pq);
        Collections.sort(remainingStudents, new StudentComparator());

        return remainingStudents;
    }
}

public class question10 {
    public static void main(String[] args) {
        List<String> events = new ArrayList<>();
        events.add("ENTER John 3.75 50");
        events.add("ENTER Mark 3.8 24");
        events.add("ENTER Shafaet 3.7 35");
        events.add("SERVED");
        events.add("SERVED");
        events.add("ENTER Samiha 3.85 36");
        events.add("SERVED");
        events.add("ENTER Ashley 3.9 42");
        events.add("ENTER Maria 3.6 46");
        events.add("ENTER Anik 3.95 49");
        events.add("ENTER Dan 3.95 50");
        events.add("SERVED");

        Priorities priorities = new Priorities();
        List<Student> remainingStudents = priorities.getStudents(events);

        if (remainingStudents.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student student : remainingStudents) {
                System.out.println(student.getName());
            }
        }
    }
}