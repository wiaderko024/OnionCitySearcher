import javax.swing.table.AbstractTableModel;
import java.util.List;

public class SwedenCityModel extends AbstractTableModel {

    private List<String[]> cities;

    public SwedenCityModel(List<String[]> cities) {
        this.cities = cities;
    }

    public void setCities(List<String[]> cities) {
        this.cities = cities;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kommunnamn";
            case 1:
                return "Folkmängd";
            case 2:
                return "Folk-ökning";
            case 3:
                return "Levande";
            case 4:
                return "Leva";
            case 5:
                return "Födelse-överskott";
            case 6:
            case 14:
                return "Totalt";
            case 7:
            case 11:
            case 15:
                return "Egna";
            case 8:
            case 12:
            case 16:
                return "Övriga";
            case 9:
            case 13:
            case 17:
                return "Ut-landet";
            case 18:
                return "Juste-ringar";
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
        return 19;
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
