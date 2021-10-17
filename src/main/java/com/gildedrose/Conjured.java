package com.gildedrose;

public class Conjured implements TypeItem{
    private final Item item;
    public Conjured(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.sellIn = item.sellIn - 1;
        decreaseQualityValidatedMinimum();

        if (item.sellIn < 0) {
            decreaseQualityValidatedMinimum();
        }
    }

    private void decreaseQualityValidatedMinimum() {
        if (item.quality > 0) {
            item.quality -= 2;
        }
    }
}
