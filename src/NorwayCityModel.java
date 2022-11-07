import javax.swing.table.AbstractTableModel;
import java.util.List;

public class NorwayCityModel extends AbstractTableModel {

    private List<String[]> cities;

    public NorwayCityModel(List<String[]> cities) {
        this.cities = cities;
    }

    public void setCities(List<String[]> cities) {
        this.cities = cities;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Skrivemåte";
            case 1:
                return "Skrivemåte-status";
            case 2:
                return "Skrivemåtestatus-dato";
            case 3:
                return "Språk";
            case 4:
                return "Navneobjekt-type";
            case 5:
                return "Vedtaksmyndighet";
            case 6:
                return "Kommune";
            default:
                return "Nothing";
        }
    }

    @Override
    public int getRowCount() {
        return this.cities.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        try {
            return this.cities.get(rowIndex)[columnIndex];
        } catch (Exception e) {
            return null;
        }
    }

}
