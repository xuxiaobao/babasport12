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
                    if (it.getAmount() > item.getSku().getSkuUpperLimit()) {
                        it.setAmount(item.getSku().getSkuUpperLimit());
                    }
                    return ;
                }
            }
        }
        this.items.add(item);
    }

    /**
     * 重写equals方法
     * @param obj
     * @return
     */

}
