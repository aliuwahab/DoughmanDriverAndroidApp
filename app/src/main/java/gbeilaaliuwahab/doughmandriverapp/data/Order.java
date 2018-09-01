package gbeilaaliuwahab.doughmandriverapp.data;

public class Order {

    private int orderImage;
    private String orderTitle;
    private String orderAmount;
    private String orderDescription;

    public Order(int imageResource, String title, String amount, String description){
        orderImage = imageResource;
        orderTitle = title;
        orderAmount = amount;
        orderDescription = description;
    }


    public int getOrderImage(){

        return orderImage;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public String getOrderDescription() {
        return orderDescription;
    }


}
