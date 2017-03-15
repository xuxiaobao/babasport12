package cn.itcast.core.web.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xxb on 2017/3/13.
 */
public class BuyCart {
    List<BuyItem> items = new ArrayList<BuyItem>();
    private Integer productId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public List<BuyItem> getItems() {
        return items;
    }

    public void addItem(BuyItem item) {
        if (items.contains(item)) {
            for (BuyItem it : items) {
                if (it.equals(item)) {
                    it.setAmount(it.getAmount()+item.getAmount());
                    if (item.getAmount() > 0) {
                        if (it.getAmount() > item.getSku().getSkuUpperLimit()) {
                            it.setAmount(item.getSku().getSkuUpperLimit());
                        }
                    }
                    return ;
                }
            }
        }
        this.items.add(item);
    }

    public int getProductAmount() {
        int result = 0;
        for (BuyItem item : items) {
            result += item.getAmount();
        }
        return result;
    }

    public double getProductPrice() {
        double result = 0.0;
        for (BuyItem item : items) {
            result += item.getSku().getSkuPrice()*item.getAmount();
        }
        return result;
    }

    public double getFee() {
        double result = 0.0;
        if (getProductPrice() <= 39.0) {
            result = 10.0;
        }
        return result;
    }

    public double getTotalPrice() {
        return getProductPrice()+getFee();
    }

    public void deleteItem(BuyItem item) {
        if (items.contains(item)) {
            items.remove(item);
        }
    }
}
