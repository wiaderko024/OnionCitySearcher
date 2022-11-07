import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PolandCityModel extends AbstractTableModel {

    private List<String[]> cities;

    public PolandCityModel(List<String[]> cities) {
        this.cities = cities;
    }

    public void setCities(List<String[]> cities) {
        this.cities = cities;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nazwa miejscowości";
            case 1:
                return "Rodzaj";
            case 2:
                return "Gmina";
            case 3:
                return "Powiat";
            case 4:
                return "Województwo";
            case 5:
                return "Identyfikator";
            case 6:
                return "Dopełniacz";
            case 7:
                return "Przymiotnik";
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
        return 8;
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
