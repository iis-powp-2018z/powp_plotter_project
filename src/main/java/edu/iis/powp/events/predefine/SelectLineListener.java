package edu.iis.powp.events.predefine;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.adapter.LinePlotterAdapter;
import edu.iis.powp.app.DriverManager;
import edu.kis.powp.drawer.shape.ILine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectLineListener implements ActionListener {

    private DriverManager driverManager;
    private ILine line;

    public SelectLineListener(DriverManager driverManager, ILine line) {
        this.driverManager = driverManager;
        this.line = line;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        IPlotter plotter = driverManager.getCurrentPlotter();
        //todo aby pozbyć się kolejnych instanceof muszę wydzielić linię to klasy wyżej i z niej dziedziczyć DemoPlotter i LinePlotter
        //jedyny problem, że bez zmiany interfejsu tej jednej instanceof się nie pozbędziemy
        if (plotter instanceof LinePlotterAdapter) {
            ((LinePlotterAdapter) plotter).setLine(this.line);
        }
    }
}
