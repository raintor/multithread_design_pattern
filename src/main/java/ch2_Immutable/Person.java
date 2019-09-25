package ch2_Immutable;

/**
 * @author: raintor
 * @Date: 2019/9/25 14:04
 * @Description:
 */
public final class Person {
    private final String name;
    private final String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    /**
     * 设置person类的时候，把person类设置为final类型的，这样子类就不会继承，从而改变内部
     * 设置person内部属性的时候，使用private final修饰，这样就不会被改变
     * 从而保证了Person类是immutable的了。
     */
}
