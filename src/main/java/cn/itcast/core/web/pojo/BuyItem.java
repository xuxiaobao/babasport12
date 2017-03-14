package cn.itcast.core.web.pojo;

/**
 * Created by xxb on 2017/3/13.
 */
public class BuyItem {
    private Sku sku;
    private int amount = 1;

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
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
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BuyItem other = (BuyItem) obj;
        if (sku == null) {
            if (other.sku != null) {
                return false;
            }
        } else if (!sku.getId().equals(other.sku.getId())) {
            return false;
        }
        return true;
    }
}
