package com.gildedrose;

public class BackstageItem implements TypeItem{
    private final Item item;
    public BackstageItem(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.sellIn = item.sellIn - 1;
        doIncrementQualityValidatedMaximum();
        if (item.sellIn < 11) {
            doIncrementQualityValidatedMaximum();
        }

        if (item.sellIn < 6) {
            doIncrementQualityValidatedMaximum();
        }

        if (item.sellIn < 0) {
            item.quality -= item.quality;
        }
    }

    private void doIncrementQualityValidatedMaximum() {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
