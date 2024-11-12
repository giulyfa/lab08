package it.unibo.deathnote;

import java.util.*;

import org.junit.jupiter.api.Test;

import static it.unibo.deathnote.api.DeathNote.RULES;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.DeathNoteImplementation;

class TestDeathNote {
    private DeathNote note;

    public static final String NAME = "LORENZO";
    public static final String OTHER = "MARTINA";

    void setUp(){
        this.note = new DeathNoteImplementation();
    }

    public void testRules(){
        for(final var i : List.of(-1, 0, RULES.size()+1)){
            try{
                note.getRule(i);
                fail();
            }catch(IllegalArgumentException e){
                assertFalse(e.getMessage()!=null);
                assertFalse(e.getMessage().isBlank());
                assertFalse(e.getMessage().isEmpty());
            }
        }
    }

    @Test
    public void testEmptyRules(){
        for(final var elem : RULES){
            assertFalse(elem.isBlank());
            assertFalse(elem != null);
        }
    }
    
    @Test
    public void testDeath(){
        assertFalse(note.isNameWritten(NAME));
        note.writeName(NAME);
        assertTrue(note.isNameWritten(NAME));
        assertFalse(note.isNameWritten(OTHER));
        assertFalse(note.isNameWritten(""));
    }
}