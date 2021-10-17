package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            doUpdateQuality(item);
        }
    }

    private void doUpdateQuality(Item item) {
        if (isAgedBrie(item)) {
            item.sellIn = item.sellIn - 1;
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }

            if (item.sellIn < 0) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

        } else if (isBackstagePasses(item)) {
            item.sellIn = item.sellIn - 1;
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 0) {
                item.quality = item.quality - item.quality;
            }
        } else if (isSulfuras(item)) {

        } else {
            item.sellIn = item.sellIn - 1;
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }

            if (item.sellIn < 0) {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }
            }
        }

    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePasses(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }
}
