public class Giraffe extends Animal {

    private String imagePath;

    // 長頸鹿
    public Giraffe(String color) {
        super(color);
        if (color.equals("red")) {
            imagePath = "giraffes/redgiraffe.png";
        } else if (color.equals("white")) {
            imagePath = "giraffes/whitegiraffe.png";
        } else if (color.equals("yellow")) {
            imagePath = "giraffes/yellowgiraffe.png";
        } else {
            imagePath = "giraffes/blackgiraffe.png";
        }
    }

    public String getImagePath(){
        return imagePath;
    }
}
