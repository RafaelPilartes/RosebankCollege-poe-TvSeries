package com.mycompany.poetvseriess1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PoeTvSeriesS1Test {
@BeforeEach
    void setUp() {
        Series.seriesList.clear();

        SeriesModel series = new SeriesModel();
        series.SeriesId = "S1";
        series.SeriesName = "Test Series";
        series.SeriesAge = "10";
        series.SeriesNumberOfEpisodes = "5";
        Series.seriesList.add(series);
    }

    @Test
    void TestSearchSeries() {
        SeriesModel found = Series.searchSeriesById("S1");
        assertNotNull(found);
        assertEquals("Test Series", found.SeriesName);
    }

    @Test
    void TestSearchSeries_SeriesNotFound() {
        SeriesModel found = Series.searchSeriesById("S99");
        assertNull(found);
    }

    @Test
    void TestUpdateSeries() {
        boolean updated = Series.updateSeriesById("S1", "New Name", "15", "12");
        assertTrue(updated);
        SeriesModel updatedSeries = Series.searchSeriesById("S1");
        assertEquals("New Name", updatedSeries.SeriesName);
        assertEquals("15", updatedSeries.SeriesAge);
    }

    @Test
    void TestDeleteSeries() {
        boolean deleted = Series.deleteSeriesById("S1");
        assertTrue(deleted);
        assertNull(Series.searchSeriesById("S1"));
    }

    @Test
    void TestDeleteSeries_SeriesNotFound() {
        boolean deleted = Series.deleteSeriesById("S99");
        assertFalse(deleted);
    }

    @Test
    void TestSeriesAgeRestriction_AgeValid() {
        assertTrue(Series.isValidAge("10"));
        assertTrue(Series.isValidAge("2"));
        assertTrue(Series.isValidAge("18"));
    }

    @Test
    void TestSeriesAgeRestriction_SeriesAgeInValid() {
        assertFalse(Series.isValidAge("1"));
        assertFalse(Series.isValidAge("19"));
        assertFalse(Series.isValidAge("abc"));
    }    
}
