package com.mycompany.poeevents1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PoeEventS1Test {
    
    @BeforeEach
    void setUp() {
        Event.eventList.clear();

        EventModel event = new EventModel();
        event.EventId = "T1";
        event.EventName = "Cape Town Show";
        event.EventType = "Music";
        event.EventDate = "2025-10-01";
        event.EventLocation = "Cape Town";
        Event.eventList.add(event);
    }

    @Test
    void TestSearchEvent() {
        EventModel found = Event.searchEventById("T1");
        assertNotNull(found);
        assertEquals("Cape Town Show", found.EventName);
    }

    @Test
    void TestSearchEvent_EventNotFound() {
        EventModel found = Event.searchEventById("T32");
        assertNull(found);
    }

    @Test
    void TestUpdateEvent() {
        boolean updated = Event.updateEventById("T1", "Jazz Festival", "Music", "2025-11-01", "Durban");
        assertTrue(updated);
        EventModel updatedEvent = Event.searchEventById("T1");
        assertEquals("Jazz Festival", updatedEvent.EventName);
        assertEquals("2025-11-01", updatedEvent.EventDate);
        assertEquals("Durban", updatedEvent.EventLocation);
    }

    @Test
    void TestDeleteEvent() {
        boolean deleted = Event.deleteEventById("T1");
        assertTrue(deleted);
        assertNull(Event.searchEventById("T1"));
    }

    @Test
    void TestDeleteEvent_EventNotFound() {
        boolean deleted = Event.deleteEventById("T83");
        assertFalse(deleted);
    }
}
