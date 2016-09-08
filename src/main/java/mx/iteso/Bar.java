package mx.iteso;

/**
 * Created by Erick on 06/09/2016.
 */
public class Bar {

    public String greet(Foo foo){
        System.out.println("Bar invokes Foo.greet");
        return foo.greet();
    }

    public String question(Foo foo, String question) {
        verifyFooConnection(foo);
        if (Foo.ANY_NEW_TOPICS.equals(question)) {
            return foo.question(question);
        }
        return "Invalid Question";
    }

    public void verifyFooConnection(Foo foo) {
        System.out.println("Is Foo available?");
        String response = foo.greet();
        if (!Foo.HELLO_WORLD.equals(response)) {
            System.out.println("No");
            throw new FooNotAvailable();
        }
        System.out.println("Yes");
    }

    public String questionStrictly(Foo foo, String question) throws InvalidQuestion {
        verifyFooConnection(foo);
        String answer= foo.questionStrictly(question);
        return answer;
    }

}
