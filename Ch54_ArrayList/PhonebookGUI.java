import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class PhonebookGUI extends JFrame implements ActionListener
{
   PhoneBook pb;
   private final static String newline = "\n";

   JLabel firstName = new JLabel( "First Name" );
   JTextField fNameData = new JTextField( 10 );
   JPanel fNamePanel = new JPanel();

   JLabel lastName = new JLabel( "Last Name" );
   JTextField lNameData = new JTextField( 10 );
   JPanel lNamePanel = new JPanel();

   JLabel phoneNum = new JLabel( "Phone Num" );
   JTextField pNumData = new JTextField( 10 );
   JPanel pNumPanel = new JPanel();

   JButton searchButton = new JButton( "Search" );
   JPanel sButPanel = new JPanel();
   JButton addButton = new JButton( "Add" );
   JPanel aButPanel = new JPanel();
   JButton delButton = new JButton( "Delete" );
   JPanel dButPanel = new JPanel();
   JButton listButton = new JButton( "List" );
   JPanel lButPanel = new JPanel();

   JPanel dataPan = new JPanel();

   JTextArea textArea;

   JPanel inputPanel = new JPanel();
   JPanel butPanel = new JPanel();
   JPanel listPan = new JPanel();

   public PhonebookGUI()
   {
      pb = new PhoneBook();

      setTitle( "PhoneBook" );

      searchButton.setActionCommand( "search" );
      addButton.setActionCommand( "add" );
      delButton.setActionCommand( "del" );
      listButton.setActionCommand( "list" );

      searchButton.setAlignmentX( Component.CENTER_ALIGNMENT );
      addButton.setAlignmentX( Component.CENTER_ALIGNMENT );
      delButton.setAlignmentX( Component.CENTER_ALIGNMENT );
      listButton.setAlignmentX( Component.CENTER_ALIGNMENT );

      searchButton.addActionListener( this );
      addButton.addActionListener( this );
      delButton.addActionListener( this );
      listButton.addActionListener( this );
      
      fNamePanel.add( firstName );
      fNamePanel.add( fNameData );
      
      lNamePanel.add( lastName );
      lNamePanel.add( lNameData );
      
      pNumPanel.add( phoneNum );
      pNumPanel.add( pNumData );

      textArea = new JTextArea( 10, 26 );
      textArea.setEditable( false );
      JScrollPane scrollPane = new JScrollPane( textArea,
         JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
         JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
      scrollPane.setPreferredSize( new Dimension( 350, 210 ) );

      listPan.add( scrollPane );

      inputPanel.setLayout( new BoxLayout( inputPanel, BoxLayout.Y_AXIS ) );
      inputPanel.add( fNamePanel );
      inputPanel.add( lNamePanel );
      inputPanel.add( pNumPanel );

      sButPanel.add( searchButton );
      aButPanel.add( addButton );
      dButPanel.add( delButton );
      lButPanel.add( listButton );

      butPanel.setLayout( new BoxLayout( butPanel, BoxLayout.Y_AXIS ) );
      butPanel.add( sButPanel );
      butPanel.add( aButPanel );
      butPanel.add( dButPanel );
      butPanel.add( lButPanel );

      dataPan.setLayout( new BoxLayout( dataPan, BoxLayout.X_AXIS ) );
      dataPan.add( inputPanel );
      dataPan.add( butPanel );

      getContentPane().setLayout( new BoxLayout( getContentPane(),
         BoxLayout.Y_AXIS ) );
      getContentPane().add( dataPan );
      getContentPane().add( listPan );

      setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
   }

   /**
      Displays result of phonebook search
 
      @param  pe  PhoneEntry to search for
   */
   private void doSearch( PhoneEntry pe )
   {
      ArrayList<PhoneEntry> pEntryList = pb.search( pe );

      if ( !pEntryList.isEmpty() )
      {
         Iterator<PhoneEntry> iter = pEntryList.iterator();
         while ( iter.hasNext() )
         {
            textArea.append( iter.next().toString() + "\n" );
         }
      }
      else
         textArea.append( "Name not found\n" );
      textArea.append( newline );
   }
   
   /**
      Deletes the specified PhoneEntry from the phonebook.

      @param  pe  PhoneEntry to delete
    */
   private void doDelete( PhoneEntry pe )
   {
      PhoneEntry pEntry = pb.delete( pe );

      if ( pEntry == null )
         textArea.append( "Entry not found!\n" );
      else
         textArea.append( "Deleted: " + pEntry + "\n" );
      textArea.append( newline );      
   }
   
   /**
      Lists the contents of the entire phonebook
    */
   private void doList()
   {
      ArrayList<PhoneEntry> pBook = pb.getPhoneBook();
      
      Iterator<PhoneEntry> iter = pBook.iterator();
      while ( iter.hasNext() )
      {
         textArea.append( iter.next().toString() + newline);
      }
      textArea.append( newline );
      textArea.setCaretPosition( textArea.getDocument().getLength() );
   }
   
   public void actionPerformed( ActionEvent evt )
   {
      String firstName = fNameData.getText();
      String lastName = lNameData.getText();
      String phoneNum = pNumData.getText();
      
      if ( evt.getActionCommand().equals( "search" ) )
      {
         doSearch( new PhoneEntry( firstName, lastName, "" ) );
      }
      else if ( evt.getActionCommand().equals( "add" ) )
      {
         pb.add( new PhoneEntry( firstName, lastName, phoneNum ) );
      }
      else if ( evt.getActionCommand().equals( "del" ) )
      {
         doDelete( new PhoneEntry( firstName, lastName, "" ) );
      }
      else  // evt.getActionCommand().equals( "list" )
      {
         doList();
      }
      
      repaint();
   }

   public static void main( String[] args )
   {
      PhonebookGUI pbGUI = new PhonebookGUI();

      pbGUI.setSize( 400, 400 );
      pbGUI.setVisible( true );
   }
}
