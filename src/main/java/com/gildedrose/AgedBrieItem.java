package com.gildedrose;

public class AgedBrieItem implements TypeItem{
    private final Item item;

    public AgedBrieItem(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.sellIn = item.sellIn - 1;
        doIncrementQualityValidatedMaximum();

        if (item.sellIn < 0) {
            doIncrementQualityValidatedMaximum();
        }
    }

    private void doIncrementQualityValidatedMaximum() {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
