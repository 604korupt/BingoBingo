public class Crab extends Animal {

    private String imagePath;

    // 螃蟹
    public Crab(String color) {
        super(color);
        if (color.equals("red")) {
            imagePath = "crabs/redcrab.png";
        } else if (color.equals("white")) {
            imagePath = "crabs/whitecrab.png";
        } else if (color.equals("yellow")) {
            imagePath = "crabs/yellowcrab.png";
        } else {
            imagePath = "crabs/blackcrab.png";
        }
    }

    public String getImagePath(){
        return imagePath;
    }
}
