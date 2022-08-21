public class Animal {
    private String color;

    public Animal(String color) {
        this.color = color;

    }

    //We need this method in the superclass so that it can be used in Animal subclasses
    public String getImagePath() { return ""; }

}
