public class App {
    public static void main(String[] args) {
        Greeting greetings = new Greeting();
        Farewell farewell = new Farewell();

        System.out.println(greetings.getMessage());
        System.out.println(farewell.getMessage());
    }
}