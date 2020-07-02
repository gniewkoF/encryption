import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Zakony {
    public static List<Zakony> listaZakony = new ArrayList<Zakony>();

    static {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql:Jedi", "postgres", "gniewko12");
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery("Select * FROM Zakon;");

            while (data.next())
                new Zakony(data.getString("nazwa"), data.getInt("ilosc_czlonkow"));

            for (Zakony o : Zakony.listaZakony)
                System.out.println(o);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    private String nazwa;
    private int ilosc_czlonkow = 0;

    public Zakony(String nazwa, int ilosc_czlonkow) {
        this.nazwa = nazwa;
        this.ilosc_czlonkow = ilosc_czlonkow;
        listaZakony.add(this);
    }
    @Override
    public String toString() {
        return "Zakon " + nazwa;
    }

    public static String wypisywanieZakonow () {
        String wypisywanie = "";

        for (Zakony a : Zakony.listaZakony) {
            wypisywanie += a.toString() + "\n";
        }
        return wypisywanie;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getIlosc_czlonkow() {
        return ilosc_czlonkow;
    }
}
