package com.github.nmorel.datagridie.client;

import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class DataGridIE
    implements EntryPoint
{

    /**
     * This is the entry point method.
     */
    public void onModuleLoad()
    {
        HorizontalPanel panel = new HorizontalPanel();

        DataGrid<Person> table = new DataGrid<Person>();
        table.setPixelSize( 400, 500 );

        panel.add( table );

        final FlowPanel updatePanel = new FlowPanel();
        panel.add( updatePanel );

        Column<Person, String> firstNameColumn = new Column<Person, String>( new EditTextCell() )
        {
            @Override
            public String getValue( Person object )
            {
                return object.getFirstName();
            }
        };
        firstNameColumn.setFieldUpdater( new FieldUpdater<Person, String>()
        {
            @Override
            public void update( int index, Person object, String value )
            {
                updatePanel.add( new Label( "Updating first name : " + value ) );
                object.setFirstName( value );
            }
        } );
        table.addColumn( firstNameColumn, "First Name" );

        Column<Person, String> lastNameColumn = new Column<Person, String>( new EditTextCell() )
        {
            @Override
            public String getValue( Person object )
            {
                return object.getLastName();
            }
        };
        lastNameColumn.setFieldUpdater( new FieldUpdater<Person, String>()
        {
            @Override
            public void update( int index, Person object, String value )
            {
                updatePanel.add( new Label( "Updating last name : " + value ) );
                object.setLastName( value );
            }
        } );
        table.addColumn( lastNameColumn, "Last Name" );

        table.setRowData( Data.generatePersons( 50 ) );

        RootPanel.get().add( panel );
    }
}
