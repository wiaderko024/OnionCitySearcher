import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CityModel extends AbstractTableModel {

    private List<String[]> cities;

    public CityModel(List<String[]> cities) {
        this.cities = cities;
    }

    public void setCities(List<String[]> cities) {
        this.cities = cities;
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Nazwa miejscowości";
            case 1 -> "Rodzaj";
            case 2 -> "Gmina";
            case 3 -> "Powiat";
            case 4 -> "Województwo";
            case 5 -> "Identyfikator";
            case 6 -> "Dopełniacz";
            case 7 -> "Przymiotnik";
            default -> "Nothing";
        };
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
