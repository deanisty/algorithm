public class Test {
    public Integer a;

    public static void add(Test t) {
        t.a ++;
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.a = 1;

        add(t);

        System.out.println(t.a);
    }
}
