package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private final String NORMAL = "normal item";
    private final String AGED_BRIE = "Aged Brie";
    private final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";


    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    //La calidad de un artículo nunca es negativa
    @Test
    void normalItemQualityIsNeverNegative() {
        Item[] items = new Item[] { new Item(NORMAL, 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    //La calidad de un articulo se degrada cada día
    @Test
    void normalItemQualityDecreesesByOneBeforeMaximunDate() {
        Item[] items = new Item[] { new Item(NORMAL, 1, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    //Una vez que ha pasado la fecha recomendada de venta, la calidad se degrada al doble de velocidad
    @Test
    void normalItemQualityDecreesesByTwoAfterMaximunDate() {
        Item[] items = new Item[] { new Item(NORMAL, 0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    //La calidad de un artículo nunca es mayor a 50
    @Test
    void agedBrieItemQualityFiftyMaximum() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void backstageItemQualityFiftyMaximum() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    //El artículo "Sulfuras" (Sulfuras), siendo un artículo legendario, no modifica su fecha de venta ni se degrada en calidad
    @Test
    void sulfurasNeverUpdateQualityAndSellinValue() {
        Item[] items = new Item[] { new Item(SULFURAS, 1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    //El "Queso Brie envejecido" (Aged brie) incrementa su calidad a medida que se pone viejo
    //Su calidad aumenta en 1 unidad cada día
    @Test
    void agedBrieIncreasesQualityByOneBeforeMaximunDate() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }
    //luego de la fecha de venta su calidad aumenta 2 unidades por día
    @Test
    void agedBrieIncreasesQualityByTwoAfterMaximunDate() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    //Una "Entrada al Backstage", como el queso brie, incrementa su calidad a medida que la fecha de venta se aproxima
    //si faltan 10 días o menos para el concierto, la calidad se incrementa en 2 unidades
    @Test
    void backstageIncreasesQualityByTwoBeforeTenDays() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 10, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }
    //si faltan 5 días o menos, la calidad se incrementa en 3 unidades
    @Test
    void backstageIncreasesQualityByThreeBeforeFiveDays() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 5, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].quality);
    }
    //luego de la fecha de venta la calidad cae a 0
    @Test
    void backstageDecreesesQualityToCeroAfterMaximunDate() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    //TODO: Los artículos conjurados degradan su calidad al doble de velocidad que los normales


}
