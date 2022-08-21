public class Gorilla extends Animal {

    private String imagePath;

    // 猩猩 (金剛)
    public Gorilla(String color) {
        super(color);
        if (color.equals("red")) {
            imagePath = "gorillas/redgorilla.png";
        } else if (color.equals("white")) {
            imagePath = "gorillas/whitegorilla.png";
        } else if (color.equals("yellow")) {
            imagePath = "gorillas/yellowgorilla.png";
        } else {
            imagePath = "gorillas/blackgorilla.png";
        }
    }

    public String getImagePath(){
        return imagePath;
    }


}
