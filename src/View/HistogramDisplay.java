package View;



import Model.Histogram;
import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.Dimension;
import javax.swing.JPanel;


public class HistogramDisplay extends ApplicationFrame {
    private final Histogram<String> histogram;

    public HistogramDisplay(Histogram<String> histogram) {
        super("HISTOGRAM");
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }
    public void execute(){
        setVisible(true);
    }
    
    private JPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataSet()));
        chartPanel.setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataset){
        JFreeChart chart = ChartFactory.createBarChart("Histograma JFreeChart",
                                                        "Dominio email",
                                                        "Nº de emails",
                                                        dataset,
                                                        PlotOrientation.VERTICAL,
                                                        false, false, 
                                                        rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataSet(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for(String key : histogram.keySet())
            dataSet.addValue(histogram.get(key), "", key);
        return dataSet;
    }
}
