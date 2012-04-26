package com.github.nmorel.datagridie.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Random;

public final class Data
{
    static final String[] firstNames = { "Bob", "Mary", "James", "Jane", "Kristy", "Kirsty", "Kate", "Jeni", "Angela", "Melanie", "Kent", "William",
        "Geoff", "Jeff", "Adrian", "Amanda", "Lisa", "Elizabeth", "Prue", "Richard", "Darin", "Phillip", "Michael", "Belinda", "Samantha", "Brian",
        "Greg", "Matthew" };

    static final String[] lastNames = { "Smith", "Williams", "Jackson", "Rictor", "Nelson", "Fitzgerald", "McAlpine", "Sutherland", "Abbott", "Hall",
        "Edwards", "Gates", "Black", "Brown", "Gray", "Marwell", "Booch", "Johnson", "McTaggart", "Parklin", "Findlay", "Robinson", "Giugni", "Lang",
        "Chi", "Carmichael" };

    public static List<Person> generatePersons( int number )
    {
        List<Person> result = new ArrayList<Person>();
        for ( int i = 0; i < number; i++ )
        {
            result.add( new Person( firstNames[Random.nextInt( firstNames.length )], lastNames[Random.nextInt( lastNames.length )] ) );
        }
        return result;
    }
}
