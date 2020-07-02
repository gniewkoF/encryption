import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Jedi {
    public static List<Jedi> listaJedi = new ArrayList<Jedi>();

    static {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql:Jedi", "postgres", "gniewko12");
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery("Select * FROM Jedi;");

            while (data.next())
                new Jedi(data.getString("Imie"), data.getString("miecz"), data.getInt("moc"), data.getString("strona"), data.getInt("zakon_id"));

            for (Jedi o : Jedi.listaJedi)
                System.out.println(o);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    private String imie;
    private String miecz;
    private int moc;
    private String strona;
    private int idzakonu;



    public Jedi(String imie, String miecz, int moc,String stronaMocy, int idzakonu) {
        this.imie = imie;
        this.miecz = miecz;
        this.moc = moc;
        this.strona = stronaMocy;
        this.idzakonu = idzakonu;
        listaJedi.add(this);
    }
    @Override
    public String toString() {
        return "Jedi [imie=" + imie + ", miecz=" + miecz + ", moc=" + moc + ", strona mocy=" + strona + "]";
    }

    public static String wypisywanieJedi () {
        String wypisywanie = "";

        for (Jedi a : Jedi.listaJedi) {
            wypisywanie += a.toString() + "\n";
        }
        return wypisywanie;
    }


    public String getImie() {
        return imie;
    }

    public String getMiecz() {
        return miecz;
    }

    public int getMoc() {
        return moc;
    }

    public String getStrona() {
        return strona;
    }


    public int getIdZakonu() {
        return idzakonu;
    }


    public static boolean czyJediIstnieje(String imie) {
        for (Jedi j: listaJedi)
            if (j.getImie().equals(imie)) {
                return true;
            }
        return false;
    }
}
