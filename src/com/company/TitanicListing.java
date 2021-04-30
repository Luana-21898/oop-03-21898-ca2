package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TitanicListing extends JFrame {


    public TitanicListing() {

        String[] columns = new String[]{
                "name", "gender", "age"
        };

        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columns);

        JTable table = new JTable(model);

        // model.addRow(new Object[]{"testName1", "testGender1", 24});
        // model.addRow(new Object[]{"testName2", "testGender2", 25});
        // model.addRow(new Object[]{"testName3", "testGender3", 26});

        TitanicQueries tq = new TitanicQueries();
        List<Passenger> passenger = tq.getPassengersByName("james");

        for (Passenger p : passenger) {

            model.addRow(new Object[]{p.name, p.gender, p.age});
        }


        this.add(new JScrollPane(table));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);


    }


}

