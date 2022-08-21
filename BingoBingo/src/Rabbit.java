public class Rabbit extends Animal {

    private String imagePath;

    // 兔子
    public Rabbit(String color) {
        super(color);
        if (color.equals("red")) {
            imagePath = "rabbits/redrabbit.png";
        } else if (color.equals("white")) {
            imagePath = "rabbits/whiterabbit.png";
        } else if (color.equals("yellow")) {
            imagePath = "rabbits/yellowrabbit.png";
        } else {
            imagePath = "rabbits/blackrabbit.png";
        }
    }

    public String getImagePath(){
        return imagePath;
    }

}
