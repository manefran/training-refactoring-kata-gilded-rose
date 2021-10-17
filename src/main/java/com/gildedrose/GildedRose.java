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
            doIncrementQualityValidatedMaximum(item);

            if (item.sellIn < 0) {
                doIncrementQualityValidatedMaximum(item);
            }

        } else if (isBackstagePasses(item)) {
            item.sellIn = item.sellIn - 1;
            doIncrementQualityValidatedMaximum(item);
            if (item.sellIn < 11) {
                doIncrementQualityValidatedMaximum(item);
            }

            if (item.sellIn < 6) {
                doIncrementQualityValidatedMaximum(item);
            }

            if (item.sellIn < 0) {
                item.quality -= item.quality;
            }

        } else if (isSulfuras(item)) {

        } else {
            item.sellIn = item.sellIn - 1;
            doDecraeseQualityValidatedMinimum(item);

            if (item.sellIn < 0) {
                doDecraeseQualityValidatedMinimum(item);
            }
        }

    }

    private void doDecraeseQualityValidatedMinimum(Item item) {
        if (item.quality > 0) {
            if(isConjured(item))
                item.quality -= 2;
            else
                item.quality--;
        }
    }

    private void doIncrementQualityValidatedMaximum(Item item) {
        if (item.quality < 50) {
            item.quality++;
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

    private boolean isConjured(Item item) {
        return item.name.equals("Conjured");
    }
}
