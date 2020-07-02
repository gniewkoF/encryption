import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertFalse;

public class testy {

    JTextField nazwaJedi = null;
    JComboBox kolorMieczaList;
    String strona;
    JSlider mocSlider;


    @Test
    public void tworzenieJediDlugi () {


        nazwaJedi.setText("esfsvdrhtr565y5v65v34c43f3g4hg56h5h");
        kolorMieczaList.setSelectedIndex(1);
        mocSlider.setValue(43);
        strona = "ciemna";
        assertFalse(dodawanieJedi());
    }

    public boolean dodawanieJedi() {
        if (Jedi.czyJediIstnieje(nazwaJedi.getText())) {
            JOptionPane.showMessageDialog(null,"Rycerz Jedi już istneje w bazie!", "Błąd rejstracji", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (nazwaJedi.getText().length() < 1 || nazwaJedi.getText().length() > 20) {
            JOptionPane.showMessageDialog(null,"Zła nazwa Rycerza Jedi!", "Błąd rejstracji", JOptionPane.WARNING_MESSAGE);
            return false;
        } else
            try {
                return true;
                //Tworzy Jedi
            } catch (NullPointerException ex){
                JOptionPane.showMessageDialog(null,"Źle zdefiniowany rycerz Jedi!", "Błąd rejstracji", JOptionPane.WARNING_MESSAGE);
                return false;
            }
    }

    /**
     * Dodawanie Jedi z zbyt długim imieniem
     */




    }



