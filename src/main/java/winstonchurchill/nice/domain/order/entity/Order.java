package winstonchurchill.nice.domain.order.entity;

public class Order {
    private Long id;
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;

    public Order(Long id, Long memberId, String itemName, int itemPrice, int discountPrice) {
        this.id = id;
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }
}
