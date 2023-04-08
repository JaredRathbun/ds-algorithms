package tree;

public class FamilyMember implements Comparable<FamilyMember> {
    public int age;
    public String name;

    public FamilyMember(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(FamilyMember o) {
        return (this.age > o.age) ? 1 : -1;
    }

    @Override
    public String toString() {
        return String.format("%s, %d", name, age);
    }
}
