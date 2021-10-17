package com.gildedrose;

public class TypeItemFactory {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured";

    public static TypeItem createItem(Item item){
        switch (item.name){
            case AGED_BRIE:
                return new AgedBrieItem(item);
            case BACKSTAGE_PASSES:
                return new BackstageItem(item);
            case SULFURAS:
                return new SulfurasItem(item);
            case CONJURED:
                return new Conjured(item);
            default:
                return new NormalItem(item);
        }
    }

}
