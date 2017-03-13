package cn.itcast.core.web.pojo;

/**
 * Created by xxb on 2017/3/13.
 */
public class BuyItem {
    private WebResultMap sku;
    private int amount = 1;

    public WebResultMap getSku() {
        return sku;
    }

    public void setSku(WebResultMap sku) {
        this.sku = sku;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (sku.get("id") == ((BuyItem)obj).getSku().get("id")) {
            return true;
        }
        return true;
    }
}
