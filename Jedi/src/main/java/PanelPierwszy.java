import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class PanelPierwszy extends JPanel {

    JTextField nazwaZakon;
    JTextField nazwaJedi;
    JButton importZakon;
    JButton eksportZakon;
    JButton importJedi;
    JButton eksportJedi;
    JButton zarejestrujZakon;
    JButton wybierzZakon;
    JButton wyczyscZakon;
    JButton zarejestrujJedi;
    JButton wyczyscJedi;
    JTextField linkZakon;
    JTextField linkJedi;
    JSlider mocSlider;
    JComboBox kolorMieczaList;
    JRadioButton ciemna;
    JRadioButton jasna;
    ButtonGroup strona;
    JTextArea zakonArea;
    JTextArea jediArea;
    JList<Jedi> pozostaliJedi;


    public PanelPierwszy() {

        setLayout(null);

        JLabel zakonJedi = new JLabel("Zakon Jedi");
        zakonJedi.setBounds(200, 10, 100, 50);
        add(zakonJedi);

        JLabel jedi = new JLabel("Jedi");
        jedi.setBounds(700, 10, 100, 50);
        add(jedi);

        JLabel rejestracjaZakonuJedi = new JLabel("Rejestracja Zakonu Jedi");
        rejestracjaZakonuJedi.setBounds(150, 300, 300, 50);
        add(rejestracjaZakonuJedi);

        //JSeparator separator = new JSeparator (SwingConstants.VERTICAL);
        //separator.setPreferredSize(new Dimension(30,200));
        //separator.setBorder(new EmptyBorder(100, 100, 100, 205));
        //add(separator);

        JLabel rejestracjaJedi = new JLabel("Rejestracja Jedi");
        rejestracjaJedi.setBounds(700, 300, 300, 50);
        add(rejestracjaJedi);

        JLabel nazwa = new JLabel("Nazwa");
        nazwa.setBounds(100, 340, 100, 50);
        add(nazwa);

        JLabel nazwa1 = new JLabel("Nazwa");
        nazwa1.setBounds(600, 340, 100, 50);
        add(nazwa1);

        JLabel kolorMiecza = new JLabel("Kolor miecza");
        kolorMiecza.setBounds(600, 390, 100, 50);
        add(kolorMiecza);

        JLabel moc = new JLabel("Moc");
        moc.setBounds(600, 440, 100, 50);
        add(moc);

        JLabel stronaMocy = new JLabel("Strona mocy");
        stronaMocy.setBounds(700, 490, 100, 50);
        add(stronaMocy);

        nazwaZakon = new JTextField();
        nazwaZakon.setBounds(200,350, 200, 30);
        add(nazwaZakon);

        nazwaJedi = new JTextField();
        nazwaJedi.setBounds(700,350, 200, 30);
        add(nazwaJedi);

        wybierzZakon = new JButton("Wybierz");
        wybierzZakon.setBounds(100, 390, 100, 20);
        add(wybierzZakon);

        importZakon = new JButton("Import");
        importZakon.setBounds(100, 530, 100, 20);
        add(importZakon);

        eksportZakon = new JButton("Eksport");
        eksportZakon.setBounds(100, 560, 100, 20);
        add(eksportZakon);

        importJedi = new JButton("Import");
        importJedi.setBounds(600, 530, 100, 20);
        add(importJedi);

        eksportJedi = new JButton("Eksport");
        eksportJedi.setBounds(600, 560, 100, 20);
        add(eksportJedi);

        zarejestrujZakon = new JButton("Zarejestruj");
        zarejestrujZakon.setBounds(200, 600, 100, 20);
        zarejestrujZakon.addActionListener(new DodawanieZakony());
        add(zarejestrujZakon);

        wyczyscZakon = new JButton("Wyczysc");
        wyczyscZakon.setBounds(310, 600, 100, 20);
        add(wyczyscZakon);

        zarejestrujJedi = new JButton("Zarejestruj");
        zarejestrujJedi.setBounds(650, 600, 100, 20);
        zarejestrujJedi.addActionListener(new DodawanieJedi());
        add(zarejestrujJedi);

        wyczyscJedi = new JButton("Wyczysc");
        wyczyscJedi.setBounds(760, 600, 100, 20);
        add(wyczyscJedi);

        linkZakon = new JTextField();
        linkZakon.setBounds(210,540, 200, 30);
        linkZakon.setText("c/dobrylinkZakon");
        linkZakon.setEditable(false);
        add(linkZakon);

        linkJedi = new JTextField();
        linkJedi.setBounds(710,540, 200, 30);
        linkJedi.setText("c/dobrylinkJedi");
        linkJedi.setEditable(false);
        add(linkJedi);

        mocSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 1);
        mocSlider.setBounds(700,430,200,70);
        mocSlider.setMinorTickSpacing(1);
        mocSlider.setMajorTickSpacing(100);
        mocSlider.setPaintLabels(true);
        mocSlider.setPaintTicks(true);
        add(mocSlider);

        String[] kolorMieczaMenu = { "czerwony", "niebieski", "zielony"};
        kolorMieczaList = new JComboBox(kolorMieczaMenu);
        kolorMieczaList.setBounds(700,405,100,20);
        add(kolorMieczaList);

        ciemna = new JRadioButton("ciemna");
        ciemna.setBounds(780, 500, 100, 25);
        ciemna.setActionCommand(ciemna.getText());
        add(ciemna);
        jasna = new JRadioButton("jasna");
        jasna.setBounds(890, 500, 100, 25);
        jasna.setActionCommand(jasna.getText());
        add(jasna);

        strona = new ButtonGroup();
        strona.add(ciemna);
        strona.add(jasna);

        zakonArea = new JTextArea();
        zakonArea.setBounds(100, 50, 300, 250);
        zakonArea.setText(Zakony.wypisywanieZakonow());
        add(zakonArea);

        jediArea = new JTextArea();
        jediArea.setBounds(600, 50, 300, 250);
        jediArea.setText(Jedi.wypisywanieJedi());
        add(jediArea);

        pozostaliJedi = new JList <Jedi>();
        pozostaliJedi.setBounds(210, 390, 190, 120);
        add(pozostaliJedi);

        }

    class DodawanieJedi implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent actionEvent) {
            try {
                new Jedi(nazwaJedi.getText(), Objects.requireNonNull(kolorMieczaList.getSelectedItem()).toString(), mocSlider.getValue(), strona.getSelection().getActionCommand(),1);
                Jedi.wypisywanieJedi();
                nazwaJedi.setText("");
                dodawanieJediSQL();
            } catch (NullPointerException ex) {
                System.out.println("Błąd w formularzu");
            }
        }
    }

    public void dodawanieJediSQL () {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql:Jedi", "postgres", "gniewko12");
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM JEDI");
            for (Jedi j : Jedi.listaJedi)
                statement.execute("INSERT INTO JEDI (Imie, Miecz, Moc, Strona, Zakon_ID) VALUES "
                        + "('" + j.getImie() + "' , '" + j.getMiecz() + "', " + j.getMoc() + ", '" + j.getStrona() + "', " + j.getIdZakonu() + ");");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Jedi.wypisywanieJedi();
    }

    class DodawanieZakony implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent actionEvent) {
            try {
                new Zakony(nazwaZakon.getText(), 0);
                Zakony.wypisywanieZakonow();
                nazwaJedi.setText("");
                dodawanieZakonSQL();
            } catch (NullPointerException ex) {
                System.out.println("Błąd w formularzu");
            }
        }
    }

    public void dodawanieZakonSQL () {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql:Jedi", "postgres", "gniewko12");
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM ZAKON");
            for (Zakony j : Zakony.listaZakony)
                statement.execute("INSERT INTO ZAKONY (Nazwa, Ilosc_czlonkow) VALUES "
                        + "('" + j.getNazwa() + "' , " + j.getIlosc_czlonkow() + ");");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 700);
    }
}